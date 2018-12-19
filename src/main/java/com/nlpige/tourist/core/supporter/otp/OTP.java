package com.nlpige.tourist.core.supporter.otp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "otp")
public class OTP {
    @Id
    private String email;
    @Field(value = "otp")
    private String otp;
    @Field(value = "expireTime")
    private LocalDateTime expireTime;
    @Field(value = "identifier")
    private String identifier;

    public OTP(String email, String otp) {
        this.email = email;
        this.otp = otp;
    }
}
