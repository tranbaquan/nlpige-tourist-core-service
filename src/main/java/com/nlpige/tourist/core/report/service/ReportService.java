package com.nlpige.tourist.core.report.service;

import com.nlpige.tourist.core.report.model.Report;
import com.nlpige.tourist.core.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    ReportRepository reportRepo;

    @Autowired
    TourService tourService;

    public Report addReport(Report report) {
        return reportRepo.save(report);
    }

    public List<Report> getReports(String senderEmail, String reportedEmail) {
        if (tourService.hadTour(senderEmail, reportedEmail)) {
            return reportRepo.findBySenderEmailAndReportedEmail(senderEmail, reportedEmail);
        }
        return Collections.emptyList();

    }

    public List<Report> getAll() {
        return reportRepo.findAll();
    }
}
