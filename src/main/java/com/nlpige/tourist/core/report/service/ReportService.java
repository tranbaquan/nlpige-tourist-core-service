package com.nlpige.tourist.core.report.service;

import com.nlpige.tourist.core.report.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    ReportRepository reportRepo;

    public Report addReport(Report report) {
        return reportRepo.save(report);
    }

    public List<Report> getReportsBySomeOne(String reportedEmail) {
        return reportRepo.findReportsByReportedEmail(reportedEmail);
    }

    public List<Report> getAll() {
        return reportRepo.findAll();
    }
}
