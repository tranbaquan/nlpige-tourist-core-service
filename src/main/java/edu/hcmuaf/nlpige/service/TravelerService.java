package edu.hcmuaf.nlpige.service;

import edu.hcmuaf.nlpige.domain.TravelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelerService {
    @Autowired
    private TravelerRepository travelerRepository;

}
