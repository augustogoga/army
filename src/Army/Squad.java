package Army;

import Vehicle.Vehicle;

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

    public void addSoldier(Soldier soldier){
        soldiers.add(soldier);
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }


    public int getSquadId() {
        return squadId;
    }
    private int getSquadPower(){
        int soldierPower = 0;
        int vehiclesPower = 0;
        for (Soldier soldier : this.soldiers) {
            soldierPower += soldier.getPowerLevel();
        }

        for (Vehicle vehicle: this.vehicles) {
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
