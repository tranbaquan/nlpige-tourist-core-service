package com.nlpige.tourist.core.collaborator.model;

import com.nlpige.tourist.core.customer.model.Customer;
import com.nlpige.tourist.core.traveler.model.TourGuideType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "test")
@NoArgsConstructor
public class Collaborator extends Customer {
    @Field(value = "type")
    private TourGuideType type;
    @Field(value = "phoneNumber")
    private String phoneNumber;
}
