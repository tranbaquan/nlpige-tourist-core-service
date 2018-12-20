package com.nlpige.tourist.utils;

import com.nlpige.tourist.core.supporter.otp.OTP;
import com.nlpige.tourist.exception.NLPigeException;

public class OTPVerifier {
    public static void verifyOTP(OTP otp) {
        if (otp.getIdentifier() == null || otp.getOtp() == null || otp.getExpireTime() == null ||
                otp.getEmail() == null || otp.getIdentifier() == null) {
            throw new NLPigeException();
        }
    }
}
