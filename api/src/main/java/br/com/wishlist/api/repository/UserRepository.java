package br.com.wishlist.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.wishlist.api.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findUserByEmail(String email);

    UserDetails findUserByUsername(String username);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    User getUserById(Long id);
}