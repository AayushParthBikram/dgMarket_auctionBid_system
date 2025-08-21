package com.dgMarket.auction.security.auth.login.repository;

import com.dgMarket.auction.security.auth.entity.ForgotPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ForgotPasswordTokenRepository extends JpaRepository<ForgotPassword, Long> {

    Optional<ForgotPassword> findByToken(String token);


    void deleteByUserId(Long userId);
}
