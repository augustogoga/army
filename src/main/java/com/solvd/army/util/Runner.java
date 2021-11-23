package com.solvd.army.util;

import com.solvd.army.model.armedForce.Army;
import com.solvd.army.model.armedForce.*;
import com.solvd.army.model.exceptions.*;
import com.solvd.army.model.generics.*;
import com.solvd.army.model.machinery.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class.getName());

    public static void main(String[] args) {
        Army army1 = new Army("Armada", 1);

        army1.addSquad("Squad1", 45);


        Colonel colonel1 = new Colonel("Colonel Sanders", 20);
        army1.getSquads().get(0).addSoldier(colonel1);
        army1.getSquads().get(0).getSoldier(20).addWeapon();

        for (int i = 0; i < 2; i++) {
            General general1 = new General("General", i + 10);
            army1.getSquads().get(0).addSoldier(general1);
            army1.getSquads().get(0).getSoldier(i + 10).addWeapon();
        }

        for (int i = 0; i < 10; i++) {
            Private private1 = new Private("Private", i);
            army1.getSquads().get(0).addSoldier(private1);
            army1.getSquads().get(0).getSoldier(i).addWeapon();
        }


        try {
            LOGGER.info(army1.getSquad(45));
            LOGGER.info(army1.getSquad(40));
        } catch (SquadNotFoundException messageSquad) {
            LOGGER.info(messageSquad);
        }

        try {
            LOGGER.info(String.valueOf(army1.getSquad(45).getSoldier(999)));
        } catch (SoldierNotFoundException | SquadNotFoundException message) {
            LOGGER.info(message);
        }

        WarPlane warplane = new WarPlane("1234", "F-77");

        try {
            LOGGER.info(army1.getVehicle("1234"));
            LOGGER.info(army1.getVehicle("1235"));
        } catch (VehicleNotFoundException messageVehicle) {
            LOGGER.info(messageVehicle);
        }
        try {
            colonel1.reload();
            colonel1.reload();
        } catch (SoldierFullAmmoException messageFullAmmo) {
            LOGGER.info(messageFullAmmo);
        }

        MyGenericClass<Vehicle> soldierMyGenericClass = new MyGenericClass<>();
        soldierMyGenericClass.takeEntity(warplane);

        ShowEntityTypeGeneric<Soldier> genericSoldier = new ShowEntityTypeGeneric<>();
        genericSoldier.showEntityType(colonel1);

        ElementGeneric<Integer> integerElementGeneric = new ElementGeneric<>();
        integerElementGeneric.setData(200);
        integerElementGeneric.ShowElement();

        try {
            colonel1.shoot();
            colonel1.shoot();
        } catch (SoldierOutOfAmmoException messageOutOfAmmo) {
            LOGGER.info(messageOutOfAmmo);
        }
        army1.getSquads().get(0).addVehicle(warplane);

        LOGGER.info(army1);

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

        LOGGER.info(army2);
        army1.fight(army1, army2);
        army1.fight(army1, army1);

        colonel1.cover();
        Tank tank = new Tank("0001", "Light Tank");
        try {
            tank.ride(army1, 45, 20);
            tank.ride(army1, 45, 999);
        } catch (SoldierNotFoundException message){
            LOGGER.info(message);
        }
        colonel1.retire(colonel1);
    }

}
