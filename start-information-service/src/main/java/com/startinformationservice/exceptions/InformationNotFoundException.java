package com.startinformationservice.exceptions;

public class InformationNotFoundException extends RuntimeException{

    public InformationNotFoundException(String message) {
        super(message);
    }

}