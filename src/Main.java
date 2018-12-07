import java.util.*;
import java.io.*;

/**
 * Ouverture de fichier
 * @author Archibald Perez, Antoine Pontallier, Akhara Sang
 *
 */
public class Main {
	public static int nbPlayers;
	public static void main(String[] args) throws FileNotFoundException{
		// Menu
			Byte nbPlayers = PlayerManager.chooseNbPlayers();
			// Nom des joueurs + AI ou pas
		// Créer les joueurs
		DominoManager.createDominos();
		// Début de la partie
		// Choisi l'ordre initial des joueurs
		while(DominoManager.nbInDeck > 0) {
			DominoManager.selectDominos();
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