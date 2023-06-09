package com.online.fir.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FirDetailDto {

    String firId;

    @NotNull
    String name;

    String gender;

    String address;

    @NotNull
    String crimeDetails;

    String complainerName;

    String complainerPhone;
}
