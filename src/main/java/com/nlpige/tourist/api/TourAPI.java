package com.nlpige.tourist.api;

import com.nlpige.tourist.core.tour.model.Tour;
import com.nlpige.tourist.core.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "tour")
public class TourAPI {
    @Autowired
    TourService tourService;

    @GetMapping(value = "/mytour")
    public List<Tour> getUserTour(@RequestHeader String email) {
        List<Tour> tours = tourService.getTravelerTours(email);

        if (tours != null && !tours.isEmpty()) {
            return tours;
        }

        return tourService.getCollaboratorTours(email);
    }

    @GetMapping(value = "/all")
    public List<Tour> getAll() {
        return tourService.getAll();
    }
}