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
}