import Army.Army;
import Army.General;
import Army.Colonel;
import Army.Private;
import Exceptions.SquadNotFoundException;
import Vehicle.WarPlane;

public class Runner {
    public static void main(String[] args) {
        Army army1 = new Army("Armada", 1);

        army1.addSquad("Squad1", 45);

        System.out.println(army1);


        Colonel colonel1 = new Colonel("Colonel Sanders", 1);
        army1.getSquads().get(0).addSoldier(colonel1);

        for (int i = 0; i < 2; i++){
            General general1 = new General("General", i);
            army1.getSquads().get(0).addSoldier(general1);
        }

        for (int i = 0; i < 10; i++){
            Private private1 = new Private("Private", i);
            army1.getSquads().get(0).addSoldier(private1);
        }


        try {
            System.out.println(army1.getSquad(45));
            System.out.println(army1.getSquad(40));
        } catch (SquadNotFoundException e) {
            System.out.println(e);
        }

        WarPlane warplane = new WarPlane("1234", "F-77");
        army1.getSquads().get(0).addVehicle(warplane);
//
        System.out.println(army1);

        Army army2 = new Army("Armada2", 1);

        army2.addSquad("Squad1", 202);

        Colonel colonel2 = new Colonel("Colonel Brubank", 1);
        army2.getSquads().get(0).addSoldier(colonel2);

        for (int i = 0; i < 2; i++){
            General general2 = new General("General", i);
            army2.getSquads().get(0).addSoldier(general2);
        }

        for (int i = 0; i < 10; i++){
            Private private2 = new Private("Private", i);
            army2.getSquads().get(0).addSoldier(private2);
        }

        System.out.println(army2);

        army1.fight(army1, army2);

        colonel1.cover();



//        warplane.takeOff();
//        warplane.takeOff();
//        warplane.land();
//        warplane.land();

//        SupplyTruck supplytruck = new SupplyTruck("1111", "Supply Truck");
//        supplytruck.addSupply(new Drink("Cola", 444, true));
//        supplytruck.addSupply(new Food("Bread", 1234, false));
//        supplytruck.addSupply(new Food("Yogurt", 1221, false));
//        supplytruck.addSupply(new Ammunition("Ammo", 1234));
//        supplytruck.showSupplyList();

    }

}
