package com.nlpige.tourist.api;

import com.nlpige.tourist.core.tour.model.Place;
import com.nlpige.tourist.core.tour.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "place")
public class PlaceAPI {
    @Autowired
    PlaceService placeService;

    @GetMapping("/all")
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }
}
