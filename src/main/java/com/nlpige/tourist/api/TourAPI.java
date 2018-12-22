package com.nlpige.tourist.api;

import com.nlpige.tourist.core.collaborator.model.Collaborator;
import com.nlpige.tourist.core.tour.model.Tour;
import com.nlpige.tourist.core.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "tour")
public class TourAPI {
    @Autowired
    TourService tourService;

    @GetMapping(value = "{email}")
    public List<Tour> getUserTour(@PathVariable String email) {
        List<Tour> tours = tourService.getTravelerTours(email);

        if (tours != null && !tours.isEmpty()) {
            return tours;
        }

        return tourService.getCollaboratorTours(email);
    }

    @PostMapping("/create")
    public Tour createTour(@RequestBody Tour tour) {
        return tourService.createTour(tour);
    }

    @PutMapping("/accept")
    public Tour acceptTour(@RequestHeader String id, @RequestBody Collaborator collaborator) {
        return tourService.acceptTour(id, collaborator);
    }

//    @PutMapping("/{id}")
//    public Tour acceptTour(@PathVariable String id, @RequestBody Collaborator collaborator) {
//        return tourService.acceptTour(id, collaborator);
//    }
    @GetMapping("/all")
    public List<Tour> getAllTour(){
        return tourService.getAllTour();
    }

    @DeleteMapping("/cancel")
    @ResponseStatus(HttpStatus.OK)
    public void cancelTour(@RequestHeader String id){
        tourService.deleteTour(id);
    }
}
