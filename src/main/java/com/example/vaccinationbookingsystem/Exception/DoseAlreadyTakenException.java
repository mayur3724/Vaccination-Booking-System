package com.example.vaccinationbookingsystem.Exception;

public class DoseAlreadyTakenException extends RuntimeException {
    public DoseAlreadyTakenException(String message){
        super(message);
    }
}
