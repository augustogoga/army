package com.solvd.army.model.armedForce;

import java.util.logging.Logger;

public class Private extends Soldier {
    public static final Logger LOGGER = Logger.getLogger(Private.class.getName());
    private String weapon;
    private int accessLevel;
    private boolean readyToShoot;

    public Private(String name, int soldierId) {
        super(name, soldierId, "Private", 10, 30);
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public boolean isReadyToShoot() {
        return readyToShoot;
    }

    public void setReadyToShoot(boolean readyToShoot) {
        this.readyToShoot = readyToShoot;
    }

    @Override
    public String toString() {
        return super.toString() + "Private{" +
                "weapon='" + weapon + '\'' +
                ", accessLevel=" + accessLevel +
                ", readyToShoot=" + readyToShoot +
                '}';
    }

    @Override
    public void aim(Soldier soldier) {
        if (isReadyToShoot()){
            LOGGER.info(soldier.getName() + " is prepared and ready for shooting.");
        } else {
            LOGGER.info(soldier.getName() + " must have a charged weapon to be ready to shoot.");
        }


    }
}
