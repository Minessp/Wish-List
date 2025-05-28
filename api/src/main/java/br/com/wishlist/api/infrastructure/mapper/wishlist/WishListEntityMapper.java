package br.com.wishlist.api.infrastructure.mapper.wishlist;

import br.com.wishlist.api.core.domain.WishList;
import br.com.wishlist.api.infrastructure.mapper.user.UserEntityMapper;
import br.com.wishlist.api.infrastructure.persistence.entities.WishListEntity;

public class WishListEntityMapper {
    private final UserEntityMapper userEntityMapper;

    public WishListEntityMapper(UserEntityMapper userEntityMapper) {
        this.userEntityMapper = userEntityMapper;
    }

    public WishListEntity toEntity(WishList wishList){
        return WishListEntity
                .builder()
                .name(wishList.name())
                .user(userEntityMapper.toEntity(wishList.user()))
                .build();
    }

    public WishList toDomain(WishListEntity wishListEntity){
        return new WishList(
                wishListEntity.getName(),
                userEntityMapper.toDomain(wishListEntity.getUser())
        );
    }
}
