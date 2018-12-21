import java.awt.*;
import java.util.Scanner;

public class Player {
    private String name;
    private Boolean isAI;
    private Color color;
    private AI ai = null;


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
    		System.out.println("Entrez le numéro du domino choisi");
    		Scanner scan = new Scanner(System.in);
    		while(true) {
	    		try {
	    			int num = scan.nextInt();
	    			if(DominoManager.getSelectedDominosNumbers().contains(num)) {
	    				int index = DominoManager.getSelectedDominosNumbers().indexOf(num);
	    				DominoManager.getSelectedDominosNumbers().remove(index);
	    				DominoManager.getSelectedDominos().remove(index);
	    				Domino domino = DominoManager.getSelectedDominos().get(index);
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

