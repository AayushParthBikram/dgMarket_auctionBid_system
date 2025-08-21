package com.dgMarket.auction.shared.config;

import com.dgMarket.auction.features.pages.users.entity.User;
import com.dgMarket.auction.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaAuditingConfig {

    @Bean
    public AuditorAware<User> auditorAware(){
        return new AuditorAwareImpl();
    }

}
