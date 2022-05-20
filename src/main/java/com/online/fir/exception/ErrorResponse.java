package com.online.fir.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class ErrorResponse {

    LocalDateTime timestamp;

    int errorStatusCode;

    String errorStatusCodeName;

    String errorMessage;

}
