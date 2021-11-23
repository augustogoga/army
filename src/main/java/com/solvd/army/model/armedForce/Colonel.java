package com.solvd.army.model.armedForce;

import com.solvd.army.model.stock.Weapon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Colonel extends Soldier {
    private static final Logger LOGGER = LogManager.getLogger(Colonel.class);
    private static final int accessLevel = 20;
    private boolean readyToShoot;

    public Colonel(String name, int soldierId) {
        super(name, soldierId, "Colonel", 50, 30);
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

}
