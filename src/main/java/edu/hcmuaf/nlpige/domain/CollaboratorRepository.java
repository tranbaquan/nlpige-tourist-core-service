package edu.hcmuaf.nlpige.domain;

import edu.hcmuaf.nlpige.model.Collaborator;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CollaboratorRepository extends MongoRepository<Collaborator, String> {
    Optional<Collaborator> findByEmail(String email);
}
