package com.solvd.army.model.stock;

public class Weapon {
    private String name;
    private int powerLevel;
    private int ammo;

    public Weapon(String name) {
        this.name = name;
        setAmmo(30);
        setPowerLevel(5);
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", ammo=" + ammo +
                '}';
    }
}
