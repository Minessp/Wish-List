package br.com.wishlist.api.dto.users;

public record UserDto(Long id, String username, String email, String password) {
    public UserDto(Long id, String username, String email) {
        this(id, username, email, "Not available in response body");
    }
    public UserDto(String username, String email) {
        this(null, username, email, "Not available in response body");
    }
}
