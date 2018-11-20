package edu.hcmuaf.nlpige.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "collaborator")
public class Collaborator extends Customer {
    @Field(value = "type")
    private TourGuideType type;
    @Field(value = "phone")
    private String phoneNumber;

    public Collaborator(String firstName, String lastName, String personalID, String email, Gender gender, Address address, Languages languages, TourGuideType type, String phoneNumber) {
        super(firstName, lastName, personalID, email, gender, address, languages);
        this.type = type;
        this.phoneNumber = phoneNumber;
    }
}
