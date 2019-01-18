
public class AI {

	public AI() {}
	
	public Domino selectDomino(Player player) {
		Domino domino = new Domino(0,"","",0,0);
		for(int i=0; i<DominoManager.getSelectedDominosNumbers().size(); i++) {
			if(DominoManager.getSelectedDominosNumbers().get(i) != null) {
				domino = DominoManager.getSelectedDominos().get(i);
				PlayerManager.getNextSequence()[DominoManager.getSelectedDominosNumbers().indexOf(domino.getNumber())] = PlayerManager.getPlayers().indexOf(player);
				DominoManager.getSelectedDominosNumbers().set(i, null);
				break;
			}
		}
		System.out.println("L'IA a choisi le domino "+domino);
		return domino;
	}
	public void setDomino(Player player, Board board, Domino domino) {
		outer:
		for(int x = 0; x<9; x++) {
			for(int y = 0; y<9; y++) {
				for(int ori = 0; ori<4; ori++) {
					if(verifyDomino(board,domino,x,y,ori)) {
						break outer;
					}
				}
			}
		}
		player.placed = true;
	}
	public boolean verifyDomino(Board board, Domino domino, int posX, int posY, int orientation) {
    	int posY2 = posY;
		int posX2 = posX;
		switch(orientation) {
		case 0:
			posY2+=1;
			break;
		case 1:
			posX2-=1;
			break;
		case 2:
			posY2-=1;
			break;
		case 3:
			posX2+=1;
			break;
		}
		boolean res = false;
		for(int j=-8; j<9; j++) {
			if(!board.getZones()[Math.max(Math.min(posY+j,8),0)][Math.min(posX+5,8)].equals("vide")) {
				return false;
			} else if (!board.getZones()[Math.max(Math.min(posY+j,8),0)][Math.max(posX-5,0)].equals("vide")) {
				return false;
			} else if(!board.getZones()[Math.min(posY+5,8)][Math.max(Math.min(posX+j,8),0)].equals("vide")) {
				return false;
			} else if (!board.getZones()[Math.max(posY-5,0)][Math.max(Math.min(posX+j,8),0)].equals("vide")) {
				return false;
			} else if(!board.getZones()[Math.max(Math.min(posY2+j,8),0)][Math.min(posX2+5,8)].equals("vide")) {
				return false;
			} else if (!board.getZones()[Math.max(Math.min(posY2+j,8),0)][Math.max(posX2-5,0)].equals("vide")) {
				return false;
			} else if(!board.getZones()[Math.min(posY2+5,8)][Math.max(Math.min(posX2+j,8),0)].equals("vide")) {
				return false;
			} else if (!board.getZones()[Math.max(posY2-5,0)][Math.max(Math.min(posX2+j,8),0)].equals("vide")) {
				return false;
			}
		}
		if(posY2 >= 0 && posX2 >= 0 && posY2 <9 && posX2 <9) {
			if(board.getZones()[posY][posX].equals("vide") && board.getZones()[posY2][posX2].equals("vide")) {
				if(board.getZones()[Math.min(8,posY+1)][posX].equals(domino.getZone1()) || board.getZones()[Math.min(8,posY+1)][posX].equals("chateau")) {
					board.setDomino(domino, posY, posX, posY2, posX2);
					res = true;
				} else if(board.getZones()[Math.max(0,posY-1)][posX].equals(domino.getZone1()) || board.getZones()[Math.max(0,posY-1)][posX].equals("chateau")) {
					board.setDomino(domino, posY, posX, posY2, posX2);
					res = true;
				} else if(board.getZones()[posY][Math.min(8,posX+1)].equals(domino.getZone1()) || board.getZones()[posY][Math.min(8,posX+1)].equals("chateau")) {
					board.setDomino(domino, posY, posX, posY2, posX2);
					res = true;
				} else if(board.getZones()[posY][Math.max(0,posX-1)].equals(domino.getZone1()) || board.getZones()[posY][Math.max(0,posX-1)].equals("chateau")) {
					board.setDomino(domino, posY, posX, posY2, posX2);
					res = true;
				} else if(board.getZones()[Math.min(8,posY2+1)][posX2].equals(domino.getZone2()) || board.getZones()[Math.min(8,posY2+1)][posX2].equals("chateau")) {
					board.setDomino(domino, posY, posX, posY2, posX2);
					res = true;
				} else if(board.getZones()[Math.max(0,posY2-1)][posX2].equals(domino.getZone2()) || board.getZones()[Math.max(0,posY2-1)][posX2].equals("chateau")) {
					board.setDomino(domino, posY, posX, posY2, posX2);
					res = true;
				} else if(board.getZones()[posY2][Math.min(8,posX2+1)].equals(domino.getZone2()) || board.getZones()[posY2][Math.min(8,posX2+1)].equals("chateau")) {
					board.setDomino(domino, posY, posX, posY2, posX2);
					res = true;
				} else if(board.getZones()[posY2][Math.max(0,posX2-1)].equals(domino.getZone2()) || board.getZones()[posY2][Math.max(0,posX2-1)].equals("chateau")) {
					board.setDomino(domino, posY, posX, posY2, posX2);
					res = true;
				}
			}
		}
		return res;
    }
}
