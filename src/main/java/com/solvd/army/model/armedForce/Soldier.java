package com.solvd.army.model.armedForce;

import com.solvd.army.model.exceptions.SoldierFullAmmoException;
import com.solvd.army.model.exceptions.SoldierOutOfAmmoException;
import com.solvd.army.model.interfaces.*;
import java.util.Objects;
import java.util.logging.Logger;

public abstract class Soldier implements IShoot, IReload, IGetToCover, ICommand, IAdvance {
    public static final Logger LOGGER = Logger.getLogger(Soldier.class.getName());
    private String name;
    private int soldierId;
    private String rank;
    private int powerLevel;
    private int ammo;

    public Soldier() {

    }

    public Soldier(String name, int soldierId, String rank, int powerLevel, int ammo) {
        this.name = name;
        this.soldierId = soldierId;
        this.rank = rank;
        this.powerLevel = powerLevel;
        this.ammo = ammo;

    }

    @Override
    public void retire(Soldier soldier) {
        LOGGER.info(soldier.getName() + " retires.");
    }

    @Override
    public void train(Soldier soldier) {
        int updatedPL = soldier.getPowerLevel();
        soldier.setPowerLevel(updatedPL + 10);
    }

    @Override
    public void advance() {
        LOGGER.info(getName() + " advances to the next position.");
    }

    @Override
    public void cover() {
        LOGGER.info("The soldier " + getName() + ", with the ID " + soldierId + " is getting to cover.");
    }

    public void shoot() throws SoldierOutOfAmmoException {
        int i = 0;
        int ammo = getAmmo();
        while (i < getAmmo()) {
            ammo--;
            setAmmo(ammo);
        }
        throw new SoldierOutOfAmmoException("You can't shoot if you're out of ammo");
    }

    public void reload() throws SoldierFullAmmoException {
        ammo = getAmmo();
        if (ammo == 30) {
           throw new SoldierFullAmmoException("You can't reload when you're full on ammunition");
        } else {
            setAmmo(30);
        }
    }


    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        if (this.ammo > 30) {
            this.ammo = 30;
        } else if (this.ammo < 0) {
            this.ammo = 0;
        } else {
            this.ammo = ammo;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoldierId() {
        return soldierId;
    }

    public void setSoldierId(int soldierId) {
        this.soldierId = soldierId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public String toString() {
        return "Soldier" +
                "name='" + name + '\'' +
                ", soldierId=" + soldierId +
                ", rank='" + rank + '\'' + ", powerLevel= " + powerLevel +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soldier soldier = (Soldier) o;
        return soldierId == soldier.soldierId && powerLevel == soldier.powerLevel && ammo == soldier.ammo && Objects.equals(name, soldier.name) && Objects.equals(rank, soldier.rank);
    }

    @Override
    public int hashCode() {
        return soldierId;
    }
}
