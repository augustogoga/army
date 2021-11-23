package com.solvd.army.model.machinery;

import com.solvd.army.model.armedForce.*;
import com.solvd.army.model.exceptions.SoldierNotFoundException;
import com.solvd.army.model.stock.Supply;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SupplyTruck extends Vehicle {
    private static final Logger LOGGER = LogManager.getLogger(SupplyTruck.class);
    private List<Supply> supplies;
    private boolean soldierOn;

    public SupplyTruck(String plate, String vehicleName) {
        super(plate, vehicleName, 5, 0);
        this.supplies = new LinkedList<>();

    }

    public boolean isSoldierOn() {
        return soldierOn;
    }

    public void setSoldierOn(boolean soldierOn) {
        this.soldierOn = soldierOn;
    }

    public void ride(Army army, int squadId, int soldierId) throws SoldierNotFoundException{
        Squad squad = army.getSquad(squadId);
        Soldier soldier = squad.getSoldier(soldierId);
        if (soldier.getAccessLevel() >= 10) {
            LOGGER.info("Soldier with the id " + soldier.getSoldierId() + " and the rank " + soldier.getRank()
                    + " is riding the Supply Truck " + this.getPlate());
            setSoldierOn(true);
        } else if (squad.getSoldier(soldierId) == null) {
            throw new SoldierNotFoundException("Soldier not found to ride this Supply Truck");
        }
        else {
            LOGGER.info("Soldier with the id " + soldier.getSoldierId() +
                    " doesn't meet the access level required to ride the Supply Truck " + this.getPlate());
        }
    }

    public void addSupply(Supply supply) {
        supplies.add(supply);
    }

    public List<Supply> getSupplies() {
        return supplies;
    }

    public void setSupplies(List<Supply> supplies) {
        this.supplies = supplies;
    }

    public void loadSupply(Supply supply) {
        supplies.add(supply);
    }

    public void showSupplyList() {
        for (Supply supply : supplies) {
            LOGGER.info(supply);
        }
    }

    @Override
    public String toString() {
        return "SupplyTruck{" +
                "supplies=" + supplies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplyTruck)) return false;
        SupplyTruck that = (SupplyTruck) o;
        return Objects.equals(supplies, that.supplies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplies);
    }
}
