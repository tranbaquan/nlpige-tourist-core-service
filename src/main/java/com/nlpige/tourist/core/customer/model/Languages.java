package com.nlpige.tourist.core.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Languages {
    private String primaryLanguage;
    private List<String> otherLanguages;

    public Languages() {
        otherLanguages = new ArrayList<>();
    }

    public Languages(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
        otherLanguages = new ArrayList<>();
    }

    public void addSecondaryLanguage(String language) {
        otherLanguages.add(language);
    }
}
