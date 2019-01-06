package com.nlpige.tourist.api;

import com.nlpige.tourist.core.report.model.Report;
import com.nlpige.tourist.core.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("report")
public class ReportAPI {
    @Autowired
    ReportService reportService;
    @PostMapping
    public Report addReport(@RequestBody Report report){
        return reportService.addReport(report);
    }
    @GetMapping("/reports")
    public List<Report> getReports(@RequestHeader String reported_email){
        return reportService.getReportsBySomeOne(reported_email);
    }
    @GetMapping("/all")
    public List<Report> getAllReports(){
        return reportService.getAll();
    }
}
