package com.online.fir.model.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "FIRDatabase")
public class FirDetail {

    @Id
    ObjectId id;

    @Field("FirId")
    @Indexed
    String firId;

    @Field("Name")
    String name;

    @Field("Gender")
    String gender;

    @Field("Address")
    String address;

    @Field("CrimeDetails")
    String crimeDetails;

    @Field("ComplainerName")
    String complainerName;

    @Field("Phone")
    String phone;
}
