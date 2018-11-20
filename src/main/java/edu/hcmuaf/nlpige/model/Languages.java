package edu.hcmuaf.nlpige.model;

import java.util.ArrayList;
import java.util.List;

public class Languages {
    private String primaryLanguage;
    private List<String> languages;

    public Languages(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
        this.languages = new ArrayList<>();
    }
}
