package com.dgMarket.auction.features.pages.users.entity;

import com.dgMarket.auction.features.acl.role.entity.Buyer;
import com.dgMarket.auction.features.acl.role.entity.Role;
import com.dgMarket.auction.features.acl.role.entity.Seller;
import com.dgMarket.auction.features.pages.users.enums.UserType;
import com.dgMarket.auction.shared.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_invitation")
public class UserInvitation extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    private int status;

    @Column(name = "unique_id")
    private int uniqueId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "user_type")
    private UserType userType;

    @NotBlank(message = "Email cannot be put as Empty")
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email_verification")
    private int emailVerification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();






}
