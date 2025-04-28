package br.com.wishlist.api.dto.users;

public record UserDto(String username, String email, String password) {
    public UserDto(String username, String email) {
        this(username, email, "Not available in response body");
    }
}
