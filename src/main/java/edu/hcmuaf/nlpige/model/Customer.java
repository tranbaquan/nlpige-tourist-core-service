package edu.hcmuaf.nlpige.model;

import edu.hcmuaf.nlpige.exception.InvalidEmailException;
import edu.hcmuaf.nlpige.exception.InvalidPasswrodException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public abstract class Customer {
    @Field(value = "firstName")
    protected String firstName;
    @Field(value = "lastName")
    protected String lastName;
    @Field(value = "personalID")
    protected String personalID;
    @Field(value = "email")
    protected String email;
    @Field("gender")
    protected Gender gender;
    @Field(value = "address")
    protected Address address;
    @Field(value = "languages")
    protected Languages languages;
    @Field(value = "password")
    protected String password;
    @Field(value = "OTP")
    protected String otp;
    @Field(value = "expiredOTPTime")
    protected LocalDateTime expiredOTPTime;

    protected Customer() {
    }


    public boolean verify() throws InvalidEmailException, InvalidPasswrodException {
        if (!UserInformationVerifier.verifyEmail(email)) {
            throw new InvalidEmailException();
        }
        if (!UserInformationVerifier.verifyPassword(password)) {
            throw new InvalidPasswrodException();
        }
        return true;
    }
}
