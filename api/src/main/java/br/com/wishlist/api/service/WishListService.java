package br.com.wishlist.api.service;

import br.com.wishlist.api.dto.wishlists.*;
import br.com.wishlist.api.model.WishList;
import br.com.wishlist.api.repository.UserRepository;
import br.com.wishlist.api.repository.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishListService {
    private final WishListRepository wishListRepository;
    private final UserRepository userRepository;

    public WishListService(WishListRepository wishListRepository, UserRepository userRepository) {
        this.wishListRepository = wishListRepository;
        this.userRepository = userRepository;
    }

    public List<WishListResponse> getAllWishLists() {
        return wishListRepository.findAll().stream().map(wishList -> WishListResponse
                .builder()
                .id(wishList.getId())
                .name(wishList.getName())
                .userid(wishList.getUser().getId())
                .build()
        ).collect(Collectors.toList());
    }

    public List<WishListResponse> getWishListByUserId(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("Wishlists not found using userid: " + id);
        }

        return wishListRepository.findAllByUserId(id).stream().map(wishList -> WishListResponse
                .builder()
                .id(wishList.getId())
                .name(wishList.getName())
                .userid(wishList.getUser().getId())
                .build()
        ).collect(Collectors.toList());
    }

    public CreateWishListResponse createWishList(CreateWishListRequest createWishListRequest) {
        if (!userRepository.existsByUsername(createWishListRequest.username())) {
            throw new IllegalArgumentException("User not found using username: " + createWishListRequest.username());
        }

        wishListRepository.save(new WishList(createWishListRequest.name(),
                userRepository.getUserByUsername(createWishListRequest.username())));

        return CreateWishListResponse
                .builder()
                .name(createWishListRequest.name())
                .userid(userRepository.getUserByUsername(createWishListRequest.username()).getId())
                .build();
    }

    public WishListResponse updateWishList(UpdateWishListRequest request) {
        if(!wishListRepository.existsById(request.id())){
            throw new IllegalArgumentException("Wishlist not found using id: " + request.id());
        }

        WishList wishList = wishListRepository.getById(request.id());
        wishList.setName(request.name());

        wishListRepository.save(wishList);

        return WishListResponse
                .builder()
                .id(wishList.getId())
                .name(wishList.getName())
                .userid(wishList.getUser().getId())
                .build();
    }

    // Verificar lógica de envio de ID da wishlist
    public void deleteWishList(DeleteWishListRequest request) {
        if(!wishListRepository.existsById(request.id())){
            throw new IllegalArgumentException("Wishlist not found using id: " + request.id());
        }

        wishListRepository.deleteById(request.id());
    }
}
