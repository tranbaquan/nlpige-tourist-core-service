package com.nlpige.tourist.core.collaborator.service;

import com.nlpige.tourist.core.collaborator.model.Collaborator;
import com.nlpige.tourist.core.supporter.otp.OTP;
import com.nlpige.tourist.core.supporter.otp.OTPService;
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

/**
 * Created by IntelliJ on Wednesday, 19 December, 2018 at 16:37.
 *
 * @author Joseph Maria
 */
@Service
public class CollaboratorService {
    @Autowired
    CollaboratorRepo collaboratorRepo;
    @Autowired
    OTPService otpService;

    public Collaborator login(Collaborator collaborator) {
        UserInformationVerifier.verifyCustomer(collaborator);
        Optional<Collaborator> data = collaboratorRepo.findByEmail(collaborator.getEmail());

        if (!data.isPresent()) {
            throw new NotFoundException();
        }

        if (!Hashing.verifyPassword(data.get().getPassword(), collaborator.getPassword().toCharArray())) {
            throw new NLPigeException();
        }

        collaborator = data.get();
        collaborator.secureData();
        return collaborator;
    }

    public Collaborator createCollaborator(Collaborator collaborator) {
        UserInformationVerifier.verifyCustomer(collaborator);
        Optional<Collaborator> data = collaboratorRepo.findByEmail(collaborator.getEmail());
        if (data.isPresent()) {
            throw new DuplicateEmailException();
        }
        collaborator.verify();
        collaborator.encryptPassword();
        collaborator = collaboratorRepo.save(collaborator);
        collaborator.secureData();
        return collaborator;
    }

    public Collaborator getCollaborator(String email) {
        Optional<Collaborator> data = collaboratorRepo.findByEmail(email);
        if (!data.isPresent()) {
            throw new NotFoundException();
        }
        Collaborator collaborator = data.get();
        collaborator.secureData();
        return collaborator;
    }

    public OTP generateOTP(String email) {
        Optional<Collaborator> traveler = collaboratorRepo.findByEmail(email);
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

    public Collaborator changePassword(String email, String newPassword, String identifier) {
        OTP otp = otpService.getOTP(email);
        Optional<Collaborator> collaboratorData = collaboratorRepo.findByEmail(email);
        if (!collaboratorData.isPresent() || !Objects.equals(otp.getIdentifier(), identifier)) {
            throw new NLPigeException();
        }

        Collaborator collaborator = collaboratorData.get();
        collaborator.setPassword(newPassword);
        collaborator.encryptPassword();
        collaborator = collaboratorRepo.save(collaborator);
        collaborator.secureData();
        otpService.deleteOTP(otp);
        return collaborator;
    }
}
