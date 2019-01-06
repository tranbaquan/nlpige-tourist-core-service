package com.nlpige.tourist.core.report.service;

import com.mongodb.MongoClientURI;
import com.nlpige.tourist.core.collaborator.model.Collaborator;
import com.nlpige.tourist.core.report.model.Report;
import com.nlpige.tourist.core.traveler.model.Traveler;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.concurrent.locks.ReentrantLock;

public interface ReportRepository extends MongoRepository<Report,String> {
}
