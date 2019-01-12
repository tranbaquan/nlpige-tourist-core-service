package com.nlpige.tourist.core.traveler.model;

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
@NoArgsConstructor
@Document(collection = "traveler")
public class Traveler extends Customer {
    private String passport;

    public Traveler(String firstName, String lastName, String personalID, String email, String phoneNumber, Gender gender, LocalDate dob, String avatar, Address address, Languages languages, String password, LocalDateTime activeDate, String passport) {
        super(firstName, lastName, personalID, email, phoneNumber, gender, dob, avatar, address, languages, password, activeDate);
        this.passport = passport;
    }
}
