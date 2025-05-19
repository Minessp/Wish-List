package br.com.wishlist.api.dto.users;

public record UserDto(Long id, String username, String email, String password, String role) {
    public UserDto(Long id, String username, String email, String role) {
        this(id, username, email, "Not available in response body", role);
    }

    public UserDto(String username, String email, String role) {
        this(null, username, email, "Not available in response body", role);
    }
}
