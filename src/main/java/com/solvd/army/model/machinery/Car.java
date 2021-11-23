package com.solvd.army.model.machinery;

import com.solvd.army.model.armedForce.Army;
import com.solvd.army.model.armedForce.Soldier;
import com.solvd.army.model.armedForce.Squad;
import com.solvd.army.model.exceptions.SoldierNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car extends Vehicle {
    private static final Logger LOGGER = LogManager.getLogger(Car.class);
    private List<Soldier> soldiers;
    private boolean isWeaponized;
    private boolean soldierOn;

    public Car(String plate, String vehicleName) {
        super(plate, vehicleName, 10, 0);
        this.soldiers = new ArrayList<>();
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void aim() {
        if (isWeaponized()) {
            LOGGER.info(getVehicleName() + " is prepared and ready for shooting.");
        } else {
            LOGGER.info(getVehicleName() + " this vehicle is not weaponized");
        }
    }

    public boolean isSoldierOn() {
        return soldierOn;
    }

    public void setSoldierOn(boolean soldierOn) {
        this.soldierOn = soldierOn;
    }

    public void setSoldiers(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public boolean isWeaponized() {
        return isWeaponized;
    }

    public void setWeaponized(boolean weaponized) {
        isWeaponized = weaponized;
    }


    public void ride(Army army, int squadId, int soldierId) throws SoldierNotFoundException {
        Squad squad = army.getSquad(squadId);
        Soldier soldier = squad.getSoldier(soldierId);
        if (soldier.getAccessLevel() >= 10) {
            LOGGER.info("Soldier with the id " + soldier.getSoldierId() + " and the rank " + soldier.getRank()
                    + " is riding the Car " + this.getPlate());
            setSoldierOn(true);
        } else if (squad.getSoldier(soldierId) == null) {
            throw new SoldierNotFoundException("Soldier not found to ride this car");
        } else {
            LOGGER.info("Soldier with the id " + soldier.getSoldierId() +
                    " doesn't meet the access level required to ride the Car " + this.getPlate());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return isWeaponized == car.isWeaponized && Objects.equals(soldiers, car.soldiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soldiers, isWeaponized);
    }
}
