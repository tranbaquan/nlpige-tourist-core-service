package com.nlpige.tourist.core.supporter.otp;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OTPRepository extends MongoRepository<OTP, String> {
    Optional<OTP> findByEmail(String email);
    void deleteByEmail(String email);
}
