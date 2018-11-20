package edu.hcmuaf.nlpige.service;

import edu.hcmuaf.nlpige.domain.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService {
    @Autowired
    private CollaboratorRepository collaboratorRepository;
}
