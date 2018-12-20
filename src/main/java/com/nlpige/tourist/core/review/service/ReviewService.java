package com.nlpige.tourist.core.review.service;

import com.nlpige.tourist.core.review.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ on Thursday, 20 December, 2018 at 11:51.
 *
 * @author Joseph Maria
 */
@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        reviewRepository.save(review);
        return review;
    }

    public Review getTourReview(String tourId) {
        Optional<Review> tourReview = reviewRepository.findByTour_Id(tourId);
        if (!tourReview.isPresent()) {
            // Ignore because of no review for the tour
        }
        return tourReview.get();
    }
}
