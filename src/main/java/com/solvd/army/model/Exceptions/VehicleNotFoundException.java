package Exceptions;

public class VehicleNotFoundException extends Exception {
    public VehicleNotFoundException(String messageVehicle){
        super(messageVehicle);
    }
}
