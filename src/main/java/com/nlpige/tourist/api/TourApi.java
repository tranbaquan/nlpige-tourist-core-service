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
public class TourApi {
    @Autowired
    TourService tourService;

    @GetMapping
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }

    @PutMapping
    public  Tour updateTour(@RequestBody Tour tour){
        return tourService.updateTour(tour);
    }

    @GetMapping(value = "waiting")
    public List<Tour> getWaitingTours() {
        return tourService.getWaitingTours();
    }

    @PostMapping(value = "traveler")
    public Tour createTour(@RequestBody Tour tour) {
        return tourService.createTour(tour);
    }

    @GetMapping(value = "traveler")
    public List<Tour> getTravelerTours(@RequestHeader String email) {
        return tourService.getTravelerTours(email);
    }

    @PutMapping(value = "traveler")
    public Tour acceptTour(@RequestHeader String tourId, @RequestHeader String email) {
        return tourService.acceptTour(tourId, email);
    }

    @DeleteMapping(value = "traveler")
    public void cancelTour(@RequestHeader String id) {
        tourService.deleteTour(id);
    }

    @PostMapping(value = "collaborator")
    public TourRegisteringEntity registerTour(@RequestHeader String tourId, @RequestHeader String email) {
        return tourService.registerTour(tourId, email);
    }

    @GetMapping(value = "collaborator")
    public List<Tour> getCollaboratorTours(@RequestHeader String email) {
        return tourService.getCollaboratorTours(email);
    }

    @GetMapping(value = "collaborator/pending")
    public List<Tour> getPendingTours(@RequestHeader String email){
        return tourService.getPendingTours(email);
    }

    @GetMapping(value = "registering")
    public List<Collaborator> getRegisteringCollaborators(@RequestHeader String tourId) {
        return tourService.getRegisteringCollaborators(tourId);
    }

    @DeleteMapping(value = "registering")
    public boolean cancelRegisteringTour(@RequestHeader String tourId, @RequestHeader String email) {
        return tourService.cancelTourRegistering(tourId, email);
    }
}