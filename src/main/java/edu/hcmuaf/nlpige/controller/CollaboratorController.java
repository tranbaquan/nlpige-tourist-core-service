package edu.hcmuaf.nlpige.controller;

import edu.hcmuaf.nlpige.exception.DuplicateEmailException;
import edu.hcmuaf.nlpige.exception.InvalidEmailException;
import edu.hcmuaf.nlpige.exception.InvalidPasswrodException;
import edu.hcmuaf.nlpige.model.Collaborator;
import edu.hcmuaf.nlpige.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/collaborator")
public class CollaboratorController {
    private final CollaboratorService collaboratorService;

    @Autowired
    public CollaboratorController(CollaboratorService collaboratorService) {
        this.collaboratorService = collaboratorService;
    }


    @CrossOrigin
    @PostMapping(path = "/create")
    public ResponseEntity<Collaborator> createTraveler(@RequestBody Collaborator collaborator) {
        try {
            return ResponseEntity.ok(collaboratorService.createCollaborator(collaborator));
        } catch (InvalidEmailException | InvalidPasswrodException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (DuplicateEmailException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @CrossOrigin
    @GetMapping(path = "/login")
    public ResponseEntity<Collaborator> login(@RequestBody Collaborator collaborator) {
        Collaborator acc = collaboratorService.login(collaborator);
        if (acc != null) {
            return ResponseEntity.ok(acc);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
