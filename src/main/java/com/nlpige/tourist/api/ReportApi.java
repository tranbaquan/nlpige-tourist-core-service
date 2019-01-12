package com.nlpige.tourist.api;

import com.nlpige.tourist.core.report.model.Report;
import com.nlpige.tourist.core.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("report")
public class ReportApi {
    @Autowired
    ReportService reportService;
    @PostMapping
    public Report addReport(@RequestBody Report report){
        return reportService.addReport(report);
    }
    @GetMapping
    public List<Report> getReports(@RequestHeader String senderEmail, @RequestHeader String reportedEmail) {
        return reportService.getReports(senderEmail, reportedEmail);
    }
    @GetMapping("/all")
    public List<Report> getAllReports(){
        return reportService.getAll();
    }
}
