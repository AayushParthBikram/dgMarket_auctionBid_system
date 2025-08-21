package com.dgMarket.auction.shared.exceptions;

public class AuctionTimeExpiredException extends BiddingException{
    public AuctionTimeExpiredException(String message) {
        super(message);
    }
}
