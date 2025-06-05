package br.com.wishlist.api.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ApiError apiErrorMethod(RuntimeException e, HttpStatus httpStatus) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String formatTimestamp = now.format(formatter);

        return ApiError.builder()
                .timestamp(formatTimestamp)
                .code(httpStatus.value())
                .errors(List.of(e.getMessage()))
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> badRequestExceptions(RuntimeException e) {
        ApiError apiError = apiErrorMethod(e, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ApiError> securityExceptions(RuntimeException e) {
        ApiError apiError = apiErrorMethod(e, HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }
}
