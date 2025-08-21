package com.dgMarket.auction.features.pages.users.specifications;

import com.dgMarket.auction.features.pages.users.entity.User;
import com.dgMarket.auction.features.pages.users.enums.UserType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class UserSpecification {




    public static Specification<User> hasUserNameLike(String userName){

        return ((root, query, criteriaBuilder) -> {

            if (!StringUtils.hasText(userName)){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("username")), "%" + userName.toLowerCase() + "%");
        });
    }

    public static Specification<User> hasEmailLike(String email){
        return ((root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(email)){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + email.toLowerCase() + "%");
        });
    }

    public static Specification<User> hasUserTypeLike(UserType userType){
        return ((root, query, criteriaBuilder) -> {
            if (userType == null){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("userType"), userType);
        });
    }
}
