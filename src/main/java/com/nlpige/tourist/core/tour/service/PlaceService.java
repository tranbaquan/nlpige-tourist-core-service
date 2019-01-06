package com.nlpige.tourist.core.tour.service;

import com.nlpige.tourist.core.tour.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaceService {
    @Autowired
    PlaceRepository placeRepo;

    public List<Place> getAllPlaces() {
        return placeRepo.findAll();
    }

    public List<Place> findPlaceWithName(String name, int number) {
        return placeRepo.findPlacesByNameStartsWith(name, PageRequest.of(0, number));
    }
}
