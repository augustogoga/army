package Army;

import Exceptions.SquadNotFoundException;
import Exceptions.VehicleNotFoundException;
import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Army {
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

    @Override
    public String toString() {
        return "----ARMY----" + "\n" +
                "NAME= " + name + '\'' +
                ", SQUAD SIZE= " + squadAmount + '\'' +
                ", SQUADS= " + squads;
    }

    public void fight(Army army1, Army army2) {
        int power1 = army1.getSquads().get(0).getSquadPower();
        int power2 = army2.getSquads().get(0).getSquadPower();
        String message = "The army " + army2.getName() + " has won the fight!";

        if (power1 >= power2) {
            message = "The army " + army1.getName() + " has won the fight!";
        }
        System.out.println(message);
    }

}
