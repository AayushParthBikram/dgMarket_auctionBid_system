package com.dgMarket.auction.shared.apiMapping.dtos;


import com.dgMarket.auction.features.acl.role.enums.RoleType;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {

    private Long id;
    private RoleType roleType;
    private String roleName;


}
