package br.com.wishlist.api.service;

import br.com.wishlist.api.dto.UpdateWishListRequestDto;
import br.com.wishlist.api.dto.WishListDto;
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
        return wishListRepository.findAll().stream().map(wishList -> new WishListDto(wishList.getName(),
                wishList.getUser())).collect(Collectors.toList());
    }

    public List<WishListDto> getWishListById(Long id) {
        return wishListRepository.findAllByUserId(id).stream().map(wishList -> new WishListDto(wishList.getName(),
                wishList.getUser())).collect(Collectors.toList());
    }

    public WishListDto createWishList(WishListDto wishListDto) {
        User user = userRepository.getUserByUsername(wishListDto.user().getUsername());
        wishListRepository.save(new WishList(wishListDto.name(),
                user));
        return new WishListDto(wishListDto.name(), user);
    }

    public WishListDto updateWishList(UpdateWishListRequestDto request) {
        WishList wishList = wishListRepository.getByName(request.oldWishList().name());
        wishList.setName(request.newWishList().name());
        wishListRepository.save(wishList);
        return new WishListDto(wishList.getName(), wishList.getUser());
    }

    public void deleteWishList(WishListDto wishListDto) {
        wishListRepository.delete(wishListRepository.getByName(wishListDto.name()));
    }
}
