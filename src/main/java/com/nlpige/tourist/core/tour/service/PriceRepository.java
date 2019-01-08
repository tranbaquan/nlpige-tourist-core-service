package com.nlpige.tourist.core.tour.service;

import com.nlpige.tourist.core.tour.model.Price;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PriceRepository extends MongoRepository<Price,String> {
    Price findByType(String type);
}
