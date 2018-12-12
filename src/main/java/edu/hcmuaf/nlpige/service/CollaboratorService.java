package edu.hcmuaf.nlpige.service;

import edu.hcmuaf.nlpige.domain.CollaboratorRepository;
import edu.hcmuaf.nlpige.domain.DataMaster;
import edu.hcmuaf.nlpige.exception.DuplicateEmailException;
import edu.hcmuaf.nlpige.exception.InvalidEmailException;
import edu.hcmuaf.nlpige.exception.InvalidPasswrodException;
import edu.hcmuaf.nlpige.model.Collaborator;
import edu.hcmuaf.nlpige.model.HashingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService {
    @Autowired
    private CollaboratorRepository collaboratorRepository;

    public Collaborator createCollaborator(Collaborator collaborator) throws InvalidEmailException, InvalidPasswrodException, DuplicateEmailException {
//        Optional<Traveler> optionalTraveler = travelerRepository.findByEmail(traveler.getEmail());
        if (DataMaster.findCollaboratorByEmail(collaborator.getEmail()) != null) {
            throw new DuplicateEmailException();
        }

        collaborator.verify();
        collaborator.setPassword(HashingUtils.hashPassword(collaborator.getPassword().toCharArray()));
        DataMaster.save(collaborator);
        collaborator.setPassword(null);
        collaborator.setOtp(null);
        collaborator.setExpiredOTPTime(null);
        return collaborator;
    }

    public Collaborator login(Collaborator collaborator) {
        Collaborator coll = DataMaster.findCollaboratorByEmail(collaborator.getEmail());
        if (coll != null) {
            if (HashingUtils.verifyPassword(coll.getPassword(), collaborator.getPassword().toCharArray())) {
                coll.setPassword(null);
                coll.setOtp(null);
                coll.setExpiredOTPTime(null);
                return coll;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
