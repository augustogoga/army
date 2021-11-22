package com.solvd.army.model.exceptions;

public class SoldierOutOfAmmoException extends RuntimeException{
    public SoldierOutOfAmmoException(String messageOutOfAmmo){
        super(messageOutOfAmmo);
    }
}
