package br.com.wishlist.api.exceptions.handler;

import br.com.wishlist.api.exceptions.InvalidCredentialsException;
import br.com.wishlist.api.exceptions.InvalidFieldValue;
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

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ApiError> handleUserAlreadyExistException(RuntimeException e) {
        ApiError apiError = apiErrorMethod(e, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({
            PasswordNotMatchException.class,
            InvalidFieldValue.class,
            InvalidCredentialsException.class,
            IllegalArgumentException.class,
    })
    public ResponseEntity<ApiError> badRequestHandler(RuntimeException e) {
        ApiError apiError = apiErrorMethod(e, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
