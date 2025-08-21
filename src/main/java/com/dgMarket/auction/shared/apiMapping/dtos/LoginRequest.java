package com.dgMarket.auction.shared.apiMapping.dtos;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String userName;
    private String password;

}
