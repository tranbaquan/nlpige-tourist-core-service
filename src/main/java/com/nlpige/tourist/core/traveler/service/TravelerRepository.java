package com.nlpige.tourist.core.traveler.service;

import com.nlpige.tourist.core.traveler.model.Traveler;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TravelerRepository extends MongoRepository<Traveler, String> {
    Optional<Traveler> findByEmail(String email);
    Optional<Traveler> findByEmailAndPassword(String email, String password);
}
