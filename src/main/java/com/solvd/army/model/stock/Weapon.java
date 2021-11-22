package com.solvd.army.model.stock;

public class Weapon {
    private String name;
    private final int powerLevel = 5;
    private final int ammo = 30;

    public Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmmo() {
        return ammo;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", ammo=" + ammo +
                '}';
    }
}
