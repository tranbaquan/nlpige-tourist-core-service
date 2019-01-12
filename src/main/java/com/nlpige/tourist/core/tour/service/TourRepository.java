package com.nlpige.tourist.core.tour.service;

import com.nlpige.tourist.core.tour.model.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TourRepository extends MongoRepository<Tour, String> {

    List<Tour> findByTourGuideNull();

    Tour findFirstByTourGuide_EmailAndTraveler_Email(String tourGuideEmail, String travelerEmail);

    List<Tour> findByTraveler_EmailOrderByStartDateAsc(String travelerEmail);

    List<Tour> findByTourGuide_EmailOrderByStartDateAsc(String tourGuideEmail);


}
