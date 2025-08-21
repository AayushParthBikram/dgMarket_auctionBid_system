package com.dgMarket.auction.features.acl.role.entity;


import com.dgMarket.auction.features.acl.role.enums.RoleType;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String roleName;

    @Column(name = "role_type", unique = true)
    private RoleType roleType;


    public Role(RoleType roleType) {
        this.roleType = roleType;
        setRoleNameBasedOnType();
    }


    private static final Map<RoleType, String> roleNameMap = Map.of(
            RoleType.ROLE_SUPER_ADMIN, "Super Admin",
            RoleType.ROLE_ADMIN, "Admin",
            RoleType.ROLE_SELLER, "Seller",
            RoleType.ROLE_BUYER, "Buyer",
            RoleType.ROLE_CREATOR, "Creator"
    );


    private void setRoleNameBasedOnType() {
        if (this.roleType != null) {
            this.roleName = roleNameMap.getOrDefault(this.roleType, this.roleType.name()
                    .replace("ROLE_", "")
                    .replace("_", " ")
                    .toLowerCase());


            this.roleName = Character.toUpperCase(this.roleName.charAt(0)) + this.roleName.substring(1);


        }
    }

    @PostLoad
    @PostPersist
    @PostUpdate
    private void onPersistOrLoad() {
        setRoleNameBasedOnType();
    }


    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
        setRoleNameBasedOnType();
    }

}
