package br.com.wishlist.api.infrastructure.mapper.user;

import br.com.wishlist.api.infrastructure.dto.user.UpdateUserRequest;
import br.com.wishlist.api.infrastructure.persistence.entities.UserEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UpdateUserMapper {
    @Mapping(target = "wishlists", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "username")
    @Mapping(target = "email")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserEmail(UpdateUserRequest request, @MappingTarget UserEntity user);

    @Mapping(target = "wishlists", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "username")
    @Mapping(target = "email")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserUsername(UpdateUserRequest request, @MappingTarget UserEntity user);
}