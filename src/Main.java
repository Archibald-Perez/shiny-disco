import java.util.*;
import java.io.*;

/**
 * Ouverture de fichier
 * @author Archibald Perez, Antoine Pontallier, Akhara Sang
 *
 */
public class Main {
	public static int nbPlayers;
	public static void main(String[] args) {
		// Menu
			// Choix du nombre de joueur
			// Nom des joueurs + AI ou pas
		// Créer les joueurs
		// Création des dominos
		List<Domino> dominos = DominoManager.dominos;
		// Début de la partie
		// Choisi l'ordre initial des joueurs
		// Tant qu'il y a des dominos dans la pioche {
			// Sélectionne aléatoirement les dominos
			// Les joueurs choisissent leurs dominos
			// Boucles des joueurs {
				// Le joueur place son domino
			// }
		// }
		// Calcule des scores
		// Affiche le vainqueur
		// Retourne au menu
	}
	public static Byte chooseNbPlayers(){ //la fonction qui récupère le nombre de joueur
		Scanner a = new Scanner(System.in);
		Byte n = null;
		while (true){
			try {
				n=a.nextByte();
				if (n > 4 || n<=0) {
					System.out.println("Nombre de joueurs incorrect.");
					continue;
				} else {
					break;
				}
			}
			catch(Exception e) {
				System.out.println("Ce n'est pas un entier");
			}
		}
		return n;

	}
	public static void menu(){
		System.out.println("Domi'Nations");
		System.out.println("1. Jouer une partie");
		System.out.println("2. Quitter");
	}
	
}