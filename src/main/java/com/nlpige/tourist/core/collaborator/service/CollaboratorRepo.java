package com.nlpige.tourist.core.collaborator.service;

import com.nlpige.tourist.core.collaborator.model.Collaborator;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by IntelliJ on Wednesday, 19 December, 2018 at 16:57.
 *
 * @author Joseph Maria
 */
public interface CollaboratorRepo extends MongoRepository<Collaborator, String> {
    Optional<Collaborator> findByEmail(String email);

    Optional<Collaborator> findByEmailAndPassword(String email, String password);
}
