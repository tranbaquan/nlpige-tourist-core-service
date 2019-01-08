package com.nlpige.tourist.api;

import com.nlpige.tourist.core.collaborator.model.Collaborator;
import com.nlpige.tourist.core.collaborator.service.CollaboratorService;
import com.nlpige.tourist.core.supporter.otp.OTP;
import com.nlpige.tourist.utils.SendingEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "collaborator")
public class CollaboratorAPI {
    @Autowired
    CollaboratorService collaboratorService;

    @PostMapping
    public Collaborator createCollaborator(@RequestBody Collaborator collaborator) {
        return collaboratorService.createCollaborator(collaborator);
    }

    @GetMapping
    public Collaborator getCollaborator(@RequestHeader String email) {
        return collaboratorService.getCollaborator(email);
    }

    // replaced traveler to collaborator
    @PostMapping(value = "login")
    public Collaborator login(@RequestBody Collaborator collaborator) {
        return collaboratorService.login(collaborator);
    }

    @GetMapping(value = "otp")
    public OTP getOTP(@RequestHeader String email, @RequestHeader String requestType) {
        OTP otp = collaboratorService.generateOTP(email);
        SendingEmail.sendEmail(email, requestType, "Your OTP: " + otp.getOtp());
        return otp;
    }

    @PostMapping(value = "otp")
    public boolean validateOTP(@RequestBody OTP otp) {
        return collaboratorService.validateOTP(otp);
    }

    @PutMapping(value = "password/change")
    public Collaborator changePassword(@RequestHeader String email, @RequestHeader String newPassword, @RequestHeader String identifier) {
        return collaboratorService.changePassword(email, newPassword, identifier);
    }

    @PutMapping(value = "password/changeuserpassword")
    public Collaborator changeUserPassword(@RequestHeader String email, @RequestHeader String oldPassword, @RequestHeader String newPassword) {
        return collaboratorService.changeUserPassword(email, oldPassword, newPassword);
    }

    @PutMapping(value = "updateinfor")
    public Collaborator updateInformation(@RequestBody Collaborator collaborator) {
        return collaboratorService.updateInformation(collaborator);
    }
}
