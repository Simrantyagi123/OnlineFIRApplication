package com.online.fir.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ResponseStatusException.class)
    public ErrorResponse handleResponseStatusException(final ResponseStatusException responseStatusException) {
        return new ErrorResponse(LocalDateTime.now(), responseStatusException.getRawStatusCode(),
                responseStatusException.getStatus().name(), responseStatusException.getReason());
    }

}
