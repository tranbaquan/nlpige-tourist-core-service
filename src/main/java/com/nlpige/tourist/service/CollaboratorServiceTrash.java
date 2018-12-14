package com.nlpige.tourist.service;

import org.springframework.stereotype.Service;

@Service
public class CollaboratorServiceTrash {

//    public List<Collaborator> getAll(){
//        return collaboratorRepository.findAll();
//    }
//
//    public Collaborator createCollaborator(Collaborator collaborator) throws InvalidEmailException, InvalidPasswordException, DuplicateEmailException {
////        Optional<Traveler> optionalTraveler = travelerRepository.findByEmail(traveler.getEmail());
//        if (DataMaster.findCollaboratorByEmail(collaborator.getEmail()) != null) {
//            throw new DuplicateEmailException();
//        }
//
//        collaborator.verify();
//        collaborator.setPassword(HashingUtils.hashPassword(collaborator.getPassword().toCharArray()));
//        DataMaster.save(collaborator);
//        collaborator.setPassword(null);
//        collaborator.setOtp(null);
//        collaborator.setExpiredOTPTime(null);
//        return collaborator;
//    }
//
//    public Collaborator login(Collaborator collaborator) {
//        Collaborator coll = DataMaster.findCollaboratorByEmail(collaborator.getEmail());
//        if (coll != null) {
//            if (HashingUtils.verifyPassword(coll.getPassword(), collaborator.getPassword().toCharArray())) {
//                coll.setPassword(null);
//                coll.setOtp(null);
//                coll.setExpiredOTPTime(null);
//                return coll;
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }
}
