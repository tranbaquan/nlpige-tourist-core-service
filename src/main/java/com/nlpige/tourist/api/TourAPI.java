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

    @GetMapping(value = "/mytours")
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

    @GetMapping(value = "getregisteredcollaborator")
    public List<Collaborator> getAllRegisteredCollaborator(@RequestHeader String tourId, @RequestHeader int offset, @RequestHeader int size) {
        return tourService.getAllRegisteredCollaborator(tourId, offset, size);
    }

    @GetMapping(value = "getallregisteredcollaborator")
    public List<Collaborator> getAllRegisteredCollaborator(@RequestHeader String tourId) {
        return tourService.getAllRegisteredCollaborator(tourId);
    }

    @GetMapping(value = "/mytours")
    public List<Tour> myTours(@RequestHeader String email) {
        return tourService.myTours(email);
    }

    @GetMapping(value = "{name}")
    public List<Tour> findByName(@PathVariable String name) {
        return tourService.findTourByName(name);
    }

    @GetMapping(value = "allcollaboratorpendingtours")
    public List<Tour> getCollaboratorPendingTours(@RequestHeader String collaboratorEmail) {
        return tourService.getAllCollaboratorPendingTours(collaboratorEmail);
    }

    @GetMapping(value = "collaboratorpendingtours")
    public List<Tour> getCollaboratorPendingTours(@RequestHeader String collaboratorEmail, @RequestHeader int offset, @RequestHeader int size) {
        return tourService.getCollaboratorPendingTours(collaboratorEmail, offset, size);
    }
}