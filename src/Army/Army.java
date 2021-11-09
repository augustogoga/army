package Army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private String name;
    private int squadAmount;
    private List<Squad> squads;

    public Army(String name, int squadAmount) {
        this.name = name;
        this.squadAmount = squadAmount;
        this.squads = new ArrayList<Squad>();
    }

    public Army(String name, int squadAmount, ArrayList<Squad> squads){
        this.name = name;
        this.squadAmount = squadAmount;
        this.squads = squads;
    }

    public List<Squad> getSquads() {
        return squads;
    }

    public void addSquad(String squadName, int squadId){
        squads.add(new Squad(squadName, squadId));
    }

    public Squad getSquad(int squadId){
        for (Squad squadFound : squads) {
            if (squadId == squadFound.getSquadId()){
                return squadFound;
            }

        }
        return null;

    }

    @Override
    public String toString() {
        return "----ARMY----" + "\n" +
                "NAME= " + name + '\'' +
                ", SQUAD SIZE= " + squadAmount + '\'' +
                ", SQUADS= " + squads;
    }
}
