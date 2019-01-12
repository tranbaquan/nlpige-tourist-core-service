package com.nlpige.tourist.api;

import com.nlpige.tourist.core.supporter.otp.OTP;
import com.nlpige.tourist.core.traveler.model.Traveler;
import com.nlpige.tourist.core.traveler.service.TravelerService;
import com.nlpige.tourist.utils.SendingEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "traveler")
public class TravelerApi {
    @Autowired
    TravelerService travelerService;

    @PostMapping
    public Traveler createTraveler(@RequestBody Traveler traveler) {
        return travelerService.createTraveler(traveler);
    }

    @GetMapping
    public Traveler getTraveler(@RequestHeader String email) {
        return travelerService.getTraveler(email);
    }

    @PutMapping
    public Traveler updateTraveler(@RequestBody Traveler traveler) {
        return travelerService.updateTraveler(traveler);
    }

    @PostMapping(value = "login")
    public Traveler login(@RequestBody Traveler traveler) {
        return travelerService.login(traveler);
    }

    @PostMapping(value = "otp")
    public boolean validateOtp(@RequestBody OTP otp) {
        return travelerService.validateOTP(otp);
    }

    @GetMapping(value = "otp")
    public OTP getOtp(@RequestHeader String email, @RequestHeader String requestType) {
        OTP otp = travelerService.generateOTP(email);
        SendingEmail.sendEmail(email, requestType, "Your OTP: " + otp.getOtp());
        return otp;
    }

    @PutMapping(value = "otp")
    public Traveler changePasswordByOtp(@RequestHeader String email, @RequestHeader String newPassword, @RequestHeader String identifier) {
        return travelerService.changePasswordByOtp(email, newPassword, identifier);
    }

    @PutMapping(value = "password")
    public Traveler changeUserPassword(@RequestHeader String email, @RequestHeader String oldPassword, @RequestHeader String newPassword) {
        return travelerService.changeUserPassword(email, oldPassword, newPassword);
    }
}
