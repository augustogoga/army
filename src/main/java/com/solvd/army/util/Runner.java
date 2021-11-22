package com.solvd.army.util;

import com.solvd.army.model.armedForce.Army;
import com.solvd.army.model.armedForce.*;
import com.solvd.army.model.exceptions.*;
import com.solvd.army.model.generics.MyGenericClass;
import com.solvd.army.model.machinery.*;

import java.util.logging.Logger;

public class Runner {
    public static final Logger LOGGER = Logger.getLogger(Runner.class.getName());

    public static void main(String[] args) {
        Army army1 = new Army("Armada", 1);

        army1.addSquad("Squad1", 45);

        LOGGER.info(String.valueOf(army1));


        Colonel colonel1 = new Colonel("Colonel Sanders", 20);
        army1.getSquads().get(0).addSoldier(colonel1);

        for (int i = 0; i < 2; i++) {
            General general1 = new General("General", i + 10);
            army1.getSquads().get(0).addSoldier(general1);
        }

        for (int i = 0; i < 10; i++) {
            Private private1 = new Private("Private", i);
            army1.getSquads().get(0).addSoldier(private1);
        }


        try {
            LOGGER.info(String.valueOf(army1.getSquad(45)));
            LOGGER.info(String.valueOf(army1.getSquad(40)));
        } catch (SquadNotFoundException messageSquad) {
            LOGGER.info(String.valueOf(messageSquad));
        }

        try {
            LOGGER.info(String.valueOf(army1.getSquad(45).getSoldier(999)));
        } catch (SoldierNotFoundException | SquadNotFoundException message) {
            LOGGER.info(String.valueOf(message));
        }

        WarPlane warplane = new WarPlane("1234", "F-77");

        try {
            LOGGER.info(String.valueOf(army1.getVehicle("1234")));
            LOGGER.info(String.valueOf(army1.getVehicle("1235")));
        } catch (VehicleNotFoundException messageVehicle) {
            LOGGER.info(String.valueOf(messageVehicle));
        }
        try {
            colonel1.reload();
            colonel1.reload();
        } catch (SoldierFullAmmoException messageFullAmmo) {
            LOGGER.info(String.valueOf(messageFullAmmo));
        }

        MyGenericClass<Vehicle> soldierMyGenericClass = new MyGenericClass<>();
        soldierMyGenericClass.takeEntity(warplane);

        try {
            colonel1.shoot();
            colonel1.shoot();
        } catch (SoldierOutOfAmmoException messageOutOfAmmo) {
            LOGGER.info(String.valueOf(messageOutOfAmmo));
        }
        army1.getSquads().get(0).addVehicle(warplane);

        LOGGER.info(String.valueOf(army1));

        Army army2 = new Army("Armada2", 1);

        army2.addSquad("Squad1", 202);

        Colonel colonel2 = new Colonel("Colonel Brubank", 1);
        army2.getSquads().get(0).addSoldier(colonel2);

        for (int i = 0; i < 2; i++) {
            General general2 = new General("General", i);
            army2.getSquads().get(0).addSoldier(general2);
        }

        for (int i = 0; i < 10; i++) {
            Private private2 = new Private("Private", i);
            army2.getSquads().get(0).addSoldier(private2);
        }

        LOGGER.info(String.valueOf(army2));

        army1.fight(army1, army2);

        colonel1.cover();
    }

}
