package com.nlpige.tourist.data;


import com.nlpige.tourist.config.SpringMongoConfig;
import com.nlpige.tourist.core.customer.model.Address;
import com.nlpige.tourist.core.customer.model.Gender;
import com.nlpige.tourist.core.customer.model.Languages;
import com.nlpige.tourist.core.traveler.model.Traveler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ on Tuesday, 11 December, 2018 at 23:54.
 *
 * @author Joseph Maria
 */
public class DataMaster {
    public void init() {
        Languages languages = new Languages("English");
        Traveler traveler = new Traveler("Quan", "Trần Bá", "231101668",
                "tranbaquan.tbq@gmail.com", Gender.MALE, LocalDate.of(1997,11,02),
                new Address("Viet Nam", "KTX Khu B DHQG"), languages, "123456",
                LocalDateTime.of(2018,12,14,17,30), "VN1234567");

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        MongoOperations mongoOperations = (MongoOperations) context.getBean("mongoTemplate");

        mongoOperations.save(traveler);
    }
}
