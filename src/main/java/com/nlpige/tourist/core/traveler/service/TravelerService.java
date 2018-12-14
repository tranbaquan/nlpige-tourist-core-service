package com.nlpige.tourist.core.traveler.service;

import com.nlpige.tourist.core.traveler.model.Traveler;
import com.nlpige.tourist.exception.DuplicateEmailException;
import com.nlpige.tourist.exception.NotFoundException;
import com.nlpige.tourist.utils.UserInformationVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TravelerService {
    @Autowired
    TravelerRepository travelerRepo;

    public Traveler login(Traveler traveler) {
        UserInformationVerifier.verifyCustomer(traveler);
        Optional<Traveler> data = travelerRepo.findByEmailAndPassword(traveler.getEmail(), traveler.getPassword());
        System.out.println(traveler.getEmail());
        System.out.println(traveler.getPassword());
        if(!data.isPresent()) {
            throw new NotFoundException();
        }
        return data.get();
    }

    public Traveler create(Traveler traveler) {
        UserInformationVerifier.verifyCustomer(traveler);
        Optional<Traveler> data = travelerRepo.findByEmail(traveler.getEmail());
        if (data.isPresent()) {
            throw new DuplicateEmailException();
        }
        traveler.verify();
        traveler.encryptPassword();
        return travelerRepo.save(traveler);
    }
}
