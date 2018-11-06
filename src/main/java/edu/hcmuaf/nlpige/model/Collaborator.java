package edu.hcmuaf.nlpige.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "Collaborator")
public class Collaborator extends Customer {
    @Field(value = "tyoe")
    private TourGuideType tourGuideType;
    @Field(value = "phone")
    private String phoneNumber;

    public Collaborator(String firstName, String lastName, String personalID, String email, Gender gender, Address address, Languages languages, TourGuideType tourGuideType, String phoneNumber) {
        super( firstName, lastName, personalID, email, gender, address, languages);
        this.tourGuideType = tourGuideType;
        this.phoneNumber = phoneNumber;
    }
}
