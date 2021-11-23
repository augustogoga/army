package com.solvd.army.model.interfaces;
import com.solvd.army.model.armedForce.Soldier;


public interface ICommand {
    void retire(Soldier soldier);
    void train(Soldier soldier);
    void aim(Soldier soldier);

}
