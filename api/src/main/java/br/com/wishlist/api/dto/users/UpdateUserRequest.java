package br.com.wishlist.api.dto.users;

import lombok.Builder;

@Builder
public record UpdateUserRequest(Long id, String field, String fieldValue, String password) {
}
