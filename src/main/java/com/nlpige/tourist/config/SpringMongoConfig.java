package com.nlpige.tourist.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class SpringMongoConfig {
    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(
                new MongoClient(
                        new MongoClientURI("mongodb+srv://nltour_webservice:nltour_webservice@nltour-5iwl5.mongodb.net/test?retryWrites=true")
                ), "nltour");
        return mongoTemplate;
    }
}
