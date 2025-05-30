package br.com.wishlist.api.infrastructure.mapper.wishlist;

import br.com.wishlist.api.core.domain.WishList;
import br.com.wishlist.api.infrastructure.dto.wishlist.CreateWishListRequest;
import br.com.wishlist.api.infrastructure.dto.wishlist.CreateWishListResponse;
import br.com.wishlist.api.infrastructure.dto.wishlist.WishListResponse;
import br.com.wishlist.api.infrastructure.persistence.repositories.UserRepository;

public class WishListDTOMapper {
    private final UserRepository userRepository;

    public WishListDTOMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public WishList fromCreateRequestToWishList(CreateWishListRequest request) {
        return new WishList(request.name(),
                       userRepository.getUserById(request.userId()));
    }

    public CreateWishListResponse fromWishListToCreateResponse(WishList wishList) {
        return CreateWishListResponse
                .builder()
                .name(wishList.name())
                .userid(wishList.user().id())
                .build();
    }

    public WishList fromWishListResponseToWishList(WishListResponse response) {
        return new WishList(response.id(),
                            response.name(),
                            userRepository.getUserById(response.userId()));
    }
}
