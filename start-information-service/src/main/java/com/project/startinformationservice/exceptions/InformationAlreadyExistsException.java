package com.project.startinformationservice.exceptions;

public class InformationAlreadyExistsException extends RuntimeException{
    public InformationAlreadyExistsException(String message) {
        super(message);
    }
}
