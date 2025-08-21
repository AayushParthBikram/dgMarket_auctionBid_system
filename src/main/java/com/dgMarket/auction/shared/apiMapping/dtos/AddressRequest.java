package com.dgMarket.auction.shared.apiMapping.dtos;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    private String countryName;
    private String cityName;

    private String address1;
    private String address2;
}
