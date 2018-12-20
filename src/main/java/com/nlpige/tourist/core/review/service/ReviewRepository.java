package com.nlpige.tourist.core.review.service;

import com.nlpige.tourist.core.review.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by IntelliJ on Thursday, 20 December, 2018 at 11:24.
 *
 * @author Joseph Maria
 */
public interface ReviewRepository extends MongoRepository<Review, String> {
    Optional<Review> findByTour_Id(String tourId);
}
