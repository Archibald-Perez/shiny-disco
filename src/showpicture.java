
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class showpicture {
	public static void main(String args[]) {
		  Scanner scan = new Scanner(System.in);
		  JFrame frame = new JFrame();
		  ImageIcon board = new ImageIcon("C:\\Users\\antoi\\Documents\\GitHub\\shiny-disco\\Board1.jpg");
		  JLabel label = new JLabel(board);
		  frame.add(label);
		  frame.pack();
		  frame.setVisible(true);
		  int width = label.getWidth();
		  int height = label.getHeight();
		  System.out.println(width);
		  System.out.println(height);
	label.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int x=e.getX();
			int y=e.getY();
			System.out.println(x+","+y);
			if(55<x && x<115 && 641<y && y<671) {
				System.out.println("Voulez-vous vraiment arrêter la partie?");
				String reponse = scan.nextLine();
				if (reponse == "oui") {
					//FERMER JEU
				} else if (reponse == "non") {
					System.out.println("D'accord, le jeu continue.");
				}else {
					System.out.println("Veuillez entrer une réponse correcte.");
				}
			}
		}
	});
	}
}
