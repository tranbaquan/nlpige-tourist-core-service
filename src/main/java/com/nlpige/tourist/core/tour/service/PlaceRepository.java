package com.nlpige.tourist.core.tour.service;

import com.nlpige.tourist.core.tour.model.Place;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface PlaceRepository extends MongoRepository<Place, String> {
    List<Place> findPlacesByNameIsContaining(String name);
}
