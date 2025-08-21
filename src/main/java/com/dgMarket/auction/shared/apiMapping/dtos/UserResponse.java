package com.dgMarket.auction.shared.apiMapping.dtos;


import com.dgMarket.auction.features.acl.role.entity.Buyer;
import com.dgMarket.auction.features.acl.role.entity.Role;
import com.dgMarket.auction.features.pages.users.enums.UserType;
import lombok.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String userName;
    private String email;
    private UserType userType;
    private Set<RoleResponse> roles;
    private AddressResponse address;
    private LocalDateTime createdAt;
    private UserResponse createdBy;
    private LocalDateTime updatedAt;
    private UserResponse updatedBy;


}
