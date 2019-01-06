package com.nlpige.tourist.core.report.service;

import com.nlpige.tourist.core.collaborator.service.CollaboratorService;
import com.nlpige.tourist.core.report.model.Report;
import com.nlpige.tourist.core.traveler.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    ReportRepository reportRepo;

    public Report addReport(Report report) {
           return reportRepo.insert(report);
    }
}
