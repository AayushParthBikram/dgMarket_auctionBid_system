package com.dgMarket.auction.shared.apiMapping.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordRequest {

    @NotBlank(message = "Email field cannot be put as Empty")
    @Email(message = "There should be a valid Email format")
    private String email;

    @NotNull(message = "Username is required to validate")
    private String userName;
}
