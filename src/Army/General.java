package Army;

public class General extends Soldier {
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
        if (getAmmo() == 30){
            readyToShoot = true;
        } else {
            readyToShoot = false;
        }
        return readyToShoot;
    }

    public void setReadyToShoot(boolean readyToShoot) {
        this.readyToShoot = readyToShoot;
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
