package edu.hcmuaf.nlpige.controller;

import edu.hcmuaf.nlpige.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Collaborator")
public class CollaboratorController {
    @Autowired
    private CollaboratorService collaboratorService;
}
