import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Player {
    private String name;
    private Boolean isAI;
    private Color color;
    private AI ai = null;
    static boolean placed = false;


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
    		return ai.selectDomino();
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
		if(board.getZones()[posY][posX].equals("vide") && board.getZones()[posY2][posX2].equals("vide")) {
			if(board.getZones()[posY+1][posX].equals(domino.getZone1()) || board.getZones()[posY+1][posX].equals("chateau")) {
				board.setDomino(domino, posY, posX, posY2, posX2);
				res = true;
			} else if(board.getZones()[posY-1][posX].equals(domino.getZone1()) || board.getZones()[posY-1][posX].equals("chateau")) {
				board.setDomino(domino, posY, posX, posY2, posX2);
				res = true;
			} else if(board.getZones()[posY][posX+1].equals(domino.getZone1()) || board.getZones()[posY][posX+1].equals("chateau")) {
				board.setDomino(domino, posY, posX, posY2, posX2);
				res = true;
			} else if(board.getZones()[posY][posX-1].equals(domino.getZone1()) || board.getZones()[posY][posX-1].equals("chateau")) {
				board.setDomino(domino, posY, posX, posY2, posX2);
				res = true;
			} else if(board.getZones()[posY2+1][posX2].equals(domino.getZone2()) || board.getZones()[posY2+1][posX2].equals("chateau")) {
				board.setDomino(domino, posY, posX, posY2, posX2);
				res = true;
			} else if(board.getZones()[posY2-1][posX2].equals(domino.getZone2()) || board.getZones()[posY2-1][posX2].equals("chateau")) {
				board.setDomino(domino, posY, posX, posY2, posX2);
				res = true;
			} else if(board.getZones()[posY2][posX2+1].equals(domino.getZone2()) || board.getZones()[posY2][posX2+1].equals("chateau")) {
				board.setDomino(domino, posY, posX, posY2, posX2);
				res = true;
			} else if(board.getZones()[posY2][posX2-1].equals(domino.getZone2()) || board.getZones()[posY2][posX2-1].equals("chateau")) {
				board.setDomino(domino, posY, posX, posY2, posX2);
				res = true;
			} else {
				System.out.println("Vous ne pouvez pas placer le domino ici! Domino défaussé");
				placed = true;
			}
		} else {
			System.out.println("Case déjà prise! Domino défaussé");
			placed = true;
		}
		placed = true;
		System.out.println("LOOKKKKK AT MMMMEEEE "+res);
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

