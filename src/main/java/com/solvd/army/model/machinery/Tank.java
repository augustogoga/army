package com.solvd.army.model.machinery;

import com.solvd.army.model.armedForce.Army;
import com.solvd.army.model.armedForce.Soldier;
import com.solvd.army.model.armedForce.Squad;
import com.solvd.army.model.exceptions.SoldierNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Tank extends Vehicle {
    private static final Logger LOGGER = LogManager.getLogger(Tank.class);
    private boolean loaded;
    private boolean IsSoldierOn = false;

    public boolean isSoldierOn() {
        return IsSoldierOn;
    }

    public void setSoldierOn(boolean soldierOn) {
        IsSoldierOn = soldierOn;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public Tank(String plate, String vehicleName) {
        super(plate, vehicleName, 50, 10);
    }

    @Override
    public String toString() {
        return super.toString() + "Tank{" +
                "loaded=" + loaded +
                '}';
    }

    public void ride(Army army, int squadId, int soldierId) throws SoldierNotFoundException{
        Squad squad = army.getSquad(squadId);
        Soldier soldier = squad.getSoldier(soldierId);
        if (soldier.getAccessLevel() >= 10) {
            LOGGER.info("Soldier with the id " + soldier.getSoldierId() + " and the rank " + soldier.getRank()
                    + " is riding the Tank " + this.getPlate());
            setSoldierOn(true);
        } else if (squad.getSoldier(soldierId) == null) {
            throw new SoldierNotFoundException("Soldier not found to ride this car");
        }
        else {
            LOGGER.info("Soldier with the id " + soldier.getSoldierId() +
                    " doesn't meet the access level required to ride the tank " + this.getPlate());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tank)) return false;
        Tank tank = (Tank) o;
        return loaded == tank.loaded;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loaded);
    }
}
