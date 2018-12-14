package com.nlpige.tourist.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/collaborator")
public class CollaboratorController {
//    private final CollaboratorService collaboratorService;
//
//    @Autowired
//    public CollaboratorController(CollaboratorService collaboratorService) {
//        this.collaboratorService = collaboratorService;
//    }

//    @CrossOrigin
//    @GetMapping
//    @ResponseBody
//    public List<Collaborator> getAll() {
//        System.out.println(collaboratorService.getAll().toString());
//        return collaboratorService.getAll();
//    }
//
//
//    @CrossOrigin
//    @PostMapping(path = "/create")
//    public ResponseEntity<Collaborator> createTraveler(@RequestBody Collaborator collaborator) {
//        try {
//            return ResponseEntity.ok(collaboratorService.createCollaborator(collaborator));
//        } catch (InvalidEmailException | InvalidPasswordException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (DuplicateEmailException e) {
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//    }
//
//    @CrossOrigin
//    @GetMapping(path = "/login")
//    public ResponseEntity<Collaborator> login(@RequestBody Collaborator collaborator) {
//        Collaborator acc = collaboratorService.login(collaborator);
//        if (acc != null) {
//            return ResponseEntity.ok(acc);
//        }
//        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//    }

}
