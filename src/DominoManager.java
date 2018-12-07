import java.io.*;
import java.util.*;

public class DominoManager {
	public static List<Domino> dominos = new ArrayList<>();
	
	public static void createDominos() throws FileNotFoundException {
		File dominoFile = new File("dominos.txt");
		Scanner scan = new Scanner(dominoFile);
		while (scan.hasNextLine()) {
			String[] elements = scan.nextLine().split(",");
			DominoInDeck domino = new DominoInDeck(Integer.parseInt(elements[4]),elements[1],elements[3],Integer.parseInt(elements[0]),Integer.parseInt(elements[2]));
			dominos.add(domino);
		}
	}
}
