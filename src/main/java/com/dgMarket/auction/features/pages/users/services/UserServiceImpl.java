package com.dgMarket.auction.features.pages.users.services;

import com.dgMarket.auction.features.acl.role.enums.RoleType;
import com.dgMarket.auction.features.acl.role.repository.RoleRepository;
import com.dgMarket.auction.features.pages.users.specifications.UserSpecification;
import com.dgMarket.auction.features.acl.role.entity.Role;
import com.dgMarket.auction.shared.apiMapping.dtos.RegisterUser;
import com.dgMarket.auction.features.pages.users.entity.User;
import com.dgMarket.auction.features.pages.users.enums.UserType;
import com.dgMarket.auction.features.pages.users.repository.UserRepository;
import com.dgMarket.auction.shared.apiMapping.dtos.UpdateUserRequest;
import com.dgMarket.auction.shared.apiMapping.dtos.UserResponse;
import com.dgMarket.auction.shared.apiMapping.mapper.UserMapper;
import com.dgMarket.auction.shared.exceptions.BiddingException;
import com.dgMarket.auction.shared.exceptions.ResourceNotFoundException;
import com.dgMarket.auction.shared.exceptions.UserNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Page<UserResponse> getAllUsers(String userName, String email, UserType userType, Pageable pageable) {

        Specification<User> specification = Specification.allOf(
                UserSpecification.hasUserNameLike(userName),
                UserSpecification.hasEmailLike(email),
                UserSpecification.hasUserTypeLike(userType)
        );

        Page<User> userPage = userRepository.findAll(specification, pageable);


        return userPage.map(userMapper::toUserResponse);

    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("The username not found with provided id :" + id));

        return userMapper.toUserResponse(user);


    }

    @Override
    @Transactional
    public UserResponse createUser(RegisterUser registerUser, Long id) {

        Optional<User> existingUserByUsername = userRepository.findByUserName(registerUser.getUserName());

        Optional<User> existingUserByEmail = userRepository.findByEmail(registerUser.getEmail());

        if (existingUserByUsername.isPresent() && !existingUserByUsername.get().getId().equals(id)) {
            throw new BiddingException("Please try some other username for creating new user, Since this has already been taken");
        }


        if (existingUserByEmail.isPresent() && !existingUserByEmail.get().getId().equals(id)) {

            throw new BiddingException("Please try some other email for creating new user, Since this has already been taken");

        }

        User user = userMapper.toEntity(registerUser);

        user.setPassword(passwordEncoder.encode(registerUser.getPassword()));


        if (registerUser.getRoles() != null && !registerUser.getRoles().isEmpty()) {
            for (RoleType roleType : registerUser.getRoles()) {
                Role role = roleRepository.findByRoleType(roleType)
                        .orElseThrow(() -> new ResourceNotFoundException("Role name not found with given role type:" + roleType.name()));

                user.setRoles(Set.of(role));
            }
        } else {
            Role byDefault = roleRepository.findByRoleType(RoleType.ROLE_BUYER)
                    .orElseThrow(() -> new ResourceNotFoundException("The roletype that has been given not found:" + RoleType.ROLE_BUYER));

            user.setRoles(Set.of(byDefault));
        }


        User savedUser = userRepository.save(user);

        return userMapper.toUserResponse(savedUser);
    }

    @Override
    @Transactional
    public UserResponse updateUser(Long id, UpdateUserRequest updateUserrequest) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("The username not found with given id :" + id));

        if (updateUserrequest.getUserName() != null && !updateUserrequest.getUserName().equals(existingUser.getUserName())) {

            Optional<User> existingUserName = userRepository.findByUserName(updateUserrequest.getUserName());

            if (existingUserName.isPresent() && !existingUserName.get().getId().equals(existingUser.getId())) {
                throw new BiddingException("This username has already been taken by some other user");
            }
        }

        if (updateUserrequest.getEmail() != null && !updateUserrequest.getEmail().equals(existingUser.getEmail())) {

            Optional<User> existingUserEmail = userRepository.findByEmail(updateUserrequest.getEmail());

            if (existingUserEmail.isPresent() && !existingUserEmail.get().getId().equals(existingUser.getId())) {
                throw new BiddingException("This email has already been taken by some other user");
            }

        }

        userMapper.updateUserFromDto(updateUserrequest, existingUser);

        if (updateUserrequest.getPassword() != null && updateUserrequest.getPassword().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(updateUserrequest.getPassword()));
        }

        User updated = userRepository.save(existingUser);


        return userMapper.toUserResponse(updated);
    }

    @Override
    public void deleteUser(Long id){
        if (!userRepository.existsById(id)){
            throw new UserNotFoundException("Username with provided id not found");
        }

        userRepository.deleteById(id);
    }

    @Override
    public UserResponse assignRoletoUser(Long userId, RoleType roleType) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with provided id:" + userId));

        Role role = roleRepository.findByRoleType(roleType)
                        .orElseThrow(() -> new ResourceNotFoundException("Role not been found with provided roletype:" + roleType));

        user.getRoles().add(role);
        userRepository.save(user);

        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse removeRoleFromUser(Long userId, RoleType roleType) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with given id:" + userId));
        Role role = roleRepository.findByRoleType(roleType)
                .orElseThrow(() -> new ResourceNotFoundException("Role not been found with given roletype:" + roleType));

        if (!user.getRoles().contains(role)){
            throw  new IllegalArgumentException("User has not been assigned with any role:" + roleType);

        }
        user.getRoles().remove(role);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }
}
