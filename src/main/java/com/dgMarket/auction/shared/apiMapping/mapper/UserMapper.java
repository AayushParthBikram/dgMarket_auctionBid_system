package com.dgMarket.auction.shared.apiMapping.mapper;

import com.dgMarket.auction.features.pages.users.entity.User;
import com.dgMarket.auction.shared.apiMapping.dtos.RegisterUser;
import com.dgMarket.auction.shared.apiMapping.dtos.UpdateUserRequest;
import com.dgMarket.auction.shared.apiMapping.dtos.UserResponse;
import com.dgMarket.auction.shared.config.MapperConfig;
import org.mapstruct.*;


@Mapper(config = MapperConfig.class, uses = {RoleMapper.class, AddressMapper.class, BuyerMapper.class, SellerMapper.class})
public interface UserMapper {



    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "userName", source = "userName"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "userType",source = "userType"),
            @Mapping(target = "roles", source = "roles"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "createdAt", source = "createdAt"),
            @Mapping(target = "updatedAt", source = "updatedAt"),
            @Mapping(target = "createdBy", source = "createdBy"),
            @Mapping(target = "updatedBy", source = "updatedBy")
    })
    UserResponse toUserResponse(User user);




    @Mappings({
            @Mapping(target = "id", ignore = true),

    })
    User toEntity(RegisterUser registerUser);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UpdateUserRequest request, @MappingTarget User user);


}
