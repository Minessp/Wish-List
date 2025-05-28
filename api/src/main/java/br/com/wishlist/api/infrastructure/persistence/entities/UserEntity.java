package br.com.wishlist.api.infrastructure.persistence.entities;

import br.com.wishlist.api.core.enums.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<WishListEntity> wishlists;

    public UserEntity() {}

    public UserEntity(String username, String email, String encodedPassword, String role, List<WishListEntity> wishlists) {
        this.username = username;
        this.email = email;
        this.password = encodedPassword;
        this.role = Role.valueOf(role);
        this.wishlists = wishlists;
    }
}
