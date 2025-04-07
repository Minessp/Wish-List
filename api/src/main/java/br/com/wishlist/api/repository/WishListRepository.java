package br.com.wishlist.api.repository;

import br.com.wishlist.api.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface WishListRepository extends JpaRepository<WishList, Long> {
}
