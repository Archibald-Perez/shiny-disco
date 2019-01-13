import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class DominoManager {
	private static List<Domino> dominos = new ArrayList<>();
	private static List<Domino> selectedDominos = new ArrayList<>();
	private static List<Integer> selectedDominosNumbers = new ArrayList<>();
	private static int nbInDeck = 48;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
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
		while(nbInDeck > PlayerManager.getNbPlayer()*12) {
			int numDomino = random.nextInt(48);
			Domino testDomino = dominos.get(numDomino);
			if (testDomino.isInDeck) {
				testDomino.isInDeck = false;
				nbInDeck--;
			}
		}
	}
	public static void selectDominos()  throws IOException{
		selectedDominos.clear();
		Random random = new Random();
		while(selectedDominos.size() < PlayerManager.getNbKing()) {
			int len = selectedDominos.size();
			int numDomino = random.nextInt(48);
			Domino testDomino = dominos.get(numDomino);
			if (testDomino.isInDeck) {
				testDomino.isInDeck = false;
				nbInDeck--;
				int index = len;
				for(int i = len -1; i>=0; i--) {
					if (selectedDominos.get(i).getNumber() > testDomino.getNumber()) {
						index = i;
					}
				}
				selectedDominos.add(index, testDomino);
				selectedDominosNumbers.add(index, testDomino.getNumber());
			}
		}
		for (int i=0;i<DominoManager.getSelectedDominos().size();i++) {
			Domino domino = DominoManager.getSelectedDominos().get(i);
				System.out.println(domino);
		}
		ShowPicture.showDominos();
	}
	public static List<Domino> getDominos() {
    	return dominos;
    }
	public static List<Domino> getSelectedDominos() {
    	return selectedDominos;
    }
	public static List<Integer> getSelectedDominosNumbers() {
    	return selectedDominosNumbers;
    }
	public static int getNbInDeck() {
    	return nbInDeck;
    }
}
