package com.dgMarket.auction.shared.apiMapping.dtos;

import com.dgMarket.auction.features.pages.users.enums.UserType;
import jakarta.validation.constraints.Email;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    private String userName;

    @Email(message = "Email must be a valid format")
    private String email;

    private String password;



    private UserType userType;

    private String city;

    private String address;


}
