package com.solvd.army.model.machinery;

public class Tank extends Vehicle {
    private boolean loaded;

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
}
