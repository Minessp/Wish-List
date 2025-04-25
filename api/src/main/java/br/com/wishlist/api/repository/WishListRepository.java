package br.com.wishlist.api.repository;

import br.com.wishlist.api.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WishListRepository extends JpaRepository<WishList, Long> {
    List<WishList> findAllByUserId(Long user_id);
}
