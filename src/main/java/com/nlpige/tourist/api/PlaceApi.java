package com.nlpige.tourist.api;

import com.nlpige.tourist.core.tour.model.Place;
import com.nlpige.tourist.core.tour.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "place")
public class PlaceApi {
    @Autowired
    PlaceService placeService;

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping("{name}")
    public List<Place> findPlaceByName(@PathVariable String name) {
        return placeService.findPlaceWithName(name);
    }

    @GetMapping("range")
    public List<Place> gettingWithSize(@RequestParam int offset, @RequestParam int size) {
        return placeService.getPlaces(offset, size);
    }
}
