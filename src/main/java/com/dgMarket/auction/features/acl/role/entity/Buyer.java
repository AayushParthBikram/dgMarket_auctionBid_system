package com.dgMarket.auction.features.acl.role.entity;


import com.dgMarket.auction.features.acl.role.enums.BuyerActiveStatus;
import com.dgMarket.auction.shared.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buyer")
public class Buyer extends BaseEntity {



    @Column(name = "contact_number")
    private String contactNumber;

    @Column(nullable = false)
    @Email(message = "There should be a valid email format")
    private String email;

    @Column(name = "org_id", unique = true)
    private String organizationId;

    @Column(name = "org_name")
    private String organizationName;

    @Column(name = "reg_date")
    private LocalDateTime registrationDate;

    @Column(name = "reg_number")
    private String registrationNumber;

    @Column(name = "vat_pan")
    private String pan;

    private String website;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_type_id")
    private BuyerOrganizationTypes buyerOrganizationTypes;

    @Column(name = "active_status")
    private BuyerActiveStatus activeStatus;

    @ManyToMany
    @JoinTable(name="sector_buyer", joinColumns = @JoinColumn(name="sector_id", referencedColumnName = "id"))
    private List<Sector> sectors = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE
    })
    @JoinColumn(name = "parent_id")
    private Buyer parentBuyer;
}
