package com.dgMarket.auction.features.pages.users.repository;

import com.dgMarket.auction.features.pages.users.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findAddressByAddressName(String address1, String address2);

    Optional<Address> findAddressByCityName(String cityName);

    Optional<Address> findAddressByCountryName(String country);
}
