package com.frank.project.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomizedException extends RuntimeException {

    private String message;
    private HttpStatus status;
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    protected CustomizedException() {
    }

     
     public CustomizedException(String msg, HttpStatus status){
        
        this.message = msg;
        this.status = status;

    }

    @Override
    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public HttpStatus getStatus(){
        return this.status;
    }

    public void setStatus(HttpStatus st) {
        this.status = st;
    }
}