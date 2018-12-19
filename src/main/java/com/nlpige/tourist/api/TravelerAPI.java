package com.nlpige.tourist.api;

import com.nlpige.tourist.core.supporter.otp.OTP;
import com.nlpige.tourist.core.traveler.model.Traveler;
import com.nlpige.tourist.core.traveler.service.TravelerService;
import com.nlpige.tourist.utils.SendingEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "traveler")
public class TravelerAPI {

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

    @PostMapping(value = "login")
    public Traveler login(@RequestBody Traveler traveler) {
        return travelerService.login(traveler);
    }

    @GetMapping(value = "otp")
    public void getOTP(@RequestHeader String email, @RequestHeader String requestType) {
        OTP otp = travelerService.generateOTP(email);
        SendingEmail.sendEmail(email, requestType, "Your OTP: " + otp.getOtp());
    }

    @PostMapping(value = "otp")
    public boolean validateOTP(@RequestBody OTP otp) {
        return travelerService.validateOTP(otp);
    }

    @PostMapping(value = "password/change")
    public Traveler changePassword(@RequestHeader String email, @RequestHeader String newPassword, @RequestHeader String identifier) {
        return travelerService.changePassword(email, newPassword, identifier);
    }
}
