package com.dgMarket.auction.features.pages.users.services;

import com.dgMarket.auction.shared.apiMapping.dtos.AddressRequest;
import com.dgMarket.auction.shared.apiMapping.dtos.AddressResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressService {

    AddressResponse createAddress(AddressRequest addressRequest);
    AddressResponse updateAddress(Long id, AddressRequest addressRequest);

    AddressResponse getAddressById(Long id);

    Page<AddressResponse> getAllAddresses(Pageable pageable);

    void deleteAllAddress(Long id);
}
