package com.nlpige.tourist.core.traveler.service;

import com.nlpige.tourist.core.supporter.otp.OTP;
import com.nlpige.tourist.core.supporter.otp.OTPService;
import com.nlpige.tourist.core.traveler.model.Traveler;
import com.nlpige.tourist.exception.DuplicateEmailException;
import com.nlpige.tourist.exception.NLPigeException;
import com.nlpige.tourist.exception.NotFoundException;
import com.nlpige.tourist.utils.Hashing;
import com.nlpige.tourist.utils.OTPGenerator;
import com.nlpige.tourist.utils.OTPVerifier;
import com.nlpige.tourist.utils.UserInformationVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class TravelerService {
    @Autowired
    TravelerRepository travelerRepo;
    @Autowired
    OTPService otpService;

    public Traveler login(Traveler traveler) {
        UserInformationVerifier.verifyCustomer(traveler);
        Optional<Traveler> data = travelerRepo.findByEmail(traveler.getEmail());
        if (!data.isPresent()) {
            throw new NotFoundException();
        }

        if (!Hashing.verifyPassword(data.get().getPassword(), traveler.getPassword().toCharArray())) {
            throw new NLPigeException();
        }

        traveler = data.get();
        traveler.secureData();
        return traveler;
    }

    public Traveler createTraveler(Traveler traveler) {
        UserInformationVerifier.verifyCustomer(traveler);
        Optional<Traveler> data = travelerRepo.findByEmail(traveler.getEmail());
        if (data.isPresent()) {
            throw new DuplicateEmailException();
        }
        traveler.verify();
        traveler.encryptPassword();
        traveler = travelerRepo.save(traveler);
        traveler.secureData();
        return traveler;
    }

    public Traveler getTraveler(String email) {
        Optional<Traveler> data = travelerRepo.findByEmail(email);
        if (!data.isPresent()) {
            throw new NotFoundException();
        }
        Traveler traveler = data.get();
        traveler.secureData();
        return traveler;
    }

    public OTP generateOTP(String email) {
        Optional<Traveler> traveler = travelerRepo.findByEmail(email);
        if (!traveler.isPresent()) {
            throw new NotFoundException();
        }

        OTP otp = new OTP(email, OTPGenerator.getOTP());
        otp.setExpireTime(LocalDateTime.now().plusMinutes(10));
        return otpService.saveOTP(otp);
    }

    public boolean validateOTP(OTP otp) {
        OTPVerifier.verifyOTP(otp);
        return otpService.isCorrectOTP(otp);
    }

    public Traveler changePassword(String email, String newPassword, String identifier) {
        OTP otp = otpService.getOTP(email);
        Optional<Traveler> travelerOptional = travelerRepo.findByEmail(email);
        if (!travelerOptional.isPresent() || !Objects.equals(otp.getIdentifier(), identifier)) {
            throw new NLPigeException();
        }

        Traveler traveler = travelerOptional.get();
        traveler = setNewPassword(newPassword, traveler);
        otpService.deleteOTP(otp);
        return traveler;
    }

    public Traveler changeUserPassword(String email, String oldPassword, String newPassword) {
        Optional<Traveler> travelerOptional = travelerRepo.findByEmail(email);
        if (!travelerOptional.isPresent()) {
            throw new NLPigeException();
        }

        Traveler traveler = travelerOptional.get();
        if (!Hashing.verifyPassword(traveler.getPassword(), oldPassword.toCharArray())) {
            throw new NLPigeException();
        }

        traveler = setNewPassword(newPassword, traveler);
        return traveler;
    }

    private Traveler setNewPassword(String newPassword, Traveler traveler) {
        traveler.setPassword(newPassword);
        traveler.encryptPassword();
        travelerRepo.deleteByEmail(traveler.getEmail());
        traveler = travelerRepo.save(traveler);
        traveler.secureData();
        return traveler;
    }
}
