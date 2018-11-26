package edu.hcmuaf.nlpige.controller;

import edu.hcmuaf.nlpige.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/traveler")
public class TravelerController {
    @Autowired
    private TravelerService travelerService;
}
