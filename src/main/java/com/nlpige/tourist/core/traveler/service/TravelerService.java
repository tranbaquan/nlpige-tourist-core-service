package com.nlpige.tourist.core.traveler.service;

import com.nlpige.tourist.core.supporter.otp.OTP;
import com.nlpige.tourist.core.supporter.otp.OTPService;
import com.nlpige.tourist.core.traveler.model.Traveler;
import com.nlpige.tourist.exception.DuplicateEmailException;
import com.nlpige.tourist.exception.NotFoundException;
import com.nlpige.tourist.utils.OTPGenerator;
import com.nlpige.tourist.utils.UserInformationVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TravelerService {
    @Autowired
    TravelerRepository travelerRepo;
    @Autowired
    OTPService otpService;

    public Traveler login(Traveler traveler) {
        UserInformationVerifier.verifyCustomer(traveler);
        Optional<Traveler> data = travelerRepo.findByEmailAndPassword(traveler.getEmail(), traveler.getPassword());
        System.out.println(traveler.getEmail());
        System.out.println(traveler.getPassword());
        if (!data.isPresent()) {
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

    public OTP generateOTP(String email) {
        Optional<Traveler> traveler = travelerRepo.findByEmail(email);
        if (!traveler.isPresent()) {
            throw new NotFoundException();
        }

        OTP otp = new OTP(email, OTPGenerator.getOTP(), null);
        return otpService.save(otp);
    }

    public boolean validateOTP(OTP otp) {
        return otpService.isCorectOTP(otp);
    }
}
