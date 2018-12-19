package com.nlpige.tourist.core.tour.model;

import com.nlpige.tourist.core.customer.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "place")
public class Place {
    private String name;
    private String imageUrl;
    private String description;
    private Address address;
    private int visitCounter;
}
