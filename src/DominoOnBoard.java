public class DominoOnBoard extends Domino{
    public int posx;
    public int posy;
    public int orientation;
    	// 0 siginfie que la zone 2 est en postion x+1, y
    	// 1 siginfie que la zone 2 est en postion x, y-1
    	// 2 siginfie que la zone 2 est en postion x-1, y
		// 3 siginfie que la zone 2 est en postion x, y+1
    public Board board;

        public DominoOnBoard(int number, String zone1, String zone2, int crown1, int crown2, Board board, int posx, int posy, int orientation){
            this.number = number;
            this.zone1= zone1;
            this.zone2 = zone2;
            this.crown1= crown1;
            this.crown2 = crown2;
            this.board=board;
            this.posx=posx;
            this.posy= posy;
            this.orientation=orientation;

        }
}
