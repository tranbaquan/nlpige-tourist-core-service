package com.nlpige.tourist.core.supporter.otp;

import com.nlpige.tourist.exception.NLPigeException;
import com.nlpige.tourist.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OTPService {
    @Autowired
    private OTPRepository otpRepo;

    public OTP save(OTP otp) {
        otp.setExpireTime(LocalDateTime.now().plusMinutes(10));
        return otpRepo.save(otp);
    }

    public boolean isCorectOTP(OTP otp) {
        OTP system = getOTP(otp.getEmail());
        boolean b = validateOTP(system, otp.getOtp());
        if(b) {
            otpRepo.deleteById(otp.getEmail());
        }
        return b;
    }

    private OTP getOTP(String email) {
        Optional<OTP> otp =otpRepo.findById(email);

        if(!otp.isPresent()) {
            throw new NotFoundException();
        }
        return otp.get();
    }

    private boolean validateOTP(OTP systemOtp, String userOtp) {
        if(systemOtp == null) {
            throw new NLPigeException();
        }
        return systemOtp.getExpireTime().isAfter(LocalDateTime.now()) && systemOtp.getOtp().equals(userOtp);
    }
}
