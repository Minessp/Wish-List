package br.com.wishlist.api.dto.users;

import lombok.Builder;

@Builder
public record CreateUserRequest(String username, String email, String password, String role) {
}
