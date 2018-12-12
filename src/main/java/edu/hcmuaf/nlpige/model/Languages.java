package edu.hcmuaf.nlpige.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Languages {
    private String primaryLanguage;
    private List<String> languages;

    public Languages(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
        languages = new ArrayList<>();
    }

    public Languages() {

    }
}
