package br.com.wishlist.api.exceptions.handler;

import br.com.wishlist.api.exceptions.PasswordNotMatchException;
import br.com.wishlist.api.exceptions.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            PasswordNotMatchException.class, UserAlreadyExistException.class
    })
    public ResponseEntity<ApiError> handleException(RuntimeException e) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String formatTimestamp = now.format(formatter);

        ApiError apiError = ApiError.builder()
                .timestamp(formatTimestamp)
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .errors(List.of(e.getMessage()))
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
