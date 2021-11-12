package Vehicle;

import Supply.Supply;

import java.util.ArrayList;
import java.util.List;

public class SupplyTruck extends Vehicle {
    private List<Supply> supplies;

    public SupplyTruck(String plate, String vehicleName) {
        super(plate, vehicleName, 5, 0);
        this.supplies = new ArrayList<>();

    }

    public void addSupply(Supply supply) {
        supplies.add(supply);
    }

    public void showSupplyList() {
        for (Supply supply : supplies) {
            System.out.println(supply);
        }
    }

}
