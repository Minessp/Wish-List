package br.com.wishlist.api.dto.users;

import lombok.Builder;

@Builder
public record CreateUserResponse(String username, String email, String role) {
}
