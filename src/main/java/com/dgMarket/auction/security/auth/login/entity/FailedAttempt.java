package com.dgMarket.auction.security.auth.login.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "failed_attempt")
public class FailedAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_locked", nullable = false)
    private boolean accountLocked;

    @Column(name = "attempted_at")
    private LocalDateTime attemptedAt;

    @Column(name = "attempts_failed", nullable = false)
    private Integer attemptsFail;

    @Column(name = "username", length = 255, nullable = false)
    private String userName;

}
