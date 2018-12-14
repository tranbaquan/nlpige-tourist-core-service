package com.nlpige.tourist.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/traveler")
public class TravelerController {
//    private final TravelerService travelerService;
//
//    @Autowired
//    public TravelerController(TravelerService travelerService) {
//        this.travelerService = travelerService;
//    }
//
//    @CrossOrigin
//    @PostMapping(path = "/create")
//    public ResponseEntity<Traveler> createTraveler(@RequestBody Traveler traveler) {
//        try {
//            return ResponseEntity.ok(travelerService.createTraveler(traveler));
//        } catch (InvalidEmailException | InvalidPasswordException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (DuplicateEmailException e) {
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//    }
//
//    @CrossOrigin
//    @PostMapping(path = "/login")
//    public ResponseEntity<Traveler> login(@RequestBody Traveler traveler) {
//        Traveler acc = travelerService.login(traveler);
//        if (acc != null) {
//            return ResponseEntity.ok(acc);
//        }
//        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//    }
//
//    @CrossOrigin
//    @GetMapping(path = "/getotp")
//    public ResponseEntity<String> getOTP(@RequestHeader String email) {
//        try {
//            String otp = travelerService.generateOTP(email);
//            if (otp == null) {
//                return new ResponseEntity<>("Please Wait a period", HttpStatus.CONFLICT);
//            } else {
//                SendingEmailUtils.sendEmail(email, "Reset Password OTP", "This is your reset password OTP: " + otp);
//                return ResponseEntity.ok("Successfully generate OTP");
//            }
//        } catch (InvalidKeyException e) {
//            return ResponseEntity.badRequest().body("System Error InvalidKeyException!!!");
//        } catch (NoSuchAlgorithmException e) {
//            return ResponseEntity.badRequest().body("System Error NoSuchAlgorithmException!!!");
//        } catch (UnsupportedEncodingException e) {
//            return ResponseEntity.badRequest().body("System Error UnsupportedEncodingException!!!");
//        } catch (MessagingException e) {
//            return ResponseEntity.badRequest().body("System Error MessagingException!!!");
//        }
//    }
//
//    @CrossOrigin
//    @GetMapping(path = "/resetpassword")
//    public ResponseEntity<Boolean> resetPassword(@RequestBody ResetPasswordParam arg) {
//        if (travelerService.resetPassword(arg.getEmail(), arg.getOtp(), arg.getNewPass())) {
//            return ResponseEntity.ok(true);
//        }
//        return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
//    }
}
