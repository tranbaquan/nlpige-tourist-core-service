package com.nlpige.tourist.api;

import com.nlpige.tourist.core.review.model.Review;
import com.nlpige.tourist.core.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ on Thursday, 20 December, 2018 at 12:09.
 *
 * @author Joseph Maria
 */
@RestController
@RequestMapping(value = "review")
public class ReviewApi {
    @Autowired
    ReviewService reviewService;

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        reviewService.addReview(review);
        return review;
    }

    @GetMapping
    public Review getTourReview(@RequestHeader String tourId) {
        return reviewService.getTourReview(tourId);
    }
}
