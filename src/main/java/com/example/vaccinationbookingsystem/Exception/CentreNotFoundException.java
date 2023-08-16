package com.example.vaccinationbookingsystem.Exception;

public class CentreNotFoundException extends RuntimeException {
    public CentreNotFoundException (String message){
        super(message);
  }
}
