package br.com.wishlist.api.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("Invalid credentials: Your password is incorrect");
    }
}
