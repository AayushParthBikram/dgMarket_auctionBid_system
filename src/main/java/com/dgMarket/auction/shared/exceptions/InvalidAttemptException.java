package com.dgMarket.auction.shared.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class InvalidAttemptException extends RuntimeException{

    public InvalidAttemptException(String message){
        super(message);
    }
}
