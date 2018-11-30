import java.util.*;
import java.io.*;

/**
 * Ouverture de fichier
 * @author Archibald Perez, Antoine Pontallier, Akhara Sang
 *
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		File dominos = new File("dominos.txt");
		Scanner scan = new Scanner(dominos);
		while (scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
	}
	public static Byte nbrejoueurs(){ //la fonction qui récupère le nombre de joueur
		Scanner a = new Scanner(System.in);
		Byte n = null;
		while (true){
			try {
				n=a.nextByte();
				if (n > 4 || n<0) {
					System.out.println("Nombre de joueurs incorrect.");
					continue;
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