package edu.hcmuaf.nlpige.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public abstract class Customer {
    @Id
    protected ObjectId _id;
    @Field(value = "firstName")
    protected String firstName;
    @Field(value = "lastName")
    protected String lastName;
    @Field(value = "personalID")
    protected String personalID;
    @Field(value = "email")
    protected String email;
    @Field(value = "gender")
    protected Gender gender;
    @Field(value = "address")
    protected Address address;
    @Field(value = "languages")
    protected Languages languages;

    public Customer( String firstName, String lastName, String personalID, String email, Gender gender, Address address, Languages languages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.languages = languages;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Languages getLanguages() {
        return languages;
    }

    public void setLanguages(Languages languages) {
        this.languages = languages;
    }
}
