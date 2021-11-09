package Army;

public abstract class Soldier {
    private String name;
    private int soldierId;
    private String rank;
    private int powerLevel;

    public Soldier() {

    }

    public Soldier(String name, int soldierId, String rank, int powerLevel) {
        this.name = name;
        this.soldierId = soldierId;
        this.rank = rank;
        this.powerLevel = powerLevel;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoldierId() {
        return soldierId;
    }

    public void setSoldierId(int soldierId) {
        this.soldierId = soldierId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public String toString() {
        return "Soldier" +
                "name='" + name + '\'' +
                ", soldierId=" + soldierId +
                ", rank='" + rank + '\'' + ", powerLevel= " + powerLevel +
                "\n";
    }
}
