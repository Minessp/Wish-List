package br.com.wishlist.api.dto.users;

public record UpdateUserRequestDto(UserDto newUserData, UserDto oldUserData) {
}
