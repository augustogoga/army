package com.solvd.army.model.armedForce;

import com.solvd.army.model.machinery.Vehicle;
import com.solvd.army.model.exceptions.SquadNotFoundException;
import com.solvd.army.model.exceptions.VehicleNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Army {
    private static final Logger LOGGER = LogManager.getLogger(Army.class);
    private String name;
    private int squadAmount;
    private List<Squad> squads;

    public Army(String name, int squadAmount) {
        this.name = name;
        this.squadAmount = squadAmount;
        this.squads = new ArrayList<>();
    }


    public Army(String name, int squadAmount, ArrayList<Squad> squads) {
        this.name = name;
        this.squadAmount = squadAmount;
        this.squads = squads;
    }

    public List<Squad> getSquads() {
        return squads;
    }

    public void addSquad(String squadName, int squadId) {
        squads.add(new Squad(squadName, squadId));
    }

    public Squad getSquad(int squadId) throws SquadNotFoundException {
        int i = 0;
        Squad squadFound = null;
        while (i < squads.size()) {
            if (squads.get(i).getSquadId() == squadId) {
                squadFound = squads.get(i);
                return squadFound;
            }
            i++;
        }

        throw new SquadNotFoundException("No squad found with that ID.");
    }

    public Vehicle getVehicle(String plate) throws VehicleNotFoundException {
        int i = 0;
        Vehicle vehicleFound = null;
        while (i < squads.get(i).getVehicles(i).size()) {
            if (squads.get(i).getVehicles(i).get(i).getPlate().equals(plate)) {
                vehicleFound = squads.get(i).getVehicles(i).get(i);
                return vehicleFound;
            }
            i++;
        }
        throw new VehicleNotFoundException("No vehicle found with that plate.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSquadAmount() {
        return squadAmount;
    }

    public void setSquadAmount(int squadAmount) {
        this.squadAmount = squadAmount;
    }

    public void setSquads(List<Squad> squads) {
        this.squads = squads;
    }

    @Override
    public String toString() {
        return "----ARMY----" + "\n" +
                "NAME= " + name + '\'' +
                ", SQUAD SIZE= " + squadAmount + '\'' +
                ", SQUADS= " + squads;
    }

    public void fight(Army army1, Army army2) {
        if (army1.equals(army2)) {
            LOGGER.info("You can't make two equal armies fight");
        } else {
            int power1 = army1.getSquads().get(0).getSquadPower();
            int power2 = army2.getSquads().get(0).getSquadPower();
            String message = "The army " + army2.getName() + " has won the fight!";

            if (power1 >= power2) {
                message = "The army " + army1.getName() + " has won the fight!";
            }
            LOGGER.info(message);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return squadAmount == army.squadAmount && Objects.equals(name, army.name) && Objects.equals(squads, army.squads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, squadAmount, squads);
    }
}
