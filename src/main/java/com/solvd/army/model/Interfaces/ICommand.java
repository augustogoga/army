package Interfaces;

import Army.Soldier;

public interface ICommand {
    public void retire(Soldier soldier);
    public void train(Soldier soldier);
    public void aim(Soldier soldier);

}
