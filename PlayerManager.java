import java.awt.Color;
import java.util.*;

import javax.swing.JOptionPane;

public class PlayerManager {
    private static List<Player> players = new ArrayList<>();
    private static Byte nbKing = 4;
    private static Byte nbPlayer = 4;
    private static List<Integer> sequence = new ArrayList<>();
    private static int[] nextSequence = new int[nbKing];
    private static List<Domino> dominoSequence = new ArrayList<Domino>();


    public static void main(String[] args){
        initialSequence();
        for (int i = 0; i< sequence.size(); i++){
            System.out.println(sequence.get(i));
        }
    }

    public static boolean choix(){
        Scanner scan = new Scanner(System.in);
        System.out.println("y/n?");
        while (true){
            try{
                String yesno= scan.nextLine();
                if (yesno.equals("y") || yesno.equals("n")){
                    if(yesno.equals("y")){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    System.out.println("Ce n'est pas la réponse attendue");
                    continue;
                }
            }
            catch(Exception e) {
                System.out.println("Ce n'est pas la réponse attendue");
            }
        }

    }

    public static void chooseNbPlayers(){ //la fonction qui récupère le nombre de joueur
    	Byte n = null;
    	if (Main.GUI) {
    		n = ShowPicture.nbPlayer;
    	} else {
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Entrez le nombre de joueurs");
	        while (true){
	            try {
	                n=scan.nextByte();
	                if (n > 4 || n<=0) {
	                    System.out.println("Nombre de joueurs incorrect.");
	                    continue;
	                } else {
	                    break;
	                }
	            }
	            catch(Exception e) {
	                System.out.println("Nombre incorrect.");
	                scan.nextLine();
	            }
	        }
    	}
        if (n==3) {
        	nbKing = 3;
        }
        nbPlayer = n;

    }

    public static void createPlayers(){
		if (Main.GUI) {
			for (Byte i = 1; i < nbPlayer + 1; i++) {
				String namePlayer = "Player" + i;
				System.out.println(namePlayer);
				int option = JOptionPane.showConfirmDialog(ShowPicture.frame1, "Le joueur" + namePlayer + "est-il une IA?",
						"Close Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				Boolean choixAI = false;
				if (option == JOptionPane.YES_OPTION) {
					choixAI = true;
				} if (option == JOptionPane.NO_OPTION) {
					choixAI = false;
					namePlayer = JOptionPane.showInputDialog(ShowPicture.frame1, "Quel est le nom du Joueur?");
				}
				Color color;
				switch (i) {
				case 1:
					color = Color.pink;
					break;
				case 2:
					color = Color.cyan;
					break;
				case 3:
					color = Color.magenta;
					break;
				default:
					color = Color.green;
					break;
				}
				Player player = new Player(namePlayer, choixAI, color);
				players.add(player);
			}
		} else {
			Scanner scan = new Scanner(System.in);
			for (Byte i = 1; i < nbPlayer + 1; i++) {
				String namePlayer = "Player" + i;
				System.out.println(namePlayer);
				System.out.println("Le joueur est-il une IA ?");
				Boolean choixAI = choix();
				if (!choixAI) {
					System.out.println("Veuillez saisir votre nom");
					namePlayer = scan.nextLine();
				}
				Color color;
				switch (i) {
				case 1:
					color = Color.pink;
					break;
				case 2:
					color = Color.cyan;
					break;
				case 3:
					color = Color.magenta;
					break;
				default:
					color = Color.green;
					break;
				}
				Player player = new Player(namePlayer, choixAI, color);
				players.add(player);
			}
		}
	}

    public static void initialSequence(){
        Random rand = new Random();
            for (Byte i = 0; i<nbKing; i++){
                int num = rand.nextInt(nbKing);
                if (sequence.contains(num)){
                    while(sequence.contains(num)){
                        int n = rand.nextInt(nbKing);
                        num = n;

                    }
                }
                sequence.add(num);
            }
            if(nbPlayer == 2) {
            	for(int i = 2; i<4; i++) {
                	int index = sequence.indexOf(i);
                	sequence.remove(index);
                	sequence.add(index, i-2);
            	}
            }

    }
    public static void restartSequence() {
    	sequence.clear();
    	for(int i=0; i<nextSequence.length; i++) {
    		sequence.add(nextSequence[i]);
    	}
    	nextSequence = new int[nbKing];
    	dominoSequence.clear();
    	for(int i=0; i<DominoManager.getSelectedDominos().size(); i++) {
			dominoSequence.add(DominoManager.getSelectedDominos().get(i));
    	}
    }
    
    public static List<Player> getPlayers() {
    	return players;
    }
    public static int getNbPlayer() {
    	return nbPlayer;
    }
    public static int getNbKing() {
    	return nbKing;
    }
    public static List<Integer> getSequence() {
    	return sequence;
    }
    public static int[] getNextSequence() {
    	return nextSequence;
    }
    public static List<Domino> getDominoSequence() {
    	return dominoSequence;
    }
}
