package br.com.wishlist.api.config;

import br.com.wishlist.api.core.gateway.UserGateway;
import br.com.wishlist.api.core.usecases.user.CreateUserCase;
import br.com.wishlist.api.core.usecases.user.CreateUserInteractor;
import br.com.wishlist.api.infrastructure.gateway.UserRepositoryGateway;
import br.com.wishlist.api.infrastructure.mapper.user.UserDTOMapper;
import br.com.wishlist.api.infrastructure.mapper.user.UserEntityMapper;
import br.com.wishlist.api.infrastructure.persistence.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper);
    }

    @Bean
    CreateUserCase createUserCase(UserGateway userGateway) {
        return new CreateUserInteractor(userGateway);
    }

    @Bean
    UserEntityMapper userEntityMapper(){
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }
}
