package com.dgMarket.auction.shared.apiMapping.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerRequest {
    private boolean activeStatus;
    private String contactNumber;
    private String email;
    private String organizationId;
    private String organizationName;
    private String organizationTypeName;
    private LocalDateTime registrationDate;
    private String registrationNumber;
    private String pan;
    private String website;
}
