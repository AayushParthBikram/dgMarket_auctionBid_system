package com.dgMarket.auction.shared.apiMapping.mapper;

import com.dgMarket.auction.features.acl.role.entity.Buyer;
import com.dgMarket.auction.features.acl.role.entity.BuyerOrganizationTypes;
import com.dgMarket.auction.shared.apiMapping.dtos.BuyerOrganizationTypeRequest;
import com.dgMarket.auction.shared.apiMapping.dtos.BuyerOrganizationTypesResponse;
import com.dgMarket.auction.shared.config.MapperConfig;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(config = MapperConfig.class)
public interface BuyerOrganizationTypesMapper {
    BuyerOrganizationTypesResponse toResponse(BuyerOrganizationTypes organizationTypes);

    List<BuyerOrganizationTypes> toResponseList(List<BuyerOrganizationTypes> buyerOrganizationTypes);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "buyers", ignore = true)
    BuyerOrganizationTypes toEntity(BuyerOrganizationTypeRequest buyerOrganizationTypeRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "buyers", ignore = true)

    })
    void updateFromDto(BuyerOrganizationTypeRequest buyerOrganizationTypeRequest, @MappingTarget BuyerOrganizationTypes buyerOrganizationTypes);



}
