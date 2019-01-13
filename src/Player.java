import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Player {
    private String name;
    private Boolean isAI;
    private Color color;
    private AI ai = null;
    public boolean placed = false;


    public Player(String name, Boolean isAI, Color color){
        this.name = name;
        this.isAI=isAI;
        this.color= color;
        if(isAI) {
        	this.ai = new AI();
        }

    }
    
    public Domino selectDomino() {
    	if(isAI) {
    		return ai.selectDomino(this);
    	} else {
    		if (Main.GUI) {
    			while(true) {
    	    		try {
    	    			int num = Integer.parseInt( JOptionPane.showInputDialog(ShowPicture.frame1, "Entrez le numéro du domino choisi:"));
    	    			if(DominoManager.getSelectedDominosNumbers().contains(num)) {
    	    				int index = DominoManager.getSelectedDominosNumbers().indexOf(num);
    	    				Domino domino = DominoManager.getSelectedDominos().get(index);
    	    				PlayerManager.getNextSequence()[DominoManager.getSelectedDominosNumbers().indexOf(domino.getNumber())] = PlayerManager.getPlayers().indexOf(this);
    	    				DominoManager.getSelectedDominosNumbers().set(index, null);
    	    				JOptionPane.showMessageDialog(ShowPicture.frame1, "Vous avez choisi le domino "+domino);
    	    				return domino;
    	    			} else {
    	    				JOptionPane.showMessageDialog(ShowPicture.frame1, "Vous ne pouvez pas choisir ce domino.");
    	    			}
    	    		} catch(Exception e) {
    	    			JOptionPane.showMessageDialog(ShowPicture.frame1, "Ce n'est pas un nombre.");
    	    		}
        		}
    		} else {
    		System.out.println("Entrez le numéro du domino choisi");
    		Scanner scan = new Scanner(System.in);
    		while(true) {
	    		try {
	    			int num = scan.nextInt();
	    			if(DominoManager.getSelectedDominosNumbers().contains(num)) {
	    				int index = DominoManager.getSelectedDominosNumbers().indexOf(num);
	    				Domino domino = DominoManager.getSelectedDominos().get(index);
	    				PlayerManager.getNextSequence()[DominoManager.getSelectedDominosNumbers().indexOf(domino.getNumber())] = PlayerManager.getPlayers().indexOf(this);
	    				DominoManager.getSelectedDominosNumbers().set(index, null);
	    				System.out.println("Vous avez choisi le domino "+domino);
	    				return domino;
	    			} else {
	    				System.out.println("Vous ne pouvez pas choisir ce domino.");
	    			}
	    		} catch(Exception e) {
	    			System.out.println("Ce n'est pas un nombre");
	    			scan.nextLine();
	    		}
    		}
    		}
    	}
    }

    public void setDomino(Board board, Domino domino) throws IOException{
    	if(isAI) {
    		ai.setDomino(this,board,domino);
    	} else {
	    	if(Main.GUI) {
	    		ShowPicture.placement(this, board, domino);
	    	} else {
				Scanner scan = new Scanner(System.in);
				System.out.println("Entrez la position en Y de la première case.");
				int posY = 0;
				while(true) {
		    		try {
		    			posY = scan.nextInt();
		    			if(0<=posY && posY<9) {
		    				System.out.println("OK!");
		    				break;
		    			} else {
		    				System.out.println("C'est en dehors du board.");
		    			}
		    		} catch(Exception e) {
		    			System.out.println("Ce n'est pas un nombre");
		    			scan.nextLine();
		    		}
				}
				System.out.println("Entrez la position en X de la première case.");
				int posX = 0;
				while(true) {
		    		try {
		    			posX = scan.nextInt();
		    			if(0<=posX && posX<9) {
		    				System.out.println("OK!");
		    				break;
		    			} else {
		    				System.out.println("C'est en dehors du board.");
		    			}
		    		} catch(Exception e) {
		    			System.out.println("Ce n'est pas un nombre");
		    			scan.nextLine();
		    		}
				}
				System.out.println("Entrez l'orientation du domino.");
				int orientation = 0;
				while(true) {
		    		try {
		    			orientation = scan.nextInt();
		    			if(0<=orientation && orientation<4) {
		    				System.out.println("OK!");
		    				break;
		    			} else {
		    				System.out.println("Impossible");
		    			}
		    		} catch(Exception e) {
		    			System.out.println("Ce n'est pas un nombre");
		    			scan.nextLine();
		    		}
				}
				verifyDomino(board,domino,posX,posY,orientation);
	    	}
    	}
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
				System.out.println("Le domino sort de la zone! Domino défaussé");
				System.out.println(1+" "+j);
				placed = true;
				return false;
			} else if (!board.getZones()[Math.max(Math.min(posY+j,8),0)][Math.max(posX-5,0)].equals("vide")) {
				System.out.println("Le domino sort de la zone! Domino défaussé");
				placed = true;
				System.out.println(2+" "+j);
				return false;
			} else if(!board.getZones()[Math.min(posY+5,8)][Math.max(Math.min(posX+j,8),0)].equals("vide")) {
				System.out.println("Le domino sort de la zone! Domino défaussé");
				System.out.println(3+" "+j);
				placed = true;
				return false;
			} else if (!board.getZones()[Math.max(posY-5,0)][Math.max(Math.min(posX+j,8),0)].equals("vide")) {
				System.out.println("Le domino sort de la zone! Domino défaussé");
				System.out.println(4+" "+j);
				placed = true;
				return false;
			} else if(!board.getZones()[Math.max(Math.min(posY2+j,8),0)][Math.min(posX2+5,8)].equals("vide")) {
				System.out.println("Le domino sort de la zone! Domino défaussé");
				System.out.println(1+" "+j+"2");
				placed = true;
				return false;
			} else if (!board.getZones()[Math.max(Math.min(posY2+j,8),0)][Math.max(posX2-5,0)].equals("vide")) {
				System.out.println("Le domino sort de la zone! Domino défaussé");
				placed = true;
				System.out.println(2+" "+j+"2");
				return false;
			} else if(!board.getZones()[Math.min(posY2+5,8)][Math.max(Math.min(posX2+j,8),0)].equals("vide")) {
				System.out.println("Le domino sort de la zone! Domino défaussé");
				System.out.println(3+" "+j+"2");
				placed = true;
				return false;
			} else if (!board.getZones()[Math.max(posY2-5,0)][Math.max(Math.min(posX2+j,8),0)].equals("vide")) {
				System.out.println("Le domino sort de la zone! Domino défaussé");
				System.out.println(4+" "+j+"2");
				placed = true;
				return false;
			}
		}
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
			} else {
				System.out.println(board.getZones()[posY][posX]);
				System.out.println(board.getZones()[posY2][posX2]);
				System.out.println(posX+" "+posY+" "+posX2+" "+posY2);
				System.out.println("Vous ne pouvez pas placer le domino ici! Domino défaussé");
				placed = true;
			}
		} else {
			System.out.println(board.getZones()[posY][posX]);
			System.out.println(board.getZones()[posY2][posX2]);
			System.out.println(posX+" "+posY+" "+posX2+" "+posY2);
			System.out.println("Case déjà prise! Domino défaussé");
			placed = true;
		}
		placed = true;
		return res;
    }
    public String getName() {
    	return name;
    }
    
    @Override
    public String toString() {
        return "Joueur "+name+" {" +
                "est une IA = " + isAI +
                ", couleur = " + color +
                '}';
    }
}

