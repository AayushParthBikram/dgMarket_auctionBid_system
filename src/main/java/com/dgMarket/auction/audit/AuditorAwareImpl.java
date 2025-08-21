package com.dgMarket.auction.audit;

import com.dgMarket.auction.features.pages.users.entity.User;
import lombok.NonNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<User> {


    @Override
    @NonNull
    public Optional<User> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();

            User currentUser = new User();
            currentUser.setUserName(username);

            return Optional.of(currentUser);
        } else if (principal instanceof String username) {

            User currentUser = new User();
            currentUser.setUserName(username);
            return Optional.of(currentUser);

        }

        return Optional.empty();
    }
}
