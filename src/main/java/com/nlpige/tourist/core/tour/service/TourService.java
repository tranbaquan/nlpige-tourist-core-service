package com.nlpige.tourist.core.tour.service;

import com.nlpige.tourist.core.collaborator.model.Collaborator;
import com.nlpige.tourist.core.collaborator.service.CollaboratorService;
import com.nlpige.tourist.core.tour.model.Tour;
import com.nlpige.tourist.core.tour.model.TourRegisteringEntity;
import com.nlpige.tourist.core.traveler.service.TravelerService;
import com.nlpige.tourist.exception.CannotDeleteTour;
import com.nlpige.tourist.exception.CollaboratorExistence;
import com.nlpige.tourist.exception.NLPigeException;
import com.nlpige.tourist.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TourService {
    @Autowired
    TourRepository tourRepo;
    @Autowired
    CollaboratorService collaboratorService;
    @Autowired
    TourRegisteringRepository tourRegisteringRepository;
    @Autowired
    PlaceRepository placeRepo;
    @Autowired
    TravelerService travelerService;
    @Autowired
    PriceService priceService;

    public Tour getTour(String tourId) {
        Optional<Tour> tour = tourRepo.findById(tourId);
        if (!tour.isPresent()) {
            throw new NLPigeException();
        }
        return tour.get();
    }

    public List<Tour> getTravelerTours(String email) {
        return tourRepo.findByTraveler_EmailOrderByStartDateAsc(email);
    }

    public List<Tour> getCollaboratorTours(String email) {
        return tourRepo.findByTourGuide_EmailOrderByStartDateAsc(email);
    }

    public Tour createTour(Tour tour) {
        tour = tourRepo.save(tour);
        return tour;
    }

    public Tour acceptTour(String tourId, String email) {
        Tour tour = getTour(tourId);
        Collaborator collaborator = collaboratorService.getCollaborator(email);
        if (tour.getTourGuide() == null) {
            tour.setTourGuide(collaborator);
            tour.setPrice(priceService.getPrice(collaborator.getType().toString()));
            tour.setAccepted(true);
            tourRegisteringRepository.deleteAllByTour_Id(tourId); // TODO: 07-Jan-19 Not tested yet
            return tourRepo.save(tour);
        }

        throw new CollaboratorExistence();
    }

    public List<Tour> getAllTours() {
        return tourRepo.findAll();
    }

    public void deleteTour(String id) {
        tourRepo.deleteById(id);
    }

    public List<Tour> getWaitingTours() {
        return tourRepo.findByTourGuideNull();
    }

    public TourRegisteringEntity registerTour(String tourId, String collaboratorEmail) {
        if (tourRegisteringRepository.existsByTour_IdAndCollaborator_Email(tourId, collaboratorEmail)) {
            return null;
        }
        Collaborator collaborator = collaboratorService.getCollaborator(collaboratorEmail);
        collaborator.secureData();
        TourRegisteringEntity result = new TourRegisteringEntity(getTour(tourId), collaborator);
        tourRegisteringRepository.save(result);
        return result;
    }

    public boolean cancelTourRegistering(String tourId, String collaboratorEmail) {
        return tourRegisteringRepository.deleteByTour_IdAndCollaborator_Email(tourId, collaboratorEmail);
    }


    public List<Collaborator> getRegisteringCollaborators(String tourId) {
        List<TourRegisteringEntity> tourRegisteringEntities = tourRegisteringRepository.findAllByTour_Id(tourId);
        List<Collaborator> collaborators = new ArrayList<>();
        for (TourRegisteringEntity tourRegisteringEntity : tourRegisteringEntities) {
            collaborators.add(tourRegisteringEntity.getCollaborator());
        }
        return collaborators;
    }

    public boolean isSameTour(String tourGuideEmail, String travelerEmail) {
        try {
            return tourRepo.findFirstByTourGuide_EmailAndTraveler_Email(tourGuideEmail, travelerEmail).isAccepted();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public List<Tour> getPendingTours(String email) {
        List<TourRegisteringEntity> data = tourRegisteringRepository.findAllByCollaborator_Email(email);
        if(data != null) {
            List<Tour> tours = new ArrayList<>();
            for (TourRegisteringEntity e: data) {
                tours.add(e.getTour());
            }
            return tours;
        }
        throw new NotFoundException();
    }

    public Tour updateTour(Tour tour) {
        deleteTour(tour.getId());
        return tourRepo.save(tour);
    }
}
