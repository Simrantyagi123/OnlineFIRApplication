package com.online.fir.repository;

import com.online.fir.model.entity.Station;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StationRepository extends MongoRepository<Station, ObjectId> {
    Station findByName(final String name);
}
