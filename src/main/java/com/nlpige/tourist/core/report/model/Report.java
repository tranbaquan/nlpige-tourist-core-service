package com.nlpige.tourist.core.report.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ on Thursday, 20 December, 2018 at 14:08.
 *
 * @author Joseph Maria
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "report")
public class Report {
    private String senderEmail;
    private String reportedEmail;
    private String content;
    private LocalDateTime reportTime;
}
