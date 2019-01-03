package com.nlpige.tourist.core.collaborator.model;

import com.nlpige.tourist.core.customer.model.Address;
import com.nlpige.tourist.core.customer.model.Customer;
import com.nlpige.tourist.core.customer.model.Gender;
import com.nlpige.tourist.core.customer.model.Languages;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection = "collaborator")
@NoArgsConstructor
public class Collaborator extends Customer {
    private TourGuideType type;
    private String phoneNumber;

    public Collaborator(String firstName, String lastName, String personalID, String email, Gender gender, LocalDate dob, String avatar, Address address, Languages languages, String password, LocalDateTime activeDate, TourGuideType type, String phoneNumber) {
        super(firstName, lastName, personalID, email, gender, dob, avatar, address, languages, password, activeDate);
        this.type = type;
        this.phoneNumber = phoneNumber;
    }
}
