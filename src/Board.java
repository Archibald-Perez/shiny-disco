public class Board {
    private final int size;
    private Player player;
    private String[][] zones;
    private int[][] crowns;

    public Board(int size, Player player){
        this.size=size;
        this.player=player;
        zones = new String[size][size];
        crowns = new int[size][size];
        for(int i=0; i<size; i++) {
        	for(int j=0; j<size; j++) {
        		zones[i][j] = "vide";
        	}
        }
        zones[4][4] = "chateau";
    }
    
    public void setDomino(Domino domino, int posY, int posX, int posY2, int posX2) {
    	crowns[posY][posX] = domino.getCrown1();
    	crowns[posY2][posX2] = domino.getCrown2();
    	zones[posY][posX] = domino.getZone1();
    	zones[posY2][posX2] = domino.getZone2();
    }
    
    public Player getPlayer() {
    	return player;
    }
    public String[][] getZones() {
    	return zones;
    }
    public int[][] getCrowns() {
    	return crowns;
    }
    
    @Override
    public String toString() {
    	String res = "";
    	for(int i = 0; i<size; i++) {
    		for(int j = 0; j<size; j++) {
    			res+=zones[i][j]+" : "+crowns[i][j]+" ; ";
    		}
    		res+="\n";
    	}
    	return res;
    }
}
