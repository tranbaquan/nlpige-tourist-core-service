package com.nlpige.tourist.core.tour.service;

import com.nlpige.tourist.core.collaborator.model.Collaborator;
import com.nlpige.tourist.core.collaborator.service.CollaboratorService;
import com.nlpige.tourist.core.tour.model.Tour;
import com.nlpige.tourist.core.tour.model.TourRegisteringEntity;
import com.nlpige.tourist.exception.CannotDeleteTour;
import com.nlpige.tourist.exception.CollaboratorExistence;
import com.nlpige.tourist.exception.NLPigeException;
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

    public Tour getTour(String tourId) {
        Optional<Tour> tour = tourRepo.findById(tourId);
        if (!tour.isPresent()) {
            throw new NLPigeException();
        }
        return tour.get();
    }

    public List<Tour> getTravelerTours(String email) {
        return tourRepo.findByTraveler_Email(email);
    }

    public List<Tour> getCollaboratorTours(String email) {
        return tourRepo.findByTourGuide_Email(email);
    }

    public Tour createTour(Tour tour) {
        tour = tourRepo.save(tour);
        return tour;
    }

    public Tour acceptTour(String id, String email) {
        Tour tour = getTour(id);
        Collaborator collaborator = collaboratorService.getCollaborator(email);
        if (tour.getTourGuide() == null) {
            tour.setTourGuide(collaborator);
            tour.setAccepted(true);
            return tourRepo.save(tour);
        }

        throw new CollaboratorExistence();
    }

    public List<Tour> getAll() {
        return tourRepo.findAll();
    }

    public void deleteTour(String id) {
        if (getTour(id).isAccepted()) {
            throw new CannotDeleteTour();
        }
        tourRepo.deleteById(id);
    }

    public List<Tour> getWaiting() {
        return tourRepo.findByTourGuideNull();
    }

    public TourRegisteringEntity registerTour(String tourId, String collaboratorEmail) {
        if (tourRegisteringRepository.existsByTour_IdAndCollaborator_Email(tourId, collaboratorEmail)) {
            return null;
        }
        TourRegisteringEntity result = new TourRegisteringEntity(getTour(tourId), collaboratorService.getCollaborator(collaboratorEmail));
        tourRegisteringRepository.save(result);
        return result;
    }

    public List<Collaborator> getAllRegisteredCollaborator(String tourId, int offset,
                                                           int size) {
        List<TourRegisteringEntity> tourRegisteringEntities = tourRegisteringRepository.findAllByTour_Id(tourId, PageRequest.of(offset, size));
        List<Collaborator> collaborators = new ArrayList<>();
        for (TourRegisteringEntity tourRegisteringEntity : tourRegisteringEntities) {
            collaborators.add(tourRegisteringEntity.getCollaborator());
        }
        return collaborators;
    }

    public List<Collaborator> getAllRegisteredCollaborator(String tourId) {
        List<TourRegisteringEntity> tourRegisteringEntities = tourRegisteringRepository.findAllByTour_Id(tourId);
        List<Collaborator> collaborators = new ArrayList<>();
        for (TourRegisteringEntity tourRegisteringEntity : tourRegisteringEntities) {
            collaborators.add(tourRegisteringEntity.getCollaborator());
        }
        return collaborators;
    }
}
