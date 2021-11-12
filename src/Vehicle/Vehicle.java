package Vehicle;

public abstract class Vehicle {
    private String plate;
    private String vehicleName;
    private boolean moving = false;
    private int ammo;

    private int powerLevel;

    public Vehicle(String plate, String vehicleName, int powerLevel, int ammo){
        this.plate = plate;
        this.vehicleName = vehicleName;
        this.moving = isMoving();
        this.powerLevel = powerLevel;
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    @Override
    public String toString() {
        return "Vehicle: "  +
                "plate='" + plate + '\'' +
                ", vehicleName='" + vehicleName + '\'' + ", powerLevel= " + powerLevel;
    }
}
