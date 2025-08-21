package com.dgMarket.auction.security.auth.entity;


import com.dgMarket.auction.features.pages.users.entity.User;
import com.dgMarket.auction.shared.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "forgot_password")
public class ForgotPassword extends BaseEntity {
    @Column(name = "unique_id")
    private String token;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "expiry_date", nullable = false)
    private LocalDateTime expiryDate;

    @Column(name = "password_changed")
    private boolean isChanged = false;


    @Column(name = "user_id", nullable = false)
    private Long userId;



    public boolean isValid(){
        return !this.isChanged && this.expiryDate.isAfter(LocalDateTime.now());
    }
}
