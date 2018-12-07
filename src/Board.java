public class Board {
    private final int size;
    private Player player;

    public Board(int size, Player player){
        this.size=size;
        this.player=player;
    }
    
    public Player getPlayer() {
    	return player;
    }
}
