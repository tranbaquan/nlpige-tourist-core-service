package com.nlpige.tourist.core.tour.model;

import com.nlpige.tourist.core.collaborator.model.TourGuideType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "price")
public class Price {
    private TourGuideType type;
    private double pricePerTour;
}
