package edu.hcmuaf.nlpige.domain;

import edu.hcmuaf.nlpige.model.Traveler;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TravelerRepository extends MongoRepository<Traveler,String> {
    Optional<Traveler> findByEmail(String email);
}
