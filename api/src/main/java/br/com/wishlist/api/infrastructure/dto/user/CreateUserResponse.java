package br.com.wishlist.api.infrastructure.dto.user;

import lombok.Builder;

@Builder
public record CreateUserResponse(String username, String email, String role) {
}
