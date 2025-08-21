package com.dgMarket.auction.shared.exceptions;

public class AddressNotFoundException extends ResourceNotFoundException {
    public AddressNotFoundException(String message) {
        super(message);
    }
}
