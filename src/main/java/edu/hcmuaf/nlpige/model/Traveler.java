package edu.hcmuaf.nlpige.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Document(collection = "traveler")
public class Traveler extends Customer {
    @Field(value = "country")
    private Country country;
    @Field(value = "passport")
    private String passport;

    public Traveler(String firstName, String lastName, String personalID, String email, Gender gender, Address address, Languages languages, String password, String otp, LocalDateTime expiredOTPTime, Country country, String passport) {
        super(firstName, lastName, personalID, email, gender, address, languages, password, otp, expiredOTPTime);
        this.country = country;
        this.passport = passport;
    }

    public Traveler() {

    }
}
