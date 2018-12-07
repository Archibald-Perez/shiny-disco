import java.util.*;
import java.io.*;

/**
 * Ouverture de fichier
 * @author Archibald Perez, Antoine Pontallier, Akhara Sang
 *
 */
public class Main {
	public static List<Board> boards = new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException{
		// Menu
			PlayerManager.chooseNbPlayers();
			PlayerManager.createPlayers();
			for (int i=0;i<PlayerManager.players.size();i++) {
				Player player = PlayerManager.players.get(i);
				System.out.println(player);
			}
			System.out.println("");
		DominoManager.createDominos();
		// Début de la partie
		for (int i=0;i<PlayerManager.nbPlayer;i++) {
			Board board = new Board(9, PlayerManager.players.get(i));
			boards.add(board);
		}
		// Choisi l'ordre initial des joueurs
		while(DominoManager.nbInDeck > 0) {
			DominoManager.selectDominos();
			for (int i=0;i<DominoManager.selectedDominos.size();i++) {
				Domino domino = DominoManager.selectedDominos.get(i);
				System.out.println(domino);
			}
			System.out.println("");
			// Les joueurs choisissent leurs dominos
			// Boucles des joueurs {
				// Le joueur place son domino
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