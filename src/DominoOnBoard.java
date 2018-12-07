public class DominoOnBoard extends Domino{
    public int posx;
    public int posy;
    public int orientation;
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
