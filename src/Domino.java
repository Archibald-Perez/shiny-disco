public class Domino {
    private int number;
    private String zone1;
    private String zone2;
    private int crown1;
    private int crown2;
    public boolean isInDeck = true;
    
    public Domino(){}

    public Domino(int number, String zone1, String zone2, int crown1, int crown2){
        this.number = number;
        this.zone1= zone1;
        this.zone2 = zone2;
        this.crown1= crown1;
        this.crown2 = crown2;
    }
    
    public int getNumber() {
    	return number;
    }
    public String getZone1() {
    	return zone1;
    }
    public String getZone2() {
    	return zone2;
    }
    public int getCrown1() {
    	return crown1;
    }
    public int getCrown2() {
    	return crown2;
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

