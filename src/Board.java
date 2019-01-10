import java.util.ArrayList;

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
        		crowns[i][j]= 0;
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

    public int score(){
        ArrayList<ArrayList<Integer>> zoneScore = getZoneCrown(this.zones, this.crowns);
        int n =0;
        for (int i = 0; i<zoneScore.size(); i++){
            ArrayList<Integer> score = zoneScore.get(i);
            n = n + (score.get(0)* score.get(1));
        }
        return n;
    }

    public ArrayList<ArrayList<Integer>> getZoneCrown(String[][] zones,int[][] crowns ) {
        int[][] tabZone = new int[this.size][this.size];
        ArrayList<ArrayList<Integer>> score = new ArrayList<ArrayList<Integer>>();
        int max = 1;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                tabZone[i][j] = 0;
            }
        }
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                try {
                    if (zones[i][j].equals(zones[i - 1][j])) {
                        tabZone[i][j] = tabZone[i - 1][j];
                    }
                } catch (Exception e) { continue;
                }
                try {
                    if (zones[i][j].equals(zones[i][j - 1])) {
                        tabZone[i][j] = tabZone[i][j - 1];
                    }
                } catch (Exception e) { continue;
                }
                if (tabZone[i][j] == 0) {
                    tabZone[i][j] = max;
                    max = max + 1;

                }
            }
        }
        for (int k = 1; k<max;k++){
            int nbZone =0;
            int nbCrown = 0;
            ArrayList<Integer> nouvelleZone = new ArrayList<Integer>();
            for (int i = 0; i<this.size; i++){
                for (int j = 0; j<this.size; j++){
                    if (tabZone[i][j]== k){
                        nbZone=nbZone+1;
                        nbCrown =nbCrown + crowns[i][j];
                    }

                }
            }
            nouvelleZone.add(nbZone);
            nouvelleZone.add(nbCrown);
            score.add(nouvelleZone);
        }
        return score;
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
