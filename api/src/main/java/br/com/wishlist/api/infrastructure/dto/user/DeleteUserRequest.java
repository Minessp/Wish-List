package br.com.wishlist.api.infrastructure.dto.user;

import java.util.UUID;

public record DeleteUserRequest(UUID id, String password) {
}
