package com.nlpige.tourist.core.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ on Thursday, 20 December, 2018 at 14:08.
 *
 * @author Joseph Maria
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private String senderEmail;
    private String reportedEmail;
    private String content;
    private LocalDateTime reportTime;
    //todo deal with report service
}
