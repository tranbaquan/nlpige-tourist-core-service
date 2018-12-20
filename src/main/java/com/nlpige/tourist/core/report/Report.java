package com.nlpige.tourist.core.report;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ on Thursday, 20 December, 2018 at 14:08.
 *
 * @author Joseph Maria
 */
@Data
public class Report {
    private String senderEmail;
    private String reportedEmail;
    private String content;
    private LocalDateTime reportTime;
}
