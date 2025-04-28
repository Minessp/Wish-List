package br.com.wishlist.api.dto;

public record UpdateUserRequestDto(UserDto newUserData, UserDto oldUserData) {
}
