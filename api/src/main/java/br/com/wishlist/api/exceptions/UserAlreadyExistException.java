package br.com.wishlist.api.exceptions;

import java.io.IOException;

public class UserAlreadyExistException extends IOException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
