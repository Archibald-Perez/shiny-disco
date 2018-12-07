public class Domino {
    public int number;
    public String zone1;
    public String zone2;
    public int crown1;
    public int crown2;
    public boolean isInDeck = true;
    
    public Domino(){}

    public Domino(int number, String zone1, String zone2, int crown1, int crown2){
        this.number = number;
        this.zone1= zone1;
        this.zone2 = zone2;
        this.crown1= crown1;
        this.crown2 = crown2;
    }
    
    @Override
    public String toString() {
        return "Domino "+number+" {" +
                "zone1 = " + zone1 +
                ", zone2 = " + zone2 +
                ", crown1 = " + crown1 +
                ", crown2 = " + crown2 +
                '}';
    }
}

