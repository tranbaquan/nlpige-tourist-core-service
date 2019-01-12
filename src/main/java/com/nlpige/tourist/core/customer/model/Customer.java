package com.nlpige.tourist.core.customer.model;

import com.nlpige.tourist.exception.InvalidEmailException;
import com.nlpige.tourist.exception.InvalidPasswordException;
import com.nlpige.tourist.utils.Hashing;
import com.nlpige.tourist.utils.UserInformationVerifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Customer {
    protected String firstName;
    protected String lastName;
    protected String personalID;
    protected String email;
    protected String phoneNumber;
    protected Gender gender;
    protected LocalDate dob;
    protected String avatar;
    protected Address address;
    protected Languages languages;
    protected String password;
    private LocalDateTime activeDate;

    public boolean verify() {
        if (!UserInformationVerifier.verifyEmail(email)) {
            throw new InvalidEmailException();
        }
        if (!UserInformationVerifier.verifyPassword(password)) {
            throw new InvalidPasswordException();
        }
        return true;
    }

    public void encryptPassword() {
        password = Hashing.hashPassword(password.toCharArray());
    }

    public void secureData(){
        password = null;
    }
}
