package edu.hcmuaf.nlpige.domain;

import edu.hcmuaf.nlpige.model.Collaborator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CollaboratorRepository extends MongoRepository<Collaborator,String> {
}
