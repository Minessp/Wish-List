package br.com.wishlist.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.wishlist.api.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
