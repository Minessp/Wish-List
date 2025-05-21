package br.com.wishlist.api.exceptions;

import java.io.IOException;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException() {
        super("User already exist");
    }
}
