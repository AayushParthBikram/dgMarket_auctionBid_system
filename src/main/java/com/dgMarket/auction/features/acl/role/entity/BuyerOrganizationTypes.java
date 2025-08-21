package com.dgMarket.auction.features.acl.role.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buyer_org_types")
public class BuyerOrganizationTypes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "organizationType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Buyer> buyers = new HashSet<>();
}
