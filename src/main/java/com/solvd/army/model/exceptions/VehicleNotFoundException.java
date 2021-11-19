package com.solvd.army.model.exceptions;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String messageVehicle){
        super(messageVehicle);
    }
}
