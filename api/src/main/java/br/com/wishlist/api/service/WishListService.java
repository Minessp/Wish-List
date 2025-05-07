package br.com.wishlist.api.service;

import br.com.wishlist.api.dto.users.UserDto;
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

    public List<WishListDto> getAllWishLists() {
        return wishListRepository.findAll().stream().map(wishList -> new WishListDto(wishList.getId(), wishList.getName(),
                wishList.getUser().getId())).collect(Collectors.toList());
    }

    public List<WishListDto> getWishListById(Long id) {
        return wishListRepository.findAllByUserId(id).stream().map(wishList -> new WishListDto(wishList.getId(),
                wishList.getName(), wishList.getUser().getId())).collect(Collectors.toList());
    }

    public WishListDto createWishList(WishListDto wishListDto) {
        wishListRepository.save(new WishList(wishListDto.name(), userRepository.getUserById(wishListDto.userId())));

        return new WishListDto(wishListDto.id(), wishListDto.name(), wishListDto.userId());
    }

    public WishListDto updateWishList(UpdateWishListRequestDto request) {
        WishList wishList = wishListRepository.getById(request.id());
        wishList.setName(request.name());

        wishListRepository.save(wishList);

        return new WishListDto(wishList.getId(), wishList.getName(), wishList.getUser().getId());
    }

    public void deleteWishList(WishListDto wishListDto) {
        wishListRepository.deleteById(wishListDto.id());
    }
}
