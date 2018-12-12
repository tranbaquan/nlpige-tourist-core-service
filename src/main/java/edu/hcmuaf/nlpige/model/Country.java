package edu.hcmuaf.nlpige.model;

import lombok.Data;

@Data
public class Country {

    private String nation;

    public Country(String nation) {
        this.nation = nation;
    }

    public Country() {

    }
}
