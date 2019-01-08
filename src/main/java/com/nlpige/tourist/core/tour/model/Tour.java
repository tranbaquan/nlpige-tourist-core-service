package com.nlpige.tourist.core.tour.model;

import com.nlpige.tourist.core.collaborator.model.Collaborator;
import com.nlpige.tourist.core.traveler.model.Traveler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tour")
public class Tour {
    @Id
    private String id;
    private Place place;
    private Traveler traveler;
    private Collaborator tourGuide;
    private LocalDateTime startDate;
    private double price;
    private boolean isAccepted;
    private boolean paid;
    private String description;
}
