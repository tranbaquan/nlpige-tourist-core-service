package com.nlpige.tourist.core.review.model;

import com.nlpige.tourist.core.tour.model.Tour;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ on Thursday, 20 December, 2018 at 11:19.
 *
 * @author Joseph Maria
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "review")
public class Review {
    @DBRef
    private Tour tour;
    @NotNull
    private LocalDateTime postTime;
    @NotNull
    private String comment;
    @NotNull
    private float rating;
}
