package br.com.wishlist.api.infrastructure.dto.auth;

import lombok.Builder;

@Builder
public record AuthResponse(String token) {
}
