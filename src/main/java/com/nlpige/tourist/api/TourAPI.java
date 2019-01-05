package com.nlpige.tourist.api;

import com.nlpige.tourist.core.collaborator.model.Collaborator;
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

    @GetMapping(value = "/waiting")
    public List<Tour> getWaiting() {
     // TODO
     return null;
    }

    @PostMapping(value = "register")
    public boolean registerTour() {
        // TODO
        // save new collection with id tour and email collaborator
        return false;
    }

    @PostMapping
    public Tour createTour(@RequestBody Tour tour) {
        return tourService.createTour(tour);
    }

    @PutMapping
    public Tour acceptTour(@RequestHeader String id, @RequestBody Collaborator collaborator) {
        return tourService.acceptTour(id, collaborator);
    }

    @DeleteMapping
    public void cancelTour(@RequestHeader String id) {
        tourService.deleteTour(id);
    }
}