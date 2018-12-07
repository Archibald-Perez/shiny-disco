import java.io.*;
import java.util.*;

public class DominoManager {
	public static List<Domino> dominos = new ArrayList<>();
	public static List<Domino> selectedDominos = new ArrayList<>();
	public static int nbInDeck = 48;
	
	public static void main(String[] args) throws FileNotFoundException {
		createDominos();
		selectDominos();
		for (int i=0;i<selectedDominos.size();i++) {
			Domino domino = selectedDominos.get(i);
			System.out.println(domino);
		}
	}
	
	public static void createDominos() throws FileNotFoundException {
		File dominoFile = new File("dominos.txt");
		Scanner scan = new Scanner(dominoFile);
		while (scan.hasNextLine()) {
			String[] elements = scan.nextLine().split(",");
			Domino domino = new Domino(Integer.parseInt(elements[4]),elements[1],elements[3],Integer.parseInt(elements[0]),Integer.parseInt(elements[2]));
			dominos.add(domino);
		}
		removeRndDominos();
	}
	
	public static void removeRndDominos() {
		Random random = new Random();
		while(nbInDeck > PlayerManager.nbPlayer*12) {
			int numDomino = random.nextInt(48);
			Domino testDomino = dominos.get(numDomino);
			if (testDomino.isInDeck) {
				testDomino.isInDeck = false;
				nbInDeck--;
			}
		}
	}
	public static void selectDominos() {
		selectedDominos.clear();
		Random random = new Random();
		while(selectedDominos.size() < PlayerManager.nbKing) {
			int numDomino = random.nextInt(48);
			Domino testDomino = dominos.get(numDomino);
			if (testDomino.isInDeck) {
				testDomino.isInDeck = false;
				nbInDeck--;
				selectedDominos.add(testDomino);
			}
		}
	}
}
