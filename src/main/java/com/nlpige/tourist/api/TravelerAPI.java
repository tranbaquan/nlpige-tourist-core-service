package com.nlpige.tourist.api;

import com.nlpige.tourist.core.customer.model.Customer;
import com.nlpige.tourist.core.traveler.model.Traveler;
import com.nlpige.tourist.core.traveler.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "traveler")
public class TravelerAPI {

    @Autowired
    TravelerService travelerService;

    @PostMapping
    public Traveler create(@RequestBody Traveler traveler) {
        traveler = travelerService.create(traveler);
        traveler.secureData();
        return traveler;
    }

    @PostMapping(value = "login")
    public Traveler login(@RequestBody Traveler traveler) {
        traveler = travelerService.login(traveler);
        traveler.secureData();
        return traveler;
    }
}
