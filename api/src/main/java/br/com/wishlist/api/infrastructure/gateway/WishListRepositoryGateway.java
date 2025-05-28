package br.com.wishlist.api.infrastructure.gateway;

import br.com.wishlist.api.core.domain.WishList;
import br.com.wishlist.api.core.gateway.WishListGateway;
import br.com.wishlist.api.infrastructure.mapper.wishlist.WishListEntityMapper;
import br.com.wishlist.api.infrastructure.persistence.repositories.WishListRepository;
import br.com.wishlist.api.infrastructure.persistence.entities.WishListEntity;

public class WishListRepositoryGateway implements WishListGateway {
    private final WishListRepository wishListRepository;
    private final WishListEntityMapper wishListEntityMapper;

    public WishListRepositoryGateway(WishListRepository wishListRepository, WishListEntityMapper wishListEntityMapper) {
        this.wishListRepository = wishListRepository;
        this.wishListEntityMapper = wishListEntityMapper;
    }

    @Override
    public WishList createWishList(WishList wishList) {
        WishListEntity wishlistEntity = wishListEntityMapper.toEntity(wishList);
        WishListEntity savedWishList = wishListRepository.save(wishlistEntity);
        return wishListEntityMapper.toDomain(savedWishList);
    }
}
