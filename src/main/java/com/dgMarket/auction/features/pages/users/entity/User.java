package com.dgMarket.auction.features.pages.users.entity;


import com.dgMarket.auction.features.acl.role.entity.Buyer;
import com.dgMarket.auction.features.acl.role.entity.Role;
import com.dgMarket.auction.features.acl.role.entity.Seller;
import com.dgMarket.auction.features.pages.users.enums.UserType;
import com.dgMarket.auction.shared.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "unique_user_id", unique = true, nullable = false)
    private String userId;




    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_number", nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    @Email(message = "There should be a valid email format")
    private String email;

    @Column(name = "username", unique = true, nullable = false)
    @NotNull(message = "UserName is required to validate the user ")
    private String userName;


    @Column(nullable = false, unique = true)
    @NotBlank(message = "password field cannot be kept as empty")
    private String password;

    @Column(nullable = false)
    private String designation;

    @Column(name = "user_type")
    @Enumerated(EnumType.ORDINAL)
    private UserType userType;





    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "title_id")
    private Title title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;







}
