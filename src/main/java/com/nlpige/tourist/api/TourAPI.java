package com.nlpige.tourist.api;

import com.nlpige.tourist.core.collaborator.model.Collaborator;
import com.nlpige.tourist.core.tour.model.Tour;
import com.nlpige.tourist.core.tour.model.TourRegisteringEntity;
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

    @GetMapping(value = "/waiting")
    public List<Tour> getWaiting() {
        // TODO
        return tourService.getWaiting();
    }

    @PostMapping(value = "register")
    public TourRegisteringEntity registerTour(@RequestHeader String tourId, @RequestHeader String collaboratorEmail) {
        return tourService.registerTour(tourId, collaboratorEmail);
    }

    @PostMapping
    public Tour createTour(@RequestBody Tour tour) {
        return tourService.createTour(tour);
    }

    @PutMapping
    public Tour acceptTour(@RequestHeader String id, @RequestHeader String email) {
        return tourService.acceptTour(id, email);
    }

    @DeleteMapping
    public void cancelTour(@RequestHeader String id) {
        tourService.deleteTour(id);
    }
}