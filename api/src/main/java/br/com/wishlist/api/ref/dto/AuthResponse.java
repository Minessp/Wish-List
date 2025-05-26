package br.com.wishlist.api.dto;

import lombok.Builder;

@Builder
public record AuthResponse(String token) {
}
