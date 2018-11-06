package edu.hcmuaf.nlpige.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "Traveler")
public class Traveler extends Customer {
    @Field(value = "Country")
    private Country country;
    @Field(value = "passport")
    private String passport;

    public Traveler(String firstName, String lastName, String personalID, String email, Gender gender, Address address, Languages languages, Country country, String passport) {
        super(firstName, lastName, personalID, email, gender, address, languages);
        this.country = country;
        this.passport = passport;
    }
}
