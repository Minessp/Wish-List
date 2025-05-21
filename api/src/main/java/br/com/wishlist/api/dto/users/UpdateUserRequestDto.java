package br.com.wishlist.api.dto.users;

public record UpdateUserRequestDto(Long id, String field, String fieldValue, String password) {
}
