package com.online.fir.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleResponseStatusException(final ResponseStatusException responseStatusException) {
        return ResponseEntity.status(responseStatusException.getRawStatusCode()).body(new ErrorResponse(LocalDateTime.now(), responseStatusException.getRawStatusCode(),
                responseStatusException.getStatus().name(), responseStatusException.getReason()));
    }

}
