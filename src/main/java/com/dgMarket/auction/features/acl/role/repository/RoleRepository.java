package com.dgMarket.auction.features.acl.role.repository;


import com.dgMarket.auction.features.acl.role.enums.RoleType;
import com.dgMarket.auction.features.acl.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleType(RoleType roleType);
}