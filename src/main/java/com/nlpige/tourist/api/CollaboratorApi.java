package com.nlpige.tourist.api;

import com.nlpige.tourist.core.collaborator.model.Collaborator;
import com.nlpige.tourist.core.collaborator.service.CollaboratorService;
import com.nlpige.tourist.core.supporter.otp.OTP;
import com.nlpige.tourist.utils.SendingEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "collaborator")
public class CollaboratorApi {
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

    @PutMapping
    public Collaborator updateCollaborator(@RequestBody Collaborator collaborator) {
        return collaboratorService.updateCollaborator(collaborator);
    }

    @PostMapping(value = "login")
    public Collaborator login(@RequestBody Collaborator collaborator) {
        return collaboratorService.login(collaborator);
    }

    @PostMapping(value = "otp")
    public boolean validateOTP(@RequestBody OTP otp) {
        return collaboratorService.validateOTP(otp);
    }

    @GetMapping(value = "otp")
    public OTP getOTP(@RequestHeader String email, @RequestHeader String requestType) {
        OTP otp = collaboratorService.generateOTP(email);
        SendingEmail.sendEmail(email, requestType, "Your OTP: " + otp.getOtp());
        return otp;
    }

    @PutMapping(value = "otp")
    public Collaborator changePasswordByOtp(@RequestHeader String email, @RequestHeader String newPassword, @RequestHeader String identifier) {
        return collaboratorService.changePasswordByOtp(email, newPassword, identifier);
    }

    @PutMapping(value = "password")
    public Collaborator changeUserPassword(@RequestHeader String email, @RequestHeader String oldPassword, @RequestHeader String newPassword) {
        return collaboratorService.changeUserPassword(email, oldPassword, newPassword);
    }
}
