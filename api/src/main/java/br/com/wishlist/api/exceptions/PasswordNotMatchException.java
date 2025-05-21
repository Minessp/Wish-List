package br.com.wishlist.api.exceptions;

public class PasswordNotMatchException extends RuntimeException {
    public PasswordNotMatchException() {
        super("The password sent does not match your current password");
    }
}
