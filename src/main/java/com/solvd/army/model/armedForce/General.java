package com.solvd.army.model.armedForce;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class General extends Soldier {
    private static final Logger LOGGER = LogManager.getLogger(General.class.getName());
    private static final int accessLevel = 10;
    private boolean readyToShoot;

    public General(String name, int soldierId) {
        super(name, soldierId, "General", 25, 30);
    }


    public int getAccessLevel() {
        return accessLevel;
    }


    public boolean isReadyToShoot() {
        readyToShoot = getAmmo() == 30;
        return readyToShoot;
    }

    public void setReadyToShoot(boolean readyToShoot) {
        this.readyToShoot = readyToShoot;
    }

    @Override
    public String toString() {
        return super.toString() + "Private{" + '\'' +
                ", accessLevel=" + accessLevel +
                ", readyToShoot=" + readyToShoot +
                '}';
    }

    @Override
    public void aim(Soldier soldier) {
        if (isReadyToShoot()) {
            LOGGER.info(soldier.getName() + " is prepared and ready for shooting.");
        } else {
            LOGGER.info(soldier.getName() + " must have a charged weapon to be ready to shoot.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof General)) return false;
        if (!super.equals(o)) return false;
        General general = (General) o;
        return accessLevel == general.accessLevel && readyToShoot == general.readyToShoot;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accessLevel, readyToShoot);
    }
}
