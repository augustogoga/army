package com.solvd.army.model.machinery;

import com.solvd.army.model.stock.Supply;

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
            LOGGER.info(String.valueOf(supply));
        }
    }

    @Override
    public String toString() {
        return "SupplyTruck{" +
                "supplies=" + supplies +
                '}';
    }
}
