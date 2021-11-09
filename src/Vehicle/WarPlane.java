package Vehicle;

public class WarPlane extends Vehicle {

    public WarPlane(String plate, String vehicleName) {
        super(plate, vehicleName, 40);
    }


    public void takeOff(){
        if (!isMoving()){
            System.out.println("The plane " + getVehicleName() + " has taken off!");
            setMoving(true);
        } else {
            System.out.println("The plane " + getVehicleName() + " is already flying!");
        }

    }

    public void land(){
        if (isMoving()){
            setMoving(false);
            System.out.println("The plane " + getVehicleName() + " has landed");
        } else {
            System.out.println("The plane " + getVehicleName() + " isn't flying.");
        }
    }

}
