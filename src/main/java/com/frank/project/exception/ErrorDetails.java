package com.frank.project.exception;

import org.springframework.http.HttpStatus;

public class ErrorDetails{
    private String message;
    private HttpStatus status;
    
    public ErrorDetails(String msg, HttpStatus status){
        super();

        this.message = msg;
        this.status = status;
    }
    
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