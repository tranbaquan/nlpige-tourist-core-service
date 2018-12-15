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

    @GetMapping(value = "otp")
    public OTP getOTP(@RequestHeader String email, @RequestHeader String requestType){
        OTP otp = travelerService.generateOTP(email);
        SendingEmail.sendEmail(email, requestType, "Your OTP: " + otp.getOtp());
        return otp;
    }

    @PostMapping(value = "otp")
    public boolean validateOTP(@RequestBody OTP otp) {
        return travelerService.validateOTP(otp);
    }
}
