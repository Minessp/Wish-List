package br.com.wishlist.api.infrastructure.dto.user;

import java.util.UUID;

public record UpdateUserRequest(UUID id,
                                String username,
                                String email,
                                String newPassword,
                                String confirmPassword) {
}
