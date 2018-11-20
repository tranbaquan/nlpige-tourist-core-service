package edu.hcmuaf.nlpige.domain;

import edu.hcmuaf.nlpige.model.Traveler;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TravelerRepository extends MongoRepository<Traveler,String> {
}
