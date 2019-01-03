package com.nlpige.tourist.core.tour.model;

import com.nlpige.tourist.core.customer.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "place")
public class Place {
    @Id
    private String id;
    private String name;
    private String imageUrl;
    private String description;
    private Address address;
    private int visitCounter;

    public Place(String name, String imageUrl, String description, Address address, int visitCounter) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.address = address;
        this.visitCounter = visitCounter;
    }
}
