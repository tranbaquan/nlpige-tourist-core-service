package com.nlpige.tourist.core.tour.service;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.nlpige.tourist.config.SpringMongoConfig;
import com.nlpige.tourist.core.collaborator.model.Collaborator;
import com.nlpige.tourist.core.collaborator.service.CollaboratorService;
import com.nlpige.tourist.core.tour.model.Place;
import com.nlpige.tourist.core.tour.model.Tour;
import com.nlpige.tourist.core.traveler.model.Traveler;
import com.nlpige.tourist.exception.CannotDeleteTour;
import com.nlpige.tourist.exception.CollaboratorExistence;
import com.nlpige.tourist.exception.NLPigeException;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {
    @Autowired
    TourRepository tourRepo;
    @Autowired
    CollaboratorService collaboratorService;
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

    public Tour acceptTour(String id, Collaborator collaborator) {
        Tour tour = getTour(id);
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
}
