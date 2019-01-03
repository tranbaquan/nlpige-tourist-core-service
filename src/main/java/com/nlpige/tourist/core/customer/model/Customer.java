package com.nlpige.tourist.core.customer.model;

import com.nlpige.tourist.exception.InvalidEmailException;
import com.nlpige.tourist.exception.InvalidPasswordException;
import com.nlpige.tourist.utils.Hashing;
import com.nlpige.tourist.utils.UserInformationVerifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

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
    protected Gender gender;
    protected LocalDate dob;
    protected String avatar;
    protected Address address;
    @Field(value = "otherLanguages")
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
