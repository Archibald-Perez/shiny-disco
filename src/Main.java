import java.util.*;
import java.io.*;

/**
 * @author Archibald Perez, Antoine Pontallier, Akhara Sang
 *
 */
public class Main {
	public static boolean GUI = true;
	public static List<Board> boards = new ArrayList<>();
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// Menu
			ShowPicture.creation();
			ShowPicture.closeall(ShowPicture.frame1);
			ShowPicture.closeall(ShowPicture.frame);
			ShowPicture.menu();
			// Wait for player select
			do {
				PlayerManager.chooseNbPlayers();
				System.out.print("");
			} while(PlayerManager.getNbPlayer() == 0);
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
		// Selectionne les premiers dominos
		DominoManager.selectDominos();
		System.out.println("");
		// Choisi l'ordre initial des joueurs
		PlayerManager.initialSequence();
		for (int i = 0; i< PlayerManager.getNbKing(); i++) {
			Player turnPlayer = PlayerManager.getPlayers().get(PlayerManager.getSequence().get(i));
			System.out.println(turnPlayer.getName()+" choisi un domino");
			turnPlayer.selectDomino();
		}
		
		PlayerManager.restartSequence();
		System.out.println("");
		while(DominoManager.getNbInDeck() > 0) {
			DominoManager.selectDominos();
			System.out.println("");
			// Boucle des joueurs
			for (int i = 0; i< PlayerManager.getNbKing(); i++) {
				int indexPlayer = PlayerManager.getSequence().get(i);
				Player turnPlayer = PlayerManager.getPlayers().get(indexPlayer);
				Domino turnDomino = PlayerManager.getDominoSequence().get(i);
				Board turnBoard = boards.get(indexPlayer);
				System.out.println(turnBoard);
				System.out.println("Le joueur "+turnPlayer.getName()+" place le domino : "+turnDomino);
				// Le joueur place son domino
				turnPlayer.setDomino(turnBoard, turnDomino);
				while(!turnPlayer.placed) {
					System.out.print("");
				}
				turnPlayer.placed = false;
				System.out.println(turnBoard);
				// Le joueur choisi le domino suivant
				System.out.println(turnPlayer.getName()+" choisi un domino");
				PlayerManager.getDominoSequence().add(turnPlayer.selectDomino());
				System.out.println(turnBoard.score());
			}
			System.out.println("");
			PlayerManager.restartSequence();
			
		}
		int win = 0;
		int maxScore = 0;
		for(int i=0; i<boards.size(); i++) {
			int score = boards.get(i).score();
			if(score>maxScore) {
				win = i;
				maxScore = score;
			}
			System.out.println("Le joueur "+PlayerManager.getPlayers().get(i).getName()+"a obtenu "+score);
		}
		System.out.println("Le joueur "+PlayerManager.getPlayers().get(win).getName()+"a gagné!");
		// Affiche le vainqueur
		// Retourne au menu
	}

	public static void menu(){
		System.out.println("Domi'Nations");
		System.out.println("1. Jouer une partie");
		System.out.println("2. Quitter");
	}
	
}