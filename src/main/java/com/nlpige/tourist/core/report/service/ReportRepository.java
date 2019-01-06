package com.nlpige.tourist.core.report.service;

import com.nlpige.tourist.core.report.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.List;

public interface ReportRepository extends MongoRepository<Report,String> {
    List<Report> findReportsByReportedEmail(String email);
}
