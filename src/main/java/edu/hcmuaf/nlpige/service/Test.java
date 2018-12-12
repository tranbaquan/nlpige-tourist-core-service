package edu.hcmuaf.nlpige.service;

import edu.hcmuaf.nlpige.model.OneTimePasswordAlgorithm;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Created by IntelliJ on Wednesday, 12 December, 2018 at 02:01.
 *
 * @author Joseph Maria
 */
public class Test {
    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException {
//        String hashed = HashingUtils.hashPassword(new char[]{'a', 'b', 'c'});
//        System.out.println(HashingUtils.verifyPassword(hashed, new char[]{'a', 'b', 'c'}));
        System.out.println(OneTimePasswordAlgorithm.generateOTP(UUID.randomUUID().toString().getBytes(), 5, 5, true, 5));
    }
}
