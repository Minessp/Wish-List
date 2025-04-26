package br.com.wishlist.api.repository;

import br.com.wishlist.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByWishListId(Long wishListId);

    Product findByName(String name);
}
