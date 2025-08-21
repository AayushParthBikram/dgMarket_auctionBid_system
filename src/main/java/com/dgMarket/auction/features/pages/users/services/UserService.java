package com.dgMarket.auction.features.pages.users.services;

import com.dgMarket.auction.features.acl.role.enums.RoleType;
import com.dgMarket.auction.shared.apiMapping.dtos.RegisterUser;
import com.dgMarket.auction.features.pages.users.enums.UserType;
import com.dgMarket.auction.shared.apiMapping.dtos.UpdateUserRequest;
import com.dgMarket.auction.shared.apiMapping.dtos.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface UserService {

    Page<UserResponse> getAllUsers(String userName, String email, UserType userType, Pageable pageable);

    UserResponse getUserById(Long id);




    @Transactional
    UserResponse createUser(RegisterUser registerUser, Long id);

    @Transactional
    UserResponse updateUser(Long id, UpdateUserRequest updateUserrequest);

    void deleteUser(Long id);

    UserResponse assignRoletoUser(Long userId, RoleType roleType);

    UserResponse removeRoleFromUser(Long userId, RoleType roleType);
}
