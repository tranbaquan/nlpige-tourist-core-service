package com.nlpige.tourist.api;

import com.nlpige.tourist.core.report.model.Report;
import com.nlpige.tourist.core.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/report")
public class ReportAPI {
    @Autowired
    ReportService reportService;
    @PostMapping("/add")
    public Report addReport(@RequestBody Report report){
        return reportService.addReport(report);
    }
}
