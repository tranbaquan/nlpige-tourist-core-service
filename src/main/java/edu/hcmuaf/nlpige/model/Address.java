package edu.hcmuaf.nlpige.model;

import lombok.Data;

@Data
public class Address {
    private String address;
    private String zipCode;

    public Address(String address, String zipCode) {
        this.address = address;
        this.zipCode = zipCode;
    }

    public Address() {

    }
}
