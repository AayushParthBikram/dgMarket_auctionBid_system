package com.dgMarket.auction.shared;

import com.dgMarket.auction.features.pages.users.entity.User;
import com.dgMarket.auction.audit.AuditorAwareImpl;
import com.dgMarket.auction.shared.util.SpringApplicationContext;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdAt;


    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @ManyToOne
    @JoinColumn(name = "updated_by")
    private User updatedBy;
    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;


    @PrePersist
    protected void onCreate(){
        if (createdAt == null){
            createdAt = LocalDateTime.now();
            createdBy = getCurrentUser();

        }
    }

    @PreUpdate
    protected void  onUpdate(){
       updatedAt = LocalDateTime.now();
       updatedBy = getCurrentUser();
    }

    protected User getCurrentUser(){
        AuditorAwareImpl auditorAware = SpringApplicationContext.getBean(AuditorAwareImpl.class);
        return auditorAware.getCurrentAuditor().orElse(null);
    }


}
