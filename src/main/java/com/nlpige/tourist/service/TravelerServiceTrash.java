package com.nlpige.tourist.service;

import org.springframework.stereotype.Service;

@Service
public class TravelerServiceTrash {
//    @Autowired
//    private TravelerRepository travelerRepository;
    //todo

//    public Traveler createTraveler(Traveler traveler) throws InvalidEmailException, InvalidPasswordException, DuplicateEmailException {
////        Optional<Traveler> optionalTraveler = travelerRepository.findByEmail(traveler.getEmail());
//        if (DataMaster.findTravelerByEmail(traveler.getEmail()) != null) {
//            throw new DuplicateEmailException();
//        }
//
//        traveler.verify();
//        traveler.setPassword(HashingUtils.hashPassword(traveler.getPassword().toCharArray()));
//        DataMaster.save(traveler);
//
//        traveler = new Traveler(traveler.getFirstName(), traveler.getLastName(), traveler.getPersonalID(), traveler.getEmail(), traveler.getGender(), traveler.getAddress(), traveler.getLanguages(), null, null, null, traveler.getCountry(), traveler.getPassport());
//        return traveler;
//    }
//
//    public Traveler login(Traveler arg) {
//        Traveler traveler = DataMaster.findTravelerByEmail(arg.getEmail());
//        if (traveler != null) {
//            if (HashingUtils.verifyPassword(traveler.getPassword(), arg.getPassword().toCharArray())) {
//                traveler = new Traveler(traveler.getFirstName(), traveler.getLastName(), traveler.getPersonalID(), traveler.getEmail(), traveler.getGender(), traveler.getAddress(), traveler.getLanguages(), null, null, null, traveler.getCountry(), traveler.getPassport());
//                traveler.setPassword(null);
//                traveler.setOtp(null);
//                traveler.setExpiredOTPTime(null);
//                return traveler;
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }
//
//    public String generateOTP(String email) throws InvalidKeyException, NoSuchAlgorithmException {
//        Traveler traveler = DataMaster.findTravelerByEmail(email);
//        if (traveler == null) {
//            return null;
//        }
//        if (traveler.getExpiredOTPTime() != null && traveler.getExpiredOTPTime().isBefore(LocalDateTime.now().minusMinutes(5))) {
//            return null;
//        }
//        String OTP = OneTimePasswordAlgorithm.generateOTP(UUID.randomUUID().toString().getBytes(), 5, 5, true, 5);
//        traveler.setOtp(HashingUtils.hashPassword(OTP.toCharArray()));
//        traveler.setExpiredOTPTime(LocalDateTime.now().plusMinutes(10));
//        return OTP;
//    }
//
//    public boolean resetPassword(String email, String OTP, String newPass) {
//        if (!OneTimePasswordAlgorithm.isValidOTP(OTP)) {
//            return false;
//        }
//        Traveler traveler = DataMaster.findTravelerByEmail(email);
//        if (traveler == null) {
//            return false;
//        }
//        if (!LocalDateTime.now().isBefore(traveler.getExpiredOTPTime())) {
//            return false;
//        }
//        if (!HashingUtils.verifyPassword(traveler.getOtp(), OTP.toCharArray())) {
//            return false;
//        }
//        traveler.setPassword(newPass);
//        System.out.println("Password change successfully: " + newPass);
//        return true;
//    }

}
