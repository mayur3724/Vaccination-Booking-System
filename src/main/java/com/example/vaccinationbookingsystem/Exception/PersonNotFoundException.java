package com.example.vaccinationbookingsystem.Exception;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String message){
        super(message);
    }
}
