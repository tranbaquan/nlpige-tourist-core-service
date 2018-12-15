package com.nlpige.tourist.utils;

import java.util.Random;

public class OTPGenerator {
    public static String getOTP(){
        Random r = new Random();
        String otp = "";
        for (int i = 0; i < 6; i++) {
            otp+= r.nextInt(10);
        }
        return otp;
    }
}
