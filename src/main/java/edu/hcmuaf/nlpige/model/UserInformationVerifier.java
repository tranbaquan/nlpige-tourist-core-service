package edu.hcmuaf.nlpige.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ on Monday, 10 December, 2018 at 00:20.
 *
 * @author Joseph Maria
 */
public class UserInformationVerifier {
    public static boolean verifyEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public static boolean verifyPassword(String password) {
        PasswordComplexify complexity = new PasswordComplexify();
        complexity.setMinimumChars(8);
        complexity.setStrengthScaleFactor(0.7);
        return complexity.checkComplexityOfPassword(password);
    }

}
