package com.online.fir.model.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "UserDatabase")
public class User {
    @Id
    ObjectId id;

    @Field("Phone")
    @Indexed(unique = true)
    String phone;

    /* First name of the user */
    @Field("FirstName")
    String firstName;

    /* Last name of the user */
    @Field("LastName")
    String lastName;

    @ToString.Exclude
    @Field("Password")
    String password;

}
