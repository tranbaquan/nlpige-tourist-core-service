package com.nlpige.tourist.core.tour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    @Autowired
    PriceRepository priceRepo;

    public double getPrice(String type) {
        return priceRepo.findByType(type).getPricePerTour();
    }
}
