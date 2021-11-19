package com.solvd.army.model.exceptions;

public class SoldierNotFoundException extends RuntimeException{
    public SoldierNotFoundException(String message){
        super(message);
    }
}
