package edu.hcmuaf.nlpige.service;

import edu.hcmuaf.nlpige.domain.CollabotatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService {
    @Autowired
    private CollabotatorRepository collabotatorRepository;
}
