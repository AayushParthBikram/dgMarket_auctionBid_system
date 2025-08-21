package com.dgMarket.auction.features.acl.role.entity;

import com.dgMarket.auction.features.pages.users.entity.User;
import com.dgMarket.auction.shared.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seller")
public class Seller extends BaseEntity  {

    @Column(name = "active_status")
    private Boolean activeStatus;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    @Email(message = "There should be a valid email format")
    private String email;

    @Column(name = "org_id")
    private String organizationId;

    @Column(name = "org_name")
    private String organizationName;


    @Column(name = "reg_date")
    private LocalDate registrationDate;

    @Column(name = "reg_number")
    @Positive(message = "The number should be a positive number")
    private String registrationNumber;

    @Column(name = "vat_pan")
    private String Pan;


    private String website;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
