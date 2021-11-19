package com.solvd.army.model.interfaces;

import com.solvd.army.model.army.Soldier;

public interface ICommand {
    public void retire(Soldier soldier);
    public void train(Soldier soldier);
    public void aim(Soldier soldier);

}
