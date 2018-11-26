package edu.hcmuaf.nlpige.model;

import org.springframework.data.mongodb.core.mapping.Field;

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

    public Customer(String firstName, String lastName, String personalID, String email, Gender gender, Address address, Languages languages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.languages = languages;
    }
}
