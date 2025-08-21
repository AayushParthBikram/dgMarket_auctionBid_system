package com.dgMarket.auction.shared.apiMapping.mapper;


import com.dgMarket.auction.features.acl.role.entity.Buyer;
import com.dgMarket.auction.features.acl.role.entity.BuyerOrganizationTypes;
import com.dgMarket.auction.shared.apiMapping.dtos.BuyerOrganizationTypeRequest;
import com.dgMarket.auction.shared.apiMapping.dtos.BuyerRequest;
import com.dgMarket.auction.shared.apiMapping.dtos.BuyerResponse;
import com.dgMarket.auction.shared.config.MapperConfig;
import org.mapstruct.*;

import java.lang.annotation.Target;
import java.util.List;

@Mapper(config = MapperConfig.class, uses = {BuyerOrganizationTypesMapper.class})
public interface BuyerMapper {


    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "activeStatus", source = "activeStatus"),
            @Mapping(target = "contactNumber", source = "contactNumber"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "organizationId", source = "organizationId"),
            @Mapping(target = "organizationName", source = "organizationName"),
            @Mapping(target = "organizationTypeName", source = "buyerOrganizationTypes.name"),
            @Mapping(target = "registrationDate", source = "registrationDate"),
            @Mapping(target = "registrationNumber", source = "registrationNumber"),
            @Mapping(target = "pan", source = "pan"),
            @Mapping(target = "website", source = "website"),
            @Mapping(target = "createdAt", source = "createdAt"),
            @Mapping(target = "updatedAt", source = "updatedAt")


    })
    BuyerResponse toResponse(Buyer buyer);

    List<BuyerResponse> toResponseList(List<Buyer> buyers);


    @Mappings({
            @Mapping(target = "activeStatus", source = "activeStatus"),
            @Mapping(target = "contactNumber", source = "contactNumber"),
            @Mapping(target = "organizationName", source = "organizationName"),
            @Mapping(target = "registrationDate", source = "registrationDate"),
            @Mapping(target = "registrationNumber", source = "registrationNumber"),
            @Mapping(target = "pan", source = "pan"),
            @Mapping(target = "website", source = "website")
    })
    Buyer toEntity(BuyerRequest buyerRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBuyerFromDto(BuyerOrganizationTypeRequest buyerOrganizationTypeRequest, @MappingTarget Buyer buyer);
}
