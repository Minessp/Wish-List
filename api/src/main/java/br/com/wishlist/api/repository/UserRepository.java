package br.com.wishlist.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.wishlist.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<Object> findByEmail(String email);

    User getUserByEmail(String email);

    Optional<User> findUserByUsername(String username);
}