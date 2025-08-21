package com.dgMarket.auction.shared.apiMapping.dtos;


import com.dgMarket.auction.features.acl.role.entity.Role;
import com.dgMarket.auction.features.acl.role.enums.RoleType;
import com.dgMarket.auction.features.pages.users.entity.Title;
import com.dgMarket.auction.features.pages.users.enums.UserType;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUser {


    private Title title;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String password;
    private String userName;
    private String designation;
    private UserType userType;
    private AddressRequest addressRequest;
    private Set<RoleType> roles;

}
