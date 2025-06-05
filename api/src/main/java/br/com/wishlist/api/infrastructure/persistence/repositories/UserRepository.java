package br.com.wishlist.api.infrastructure.persistence.repositories;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);

    User getUserByEmail(String email);

    User findUserById(UUID subjectLong);

    UserDetails getUserByUsername(String username);

    User getUserById(UUID id);

    UserEntity getUserEntityById(UUID id);

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    boolean existsUserEntityById(UUID id);
}