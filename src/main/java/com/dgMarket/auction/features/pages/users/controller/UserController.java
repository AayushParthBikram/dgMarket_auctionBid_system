package com.dgMarket.auction.features.pages.users.controller;



import com.dgMarket.auction.shared.apiMapping.ApiResponse;
import com.dgMarket.auction.shared.apiMapping.dtos.RegisterUser;
import com.dgMarket.auction.shared.apiMapping.dtos.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody RegisterUser registerUser){


    }
}
