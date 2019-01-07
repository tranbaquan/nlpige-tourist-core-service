package com.nlpige.tourist.core.collaborator.model;

public enum TourGuideType {
    PROFESSOR("PROFESSOR"),
    FREELANCER("FREELANCER"),
    STUDENT("STUDENT"),
    RESIDENT("RESIDENT");

    private final String type;

    TourGuideType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
