import java.util.*;
import java.io.*;

/**
 * 
 * @author Archibald Perez, Antoine Pontallier, Akhara Sang
 *
 */
public class Main {
	public static void main(String[] args) {
		File file = new File("dominos.csv");
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
	}
}