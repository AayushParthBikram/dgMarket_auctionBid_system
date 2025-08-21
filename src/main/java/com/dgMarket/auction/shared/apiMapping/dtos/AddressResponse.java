package com.dgMarket.auction.shared.apiMapping.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressResponse {
    private Long id;
    private String countryName;
    private String cityName;

    private String address1;
    private String address2;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
