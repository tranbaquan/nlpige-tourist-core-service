package com.nlpige.tourist.utils;

import com.nlpige.tourist.core.customer.model.Customer;
import com.nlpige.tourist.exception.NLPigeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ on Monday, 10 December, 2018 at 00:20.
 *
 * @author Joseph Maria
 * @author Tran Ba Quan
 */
public class UserInformationVerifier {

    public static void verifyCustomer(Customer customer) {
        if(customer == null) {
            throw new NLPigeException();
        }
    }

    public static boolean verifyEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public static boolean verifyPassword(String password) {
        return password != null && !password.isEmpty();
    }

}
