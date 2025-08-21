package com.dgMarket.auction.shared.apiMapping.mapper;


import com.dgMarket.auction.features.acl.role.entity.Role;

import com.dgMarket.auction.shared.apiMapping.dtos.RoleResponse;
import com.dgMarket.auction.shared.config.MapperConfig;
import org.mapstruct.Mapper;




@Mapper(config = MapperConfig.class)
public interface RoleMapper {

    RoleResponse toRoleResponse(Role role);

    Role toEntity(RoleResponse response);




}
