package com.nlpige.tourist.core.tour.service;

import com.nlpige.tourist.core.tour.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceRepository extends MongoRepository<Place, String> {
}
