package br.com.wishlist.api.config;

import br.com.wishlist.api.core.gateway.UserGateway;
import br.com.wishlist.api.core.usecases.user.*;
import br.com.wishlist.api.infrastructure.gateway.UserRepositoryGateway;
import br.com.wishlist.api.infrastructure.mapper.user.UpdateUserMapper;
import br.com.wishlist.api.infrastructure.mapper.user.UserDTOMapper;
import br.com.wishlist.api.infrastructure.mapper.user.UserEntityMapper;
import br.com.wishlist.api.infrastructure.persistence.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    UserGateway userGateway(UserRepository userRepository,
                            UserEntityMapper userEntityMapper,
                            UpdateUserMapper updateUserMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper, updateUserMapper);
    }

    @Bean
    GetAllUsersCase getAllUsersCase(UserGateway userGateway) {
        return new GetAllUsersInteractor(userGateway);
    }

    @Bean
    GetUserByIdCase getUserByIdCase(UserGateway userGateway) {
        return new GetUserByIdInteractor(userGateway);
    }

    @Bean
    CreateUserCase createUserCase(UserGateway userGateway) {
        return new CreateUserInteractor(userGateway);
    }

    @Bean
    DeleteUserCase deleteUserCase(UserGateway userGateway) {
        return new DeleteUserInteractor(userGateway);
    }

    @Bean
    UpdateUserCase updateUserCase(UserGateway userGateway) {
        return new UpdateUserInteractor(userGateway);
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
