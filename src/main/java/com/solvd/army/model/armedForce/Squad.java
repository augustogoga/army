package com.solvd.army.model.armedForce;

import com.solvd.army.model.machinery.Vehicle;
import com.solvd.army.model.exceptions.SoldierNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String squadName;
    private int squadId;
    private List<Soldier> soldiers;
    private List<Vehicle> vehicles;

    public Squad(String squadName, int squadId) {
        this.squadName = squadName;
        this.squadId = squadId;
        this.soldiers = new ArrayList<Soldier>();
        this.vehicles = new ArrayList<Vehicle>();
    }

    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Soldier> getSoldiers() {
        return (List<Soldier>) soldiers;
    }

    public void setSoldiers(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public List<Vehicle> getVehicles(int i) {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getSquadId() {
        return squadId;
    }

    public Soldier getSoldier(int soldierId) throws SoldierNotFoundException {
        int i = 0;
        Soldier soldierFound = null;
        while (i < soldiers.size()) {
            if (soldiers.get(i).getSoldierId() == soldierId) {
                soldierFound = soldiers.get(i);
                return soldierFound;
            }
            i++;
        }
        throw new SoldierNotFoundException("No soldier found with that ID.");
    }


    public int getSquadPower() {
        int soldierPower = 0;
        int vehiclesPower = 0;
        for (Soldier soldier : this.soldiers) {
            soldierPower += soldier.getPowerLevel();
        }

        for (Vehicle vehicle : this.vehicles) {
            vehiclesPower += vehicle.getPowerLevel();
        }

        return vehiclesPower + soldierPower;
    }


    @Override
    public String toString() {
        return "Squad" +
                "\n" + "----SQUAD----" + "\n" + "NAME='" + squadName + '\'' + "\n" +
                "ID=" + squadId + "\n" + "----SOLDIERS----" + "\n" +
                soldiers + "\n" + "----SOLDIERS END----" + "\n" +
                "----VEHICLES----" + "\n" + vehicles + "\n" + "----TOTAL POWER LEVEL----" + "\n" + getSquadPower() + "\n";
    }
}
