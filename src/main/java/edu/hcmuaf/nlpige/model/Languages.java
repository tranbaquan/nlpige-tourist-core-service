package edu.hcmuaf.nlpige.model;

import java.util.ArrayList;

public class Languages {
    private String nativeLanguage;
    private ArrayList<String> languages;

    public Languages(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
        languages= new ArrayList<>();
    }
}
