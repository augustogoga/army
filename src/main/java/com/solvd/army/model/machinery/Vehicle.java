package com.solvd.army.model.machinery;

import com.solvd.army.model.interfaces.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Objects;

public abstract class Vehicle implements IShoot, IReload {
    private static final Logger LOGGER = LogManager.getLogger(Vehicle.class.getName());
    private String plate;
    private String vehicleName;
    private boolean isMoving = false;
    private int ammo;

    private int powerLevel;

    public Vehicle(String plate, String vehicleName, int powerLevel, int ammo) {
        this.plate = plate;
        this.vehicleName = vehicleName;
        this.isMoving = isMoving();
        this.powerLevel = powerLevel;
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        if (this.ammo > 30) {
            this.ammo = 30;
        } else if (this.ammo < 0) {
            this.ammo = 0;
        } else {
            this.ammo = ammo;
        }
    }

    @Override
    public void shoot() {
        int i = 0;
        int ammo = getAmmo();
        while (i < getAmmo()) {
            ammo--;
            setAmmo(ammo);
        }
    }

    @Override
    public void reload() {
        ammo = getAmmo();
        if (ammo == 10) {
            LOGGER.info("This vehicle already has ammo.");
        } else {
            setAmmo(10);
        }
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
        return isMoving;
    }

    public void setMoving(boolean moving) {
        this.isMoving = moving;
    }

    @Override
    public String toString() {
        return "Vehicle: " +
                "plate='" + plate + '\'' +
                ", vehicleName='" + vehicleName + '\'' + ", powerLevel= " + powerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return isMoving == vehicle.isMoving && ammo == vehicle.ammo && powerLevel == vehicle.powerLevel && Objects.equals(plate, vehicle.plate) && Objects.equals(vehicleName, vehicle.vehicleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plate, vehicleName, isMoving, ammo, powerLevel);
    }
}
