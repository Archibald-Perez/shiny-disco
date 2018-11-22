import java.util.*;

/**
 * 
 * @author Archibald Perez, Antoine Pontallier, Akhara Sang
 *
 */
public class Main {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\pankaj\\Desktop\\test.txt");
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine())
			System.out.println(sc.nextLine());
	}
}