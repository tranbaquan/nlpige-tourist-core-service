package com.nlpige.tourist.core.tour.service;

import com.nlpige.tourist.core.collaborator.model.Collaborator;
import com.nlpige.tourist.core.tour.model.Tour;
import com.nlpige.tourist.core.traveler.model.Traveler;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TourRepository extends MongoRepository<Tour, String> {
    List<Tour> findByTraveler_Email(String email);

    List<Tour> findByTourGuide_Email(String email);

    List<Tour> findByTourGuideNull();
//List<Tour> findToursByTraveler_EmailAndTourGuide_Email(String travelerEmail, String tourGuideEmail);
}
