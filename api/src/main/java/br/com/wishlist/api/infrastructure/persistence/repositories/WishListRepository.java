package br.com.wishlist.api.infrastructure.persistence.repositories;

import br.com.wishlist.api.infrastructure.dto.wishlist.WishListResponse;
import br.com.wishlist.api.infrastructure.persistence.entities.WishListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface WishListRepository extends JpaRepository<WishListEntity, Long> {
    WishListResponse findWishListById(Long id);
}
