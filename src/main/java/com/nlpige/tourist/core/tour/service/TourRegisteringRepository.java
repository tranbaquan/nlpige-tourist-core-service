package com.nlpige.tourist.core.tour.service;

import com.nlpige.tourist.core.tour.model.TourRegisteringEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by IntelliJ on Saturday, 05 January, 2019 at 15:35.
 *
 * @author Joseph Maria
 */
public interface TourRegisteringRepository extends MongoRepository<TourRegisteringEntity, String> {

}
