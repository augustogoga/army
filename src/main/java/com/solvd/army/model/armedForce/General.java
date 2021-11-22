package com.solvd.army.model.armedForce;

import java.util.logging.Logger;

public class General extends Soldier {
    public static final Logger LOGGER = Logger.getLogger(General.class.getName());
    private String weapon;
    private int accessLevel;
    private boolean readyToShoot;

    public General(String name, int soldierId) {
        super(name, soldierId, "General", 25, 30);
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
        readyToShoot = getAmmo() == 30;
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
        if (isReadyToShoot()) {
            LOGGER.info(soldier.getName() + " is prepared and ready for shooting.");
        } else {
            LOGGER.info(soldier.getName() + " must have a charged weapon to be ready to shoot.");
        }
    }


}
