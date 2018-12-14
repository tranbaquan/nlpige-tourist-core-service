package com.nlpige.tourist.core.customer.model;


public enum Gender {
    MALE("Male"), FEMALE("Female"), OTHER("Other");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
