package com.online.fir.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    @NotNull
    String phone;

    String firstName;

    String lastName;

    String password;
}
