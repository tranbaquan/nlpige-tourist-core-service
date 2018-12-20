package com.nlpige.tourist.core.collaborator.model;

public enum TourGuideType {
    PROFESSOR("Professor"),
    FREELANCER("Freelancer"),
    STUDENT("Student"),
    RESIDENT("Resident");

    private final String type;

    TourGuideType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
