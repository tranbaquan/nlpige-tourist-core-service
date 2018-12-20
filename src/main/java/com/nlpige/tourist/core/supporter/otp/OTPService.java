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

    public OTP saveOTP(OTP otp) {
        otp.setExpireTime(LocalDateTime.now().plusMinutes(10));
        return otpRepo.save(otp);
    }

    public OTP getOTP(String email) {
        Optional<OTP> otp =otpRepo.findByEmail(email);

        if(!otp.isPresent()) {
            throw new NotFoundException();
        }
        return otp.get();
    }

    private void deleteOTP(OTP otp) {
        otpRepo.deleteByEmail(otp.getEmail());
    }

    public boolean isCorrectOTP(OTP otp) {
        OTP system = getOTP(otp.getEmail());
        return validateOTP(system, otp.getOtp());
    }

    private boolean validateOTP(OTP systemOtp, String userOtp) {
        if(systemOtp == null) {
            throw new NLPigeException();
        }
        return systemOtp.getExpireTime().isAfter(LocalDateTime.now()) && systemOtp.getOtp().equals(userOtp) && systemOtp.getIdentifier().equals(userOtp);
    }
}
