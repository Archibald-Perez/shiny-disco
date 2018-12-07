import java.io.*;
import java.util.*;

public class DominoManager {
	public static List<Domino> Dominos = new ArrayList<>();
	
	public static void createDominos() throws FileNotFoundException {
		File dominos = new File("dominos.txt");
		Scanner scan = new Scanner(dominos);
		while (scan.hasNextLine()) {
			String[] elements = scan.nextLine().split(",");
			Domino domino = new Domino(Integer.parseInt(elements[4]),elements[1],elements[3],Integer.parseInt(elements[0]),Integer.parseInt(elements[2]));
			Dominos.add(domino);
		}
	}
}
