package com.nlpige.tourist.core.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by IntelliJ on Saturday, 05 January, 2019 at 15:26.
 *
 * @author Joseph Maria
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tourregisteringrentity")
public class TourRegisteringEntity {
    @DBRef
    private Tour tour;
    private String collaboratorEmail;
}
