package com.solvd.army.model.vehicle;

public class WarPlane extends Vehicle {
    private boolean isFlying;
    private boolean loaded;

    public WarPlane(String plate, String vehicleName) {
        super(plate, vehicleName, 40, 10);
        this.isFlying = isMoving();
    }


    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public void takeOff() {
        if (!isMoving()) {
            System.out.println("The plane " + getVehicleName() + " has taken off!");
            setMoving(true);
        } else {
            System.out.println("The plane " + getVehicleName() + " is already flying!");
        }

    }

    public void land() {
        if (isMoving()) {
            setMoving(false);
            System.out.println("The plane " + getVehicleName() + " has landed");
        } else {
            System.out.println("The plane " + getVehicleName() + " isn't flying.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "WarPlane{" +
                "isFlying=" + isFlying +
                ", loaded=" + loaded +
                '}';
    }
}
