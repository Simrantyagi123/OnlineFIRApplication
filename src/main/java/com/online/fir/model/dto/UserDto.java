package com.online.fir.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class UserDto {
    @NotNull
    String phone;

    String firstName;

    String lastName;

    @NotNull
    String password;
}
