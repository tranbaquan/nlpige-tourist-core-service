package com.nlpige.tourist.core.report.service;

import com.mongodb.lang.Nullable;
import com.nlpige.tourist.core.report.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReportRepository extends MongoRepository<Report,String> {
    @Nullable
    List<Report> findBySenderEmailAndReportedEmail(String senderEmail, String reportedEmail);
}
