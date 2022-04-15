package com.online.fir.model.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
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
@Document(collection = "StationDB")
public class Station {

    @Id
    ObjectId id;

    @Field("State")
    String state;

    @Field("District")
    String district;

    @Field("Name")
    @Indexed(unique = true)
    String name;

    @Field("Address")
    String address;

    @Field("Phone")
    String phone;

    @Field("InchargeName")
    String inchargeName;

}
