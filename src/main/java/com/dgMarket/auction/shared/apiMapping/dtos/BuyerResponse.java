package com.dgMarket.auction.shared.apiMapping.dtos;


import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerResponse {
    private Long id;
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

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
