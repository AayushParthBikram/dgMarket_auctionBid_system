package com.dgMarket.auction.shared.apiMapping.mapper;

import com.dgMarket.auction.features.pages.users.entity.Address;
import com.dgMarket.auction.shared.apiMapping.dtos.AddressRequest;
import com.dgMarket.auction.shared.apiMapping.dtos.AddressResponse;
import com.dgMarket.auction.shared.config.MapperConfig;
import org.mapstruct.*;

@Mapper(config = MapperConfig.class)
public interface AddressMapper {



    @Mapping(target = "cityName", expression = "java(address.getCity() != null ? address.getCity().getName() : null)")
    @Mapping(target = "countryName", expression = "java(address.getCountry() != null ? address.getCountry().getName() : null)")
    @Mapping(target = "createdDate", source = "createdAt")
    @Mapping(target = "updatedDate", source = "updatedAt")
    AddressResponse toAddressResponse(Address address);




    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "country", expression = "java(mapCountry(addressRequest.getCountryName()))")
    @Mapping(target = "city", expression = "java(mapCity(addressRequest.getCityName()))")
    Address toEntity(AddressRequest addressRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAddressFromDto(AddressRequest addressRequest, @MappingTarget Address address);
}
