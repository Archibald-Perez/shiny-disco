import java.util.*;
import java.io.*;

/**
 * @author Archibald Perez, Antoine Pontallier, Akhara Sang
 *
 */
public class Main {
	public static List<Board> boards = new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException{
		// Menu
			PlayerManager.chooseNbPlayers();
			PlayerManager.createPlayers();
			for (int i=0;i<PlayerManager.getPlayers().size();i++) {
				Player player = PlayerManager.getPlayers().get(i);
				System.out.println(player);
			}
			System.out.println("");
		DominoManager.createDominos();
		// Début de la partie
		for (int i=0;i<PlayerManager.getNbPlayer();i++) {
			Board board = new Board(9, PlayerManager.getPlayers().get(i));
			boards.add(board);
		}
		PlayerManager.initialSequence();
		// Choisi l'ordre initial des joueurs
		while(DominoManager.getNbInDeck() > 0) {
			DominoManager.selectDominos();
			for (int i=0;i<DominoManager.getSelectedDominos().size();i++) {
				Domino domino = DominoManager.getSelectedDominos().get(i);
				System.out.println(domino);
			}
			System.out.println("");
			for (int i = 0; i< PlayerManager.getNbKing(); i++) {
				Player turnPlayer = PlayerManager.getPlayers().get(PlayerManager.getSequence().get(i));
				System.out.println(turnPlayer.getName()+" choisi un domino");
				turnPlayer.selectDomino();
			}
			System.out.println("");
			// Boucles des joueurs {
				// Le joueur place son domino
				// Le joueur choisi le domino suivant
			// }
		}
		// Calcule des scores
		// Affiche le vainqueur
		// Retourne au menu
	}

	public static void menu(){
		System.out.println("Domi'Nations");
		System.out.println("1. Jouer une partie");
		System.out.println("2. Quitter");
	}
	
}