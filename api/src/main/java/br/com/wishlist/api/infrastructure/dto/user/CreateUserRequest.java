package br.com.wishlist.api.infrastructure.dto.user;

public record CreateUserRequest(String username, String email, String password, String role) {
}
