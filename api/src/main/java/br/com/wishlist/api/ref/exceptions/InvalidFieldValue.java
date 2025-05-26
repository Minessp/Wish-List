package br.com.wishlist.api.exceptions;

public class InvalidFieldValue extends RuntimeException {
    public InvalidFieldValue() {
        super("Invalid field value");
    }
}
