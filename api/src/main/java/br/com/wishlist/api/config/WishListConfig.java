package br.com.wishlist.api.config;

import br.com.wishlist.api.core.gateway.WishListGateway;
import br.com.wishlist.api.core.usecases.wishlist.CreateWishListCase;
import br.com.wishlist.api.core.usecases.wishlist.CreateWishListInteractor;
import br.com.wishlist.api.infrastructure.gateway.WishListRepositoryGateway;
import br.com.wishlist.api.infrastructure.mapper.user.UserEntityMapper;
import br.com.wishlist.api.infrastructure.mapper.wishlist.WishListDTOMapper;
import br.com.wishlist.api.infrastructure.mapper.wishlist.WishListEntityMapper;
import br.com.wishlist.api.infrastructure.persistence.WishListRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WishListConfig {
    @Bean
    WishListGateway wishListGateway(WishListRepository wishlistRepository, WishListEntityMapper wishlistEntityMapper) {
        return new WishListRepositoryGateway(wishlistRepository, wishlistEntityMapper);
    }

    @Bean
    CreateWishListCase createWishListCase(WishListGateway wishListGateway) {
        return new CreateWishListInteractor(wishListGateway);
    }

    @Bean
    WishListEntityMapper wishListEntityMapper(UserEntityMapper userEntityMapper){
        return new WishListEntityMapper(userEntityMapper);
    }

    @Bean
    WishListDTOMapper wishListDTOMapper() {
        return new WishListDTOMapper();
    }
}
