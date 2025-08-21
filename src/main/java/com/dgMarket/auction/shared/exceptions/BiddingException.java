package com.dgMarket.auction.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BiddingException extends  RuntimeException{

    public BiddingException(String message){
        super(message);
    }
}
