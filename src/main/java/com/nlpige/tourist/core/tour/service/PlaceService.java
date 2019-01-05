package com.nlpige.tourist.core.tour.service;

import com.nlpige.tourist.core.tour.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    PlaceRepository placeRepo;

    public List<Place> getAllPlaces(){
        return placeRepo.findAll();
    }
}
