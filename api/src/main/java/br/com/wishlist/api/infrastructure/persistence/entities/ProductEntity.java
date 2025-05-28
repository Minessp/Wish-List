package br.com.wishlist.api.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

@Builder
@Entity
@Table(name = "produto")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "link")
    private String link;

    @Column(name = "preco")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "wish_list_id")
    private WishListEntity wishListEntity;

    public ProductEntity(String link, String name, BigDecimal price, WishListEntity wishListEntity) {
        this.link = link;
        this.name = name;
        this.price = price;
        this.wishListEntity = wishListEntity;
    }

    public ProductEntity() {}
}
