package br.com.wishlist.api.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("Invalid credentials: Your username or password is incorrect");
    }
}
