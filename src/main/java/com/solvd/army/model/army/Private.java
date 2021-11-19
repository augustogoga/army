package com.solvd.army.model.army;

public class Private extends Soldier {
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
            System.out.println(soldier.getName() + " is prepared and ready for shooting.");
        } else {
            System.out.println(soldier.getName() + " must have a charged weapon to be ready to shoot.");
        }


    }
}
