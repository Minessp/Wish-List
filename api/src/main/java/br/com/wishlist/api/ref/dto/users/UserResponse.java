package br.com.wishlist.api.dto.users;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String username, String email, String role) {
}
