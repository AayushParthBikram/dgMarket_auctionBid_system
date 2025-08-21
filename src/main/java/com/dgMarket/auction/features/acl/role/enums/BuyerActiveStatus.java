package com.dgMarket.auction.features.acl.role.enums;

import lombok.Getter;

@Getter
public enum BuyerActiveStatus {
    ALL(0), ACTIVE(1), BLOCKED(2), INACTIVE(3) /*, DELETED(3)*/;

    private final int value;
    BuyerActiveStatus(int value) {
        this.value = value;
    }


}
