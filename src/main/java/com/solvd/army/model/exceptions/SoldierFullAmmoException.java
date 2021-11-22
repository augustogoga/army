package com.solvd.army.model.exceptions;

public class SoldierFullAmmoException extends RuntimeException{
    public SoldierFullAmmoException(String messageFullAmmo){
        super(messageFullAmmo);
    }
}
