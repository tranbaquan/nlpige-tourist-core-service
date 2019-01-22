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
        otpRepo.deleteAllByEmail(otp.getEmail());
        return otpRepo.save(otp);
    }

    public OTP getOTP(String email) {
        Optional<OTP> otp =otpRepo.findByEmail(email);

        if(!otp.isPresent()) {
            throw new NotFoundException();
        }
        return otp.get();
    }

    public void deleteOTP(OTP otp) {
        otpRepo.deleteByEmail(otp.getEmail());
    }

    public boolean isCorrectOTP(OTP otp) {
        OTP system = getOTP(otp.getEmail());
        boolean b = validateOTP(system, otp.getOtp());
        if(b) {
            saveOTP(otp);
        }
        return b;
    }

    private boolean validateOTP(OTP systemOtp, String userOtp) {
        System.out.println(systemOtp.getOtp());
        System.out.println(userOtp);
        if(systemOtp == null) {
            throw new NLPigeException();
        }
        return systemOtp.getExpireTime().isAfter(LocalDateTime.now()) && systemOtp.getOtp().equals(userOtp) && systemOtp.getIdentifier() == null;
    }
}
