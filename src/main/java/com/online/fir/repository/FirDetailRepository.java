package com.online.fir.repository;

import com.online.fir.model.entity.FirDetail;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FirDetailRepository extends MongoRepository<FirDetail, ObjectId> {
    FirDetail findByFirId(final String firId);
}
