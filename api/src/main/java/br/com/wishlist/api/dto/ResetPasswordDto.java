package br.com.wishlist.api.dto;

public record ResetPasswordDto(String email, String code, String password) {
}
