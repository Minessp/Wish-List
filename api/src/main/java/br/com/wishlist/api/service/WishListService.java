package br.com.wishlist.api.service;

import br.com.wishlist.api.dto.wishlists.ListWishListResponse;
import br.com.wishlist.api.dto.wishlists.UpdateWishListRequestDto;
import br.com.wishlist.api.dto.wishlists.WishListDto;
import br.com.wishlist.api.model.User;
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

    public List<ListWishListResponse> getAllWishLists() {
        return wishListRepository.findAll().stream().map(wishList -> new ListWishListResponse(wishList.getId(),
                wishList.getName(), wishList.getUser().getId())).collect(Collectors.toList());
    }

    public List<ListWishListResponse> getWishListByUserId(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("Wishlists not found using userid: " + id);
        }

        return wishListRepository.findAllByUserId(id).stream().map(wishList -> new ListWishListResponse(wishList.getId(),
                wishList.getName(), wishList.getUser().getId())).collect(Collectors.toList());
    }

    public WishListDto createWishList(WishListDto wishListDto) {
        if (!userRepository.existsByUsername(wishListDto.username())) {
            throw new IllegalArgumentException("User not found using username: " + wishListDto.username());
        }

        wishListRepository.save(new WishList(wishListDto.name(),
                userRepository.getUserByUsername(wishListDto.username())));

        return new WishListDto(wishListDto.name(), wishListDto.username());
    }

    // Verificar lógica de envio de ID da wishlist
    public ListWishListResponse updateWishList(UpdateWishListRequestDto request) {
        WishList wishList = wishListRepository.getById(request.id());
        wishList.setName(request.name());

        wishListRepository.save(wishList);

        return new ListWishListResponse(wishList.getId(), wishList.getName(), wishList.getUser().getId());
    }

    // Verificar lógica de envio de ID da wishlist
    public void deleteWishList(WishListDto wishListDto) {
        wishListRepository.deleteById(wishListDto.id());
    }
}
