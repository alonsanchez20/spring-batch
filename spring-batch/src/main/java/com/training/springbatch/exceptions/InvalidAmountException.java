package com.training.springbatch.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class InvalidAmountException extends RuntimeException{

    public InvalidAmountException(String message){
        super(message);
    }

    public int getErrorCode(){
        return HttpStatus.BAD_REQUEST.value();
    }

}
