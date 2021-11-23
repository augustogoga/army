package com.solvd.army.model.armedForce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Private extends Soldier {
    private static final Logger LOGGER = LogManager.getLogger(Private.class.getName());
    private static final int accessLevel = 5;
    private boolean readyToShoot;

    public Private(String name, int soldierId) {
        super(name, soldierId, "Private", 10, 30);
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public boolean isReadyToShoot() {
        return readyToShoot;
    }

    public void setReadyToShoot(boolean readyToShoot) {
        this.readyToShoot = readyToShoot;
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
    public String toString() {
        return super.toString() + "Private{" + '\'' +
                ", accessLevel=" + accessLevel +
                ", readyToShoot=" + readyToShoot +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Private)) return false;
        if (!super.equals(o)) return false;
        Private aPrivate = (Private) o;
        return accessLevel == aPrivate.accessLevel && readyToShoot == aPrivate.readyToShoot;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accessLevel, readyToShoot);
    }
}
