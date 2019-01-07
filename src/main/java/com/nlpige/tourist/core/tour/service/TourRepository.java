package com.nlpige.tourist.core.tour.service;

import com.nlpige.tourist.core.tour.model.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TourRepository extends MongoRepository<Tour, String> {
    List<Tour> findByTraveler_Email(String email);

    List<Tour> findByTourGuide_Email(String email);

    List<Tour> findByTourGuideNull();

    Tour findFirstByTourGuide_EmailAndTraveler_Email(String tourGuideEmail, String travelerEmail);

    List<Tour> findByTraveler_EmailOrderByStartDateDesc(String travelerEmail);

    List<Tour> findByTourGuide_EmailOrderByStartDateDesc(String tourGuideEmail);
}
