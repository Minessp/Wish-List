package br.com.wishlist.api.infrastructure.dto.user;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserResponse(UUID id, String username, String email, String role) {
}
