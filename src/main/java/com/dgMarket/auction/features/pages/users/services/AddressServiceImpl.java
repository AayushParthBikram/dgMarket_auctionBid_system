package com.dgMarket.auction.features.pages.users.services;


import com.dgMarket.auction.features.pages.users.entity.Address;
import com.dgMarket.auction.features.pages.users.repository.AddressRepository;
import com.dgMarket.auction.shared.apiMapping.dtos.AddressRequest;
import com.dgMarket.auction.shared.apiMapping.dtos.AddressResponse;
import com.dgMarket.auction.shared.apiMapping.mapper.AddressMapper;
import com.dgMarket.auction.shared.exceptions.AddressNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressResponse createAddress(AddressRequest addressRequest) {

        Address address = addressMapper.toEntity(addressRequest);
        addressRepository.save(address);

        return addressMapper.toAddressResponse(address);

    }

    @Override
    public AddressResponse updateAddress(Long id, AddressRequest addressRequest) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address has not been found with given id:" + id));
        addressMapper.updateAddressFromDto(addressRequest, address);
        address = addressRepository.save(address);
        return addressMapper.toAddressResponse(address);
        
    }

    @Override
    public AddressResponse getAddressById(Long id) {
        return null;
    }

    @Override
    public Page<AddressResponse> getAllAddresses(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteAllAddress(Long id) {

    }
}
