package br.com.wishlist.api.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Builder
@Entity
@Table(name = "wishlists")
public class WishListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "wishList")
    private List<ProductEntity> products;

    public WishListEntity(Long id, String name, UserEntity user, List<ProductEntity> products) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.products = products;
    }

    public WishListEntity() {}
}
