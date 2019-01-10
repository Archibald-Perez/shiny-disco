
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.util.*;

public class ShowPicture {
	static byte NbrJoueurs = 0;
	static int fintour = 0;
	static int posx = 0;
	static int posy = 0;
	static String orientation = "";
	
	static JFrame frame1 = new JFrame();
	static JFrame frame = new JFrame();
	static ImageIcon menu = new ImageIcon("Menu1.jpg");
	static JLabel labelmenu = new JLabel(menu);
	static ImageIcon board = new ImageIcon("Board2.jpg");
	static JLabel label = new JLabel(board);
	static JLabel label49 = new JLabel(new ImageIcon("Castle.jpg"));
	
	
	//////////LES 4 DOMINOS DE CHAQUE TOUR
	static ImageIcon iconchoisie = new ImageIcon("45-1.jpg");  // A CHANGER EN FONCTION DU DOMINO
	static RotatedIcon roticon = new RotatedIcon(iconchoisie, 0.0);
	static JLabel rotdomino = new JLabel(roticon);
	static ImageIcon iconchoisiebis = new ImageIcon("46-1.jpg");  // A CHANGER EN FONCTION DU DOMINO
	static RotatedIcon roticonbis = new RotatedIcon(iconchoisiebis, 0.0);
	static JLabel rotdominobis = new JLabel(roticonbis);	
	static ImageIcon iconchoisieter = new ImageIcon("47-1.jpg");  // A CHANGER EN FONCTION DU DOMINO
	static RotatedIcon roticonter = new RotatedIcon(iconchoisieter, 0.0);
	static JLabel rotdominoter = new JLabel(roticonter);	
	static ImageIcon iconchoisiequa = new ImageIcon("48-1.jpg");  // A CHANGER EN FONCTION DU DOMINO
	static RotatedIcon roticonqua = new RotatedIcon(iconchoisiequa, 0.0);
	static JLabel rotdominoqua = new JLabel(roticonqua);
	static List<ImageIcon> dominoIcons = new ArrayList<>();
	
	public static void main(String args[]) {
		creation();
		menu();		
		closeall(frame1);
		closeall(frame);
		Domino domino = new Domino(43,"z","z",12,12);
		placement(domino);
		music(new File("theme.wav"));
	}
	
	///////////MENU PRINCIPAL
	public static void creation() {
		frame1.setLayout(new FlowLayout());
		frame1.add(labelmenu);
		frame1.pack();
		frame1.setVisible(true);
		frame.setLayout(new FlowLayout());
		for(int i = 1; i < 49; i++) {
			dominoIcons.add(new ImageIcon(i+"-1.jpg"));
		}
	}
	
	public static void menu() {
		labelmenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				if (22 < x && x < 105 && 560 < y && y < 639) {
					int option = JOptionPane.showConfirmDialog(frame1, "Voulez-vous fermer le jeu?",
							"Close Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
				if (293 < y && y < 333) {
					if (895 < x && x < 940) {
						JOptionPane.showMessageDialog(frame, "Jouer tout seul, c'est triste! Essayez avec des amis!");
					}
					if (965 < x && x < 1005) {
						NbrJoueurs = 2;
						frame1.setVisible(false);
						frame.add(label);
						frame.pack();
						frame.setVisible(true);
					}
					if (1027 < x && x < 1075) {
						NbrJoueurs = 3;
						frame1.setVisible(false);
						frame.add(label);
						frame.pack();
						frame.setVisible(true);
					}
					if (1092 < x && x < 1140) {
						NbrJoueurs = 4;
						frame1.setVisible(false);
						frame.add(label);
						frame.pack();
						frame.setVisible(true);
					}
				}
				if (853 < x && x < 1195 && 367 < y && y < 423) {
					frame1.setVisible(false);
					frame.add(label);
					frame.pack();
					frame.setVisible(true);					
				}
				label.add(label49);
				label49.setBounds(282, 299, 132, 66);
				label.add(rotdomino);
				rotdomino.setBounds(865, 61, 132, 66);
				label.add(rotdominobis);
				rotdominobis.setBounds(866, 171, 132, 66);
				label.add(rotdominoter);
				rotdominoter.setBounds(867, 280, 132, 66);
				label.add(rotdominoqua);
				rotdominoqua.setBounds(867, 387, 132, 66);
			}
		});
	}
	////////// CLOSE ALL
	public static void closeall(JFrame frame) {
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(frame, "Voulez-vous fermer l'application?",
						"Close Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}
	
	////////// END TURN
	public static void endturn(int x, int y, int posx, int posy, JFrame frame, String orientation, int fintour) {
		if (578 < x && x < 645 && 638 < y && y < 673) {
			int option = JOptionPane.showConfirmDialog(frame, "Voulez-vous valider votre tour?",
					"Close Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.YES_OPTION) {
				if (fintour == 1) {
					// Vérification à faire.
					int a = (posx-55)/66+1;
					int b = (posy-55)/66+1;
					System.out.println("Le domino est orienté vers " + orientation + "");
					System.out.println("Position: [" + a + ";" + b + "]");
					System.out.println("Fin du tour!");
					fintour = 0;
				} else {
					JOptionPane.showMessageDialog(frame,"Veuillez d'abord placer un domino!");
				}
			}
		}
	}
	
	///////////PLACE DOMINO
	public static void placement(Domino domino) {
		ImageIcon iconchoisie = dominoIcons.get(domino.getNumber());  // A CHANGER EN FONCTION DU DOMINO
		RotatedIcon roticon = new RotatedIcon(iconchoisie, 0.0);
		JLabel rotdomino = new JLabel(roticon);
		RotatedIcon roticon2 = new RotatedIcon(iconchoisie, 90.0);
		JLabel rotdomino2 = new JLabel(roticon2);
		RotatedIcon roticon3 = new RotatedIcon(iconchoisie, 180.0);
		JLabel rotdomino3 = new JLabel(roticon3);
		RotatedIcon roticon4 = new RotatedIcon(iconchoisie, 270.0);
		JLabel rotdomino4 = new JLabel(roticon4);	
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				int button = e.getButton();

				//////////// POWER OFF
				if (55 < x && x < 115 && 641 < y && y < 671) {
					int option = JOptionPane.showConfirmDialog(frame, "Voulez-vous arrêter la partie?",
							"Close Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}

				/////////// PLACE DOMINO
				for (int i = 51; i < 645; i = i + 66) {
					for (int j = 35; j < 629; j = j + 66) {
						if (i < x && x < i + 65 && j < y && y < j + 65) {
							if (button == 1) {
								if (x > 579) {
									JOptionPane.showMessageDialog(frame,
											"Vous ne pouvez pas placer de domino ici! Faites le pivoter!");
								} else if (250 < x && x < 380 && 299 < y && y < 364) { 
									JOptionPane.showMessageDialog(frame,
											"Vous ne pouvez pas placer de domino sur le château!");
								} else {
									label.add(rotdomino);
									label.remove(rotdomino2);
									label.remove(rotdomino3);
									label.remove(rotdomino4);
									label.revalidate();
									label.repaint();
									rotdomino.setBounds(i, j, 132, 66);
									orientation = "droite";
									fintour = 1;
									posx = x;
									posy = y;
								}
							}
							if (button == 3) {
								if (y > 563) {
									JOptionPane.showMessageDialog(frame,
											"Vous ne pouvez pas placer de domino ici! Faites le pivoter!");
								} else if (315 < x && x < 380 && 234 < y && y < 364) {
									JOptionPane.showMessageDialog(frame,
											"Vous ne pouvez pas placer de domino sur le château!");
								} else {
									label.remove(rotdomino);
									label.add(rotdomino2);
									label.remove(rotdomino3);
									label.remove(rotdomino4);
									label.revalidate();
									label.repaint();
									rotdomino2.setBounds(i, j, 66, 132);
									orientation = "bas";
									fintour = 1;
									posx = x;
									posy = y;
								}
							}
							if (button == 5) {
								if (x < 117) {
									JOptionPane.showMessageDialog(frame,
											"Vous ne pouvez pas placer de domino ici! Faites le pivoter!");
								} else if (315 < x && x < 445 && 299 < y && y < 364) { 
									JOptionPane.showMessageDialog(frame,
											"Vous ne pouvez pas placer de domino sur le château!");
								} else {
									label.remove(rotdomino);
									label.remove(rotdomino2);
									label.add(rotdomino3);
									label.remove(rotdomino4);
									label.revalidate();
									label.repaint();
									rotdomino3.setBounds(i, j, 132, 66);
									orientation = "gauche";
									fintour = 1;
									posx = x;
									posy = y;
								}
							}
							if (button == 4) {
								if (y < 101) {
									JOptionPane.showMessageDialog(frame,
											"Vous ne pouvez pas placer de domino ici! Faites le pivoter!");
								} else if (315 < x && x < 380 && 299 < y && y < 429) { 
									JOptionPane.showMessageDialog(frame,
											"Vous ne pouvez pas placer de domino sur le château!");
								} else {
									label.remove(rotdomino);
									label.remove(rotdomino2);
									label.remove(rotdomino3);
									label.add(rotdomino4);
									label.revalidate();
									label.repaint();
									rotdomino4.setBounds(i, j, 66, 132);
									orientation = "haut";
									fintour = 1;
									posx = x;
									posy = y;
								}
							}
						}
					}
				}
				endturn(x,y,posx,posy,frame,orientation,fintour);
			}
		});
	}
	
	/////////// BACKGROUND MUSIC
	public static void music(File file) {
		{
			try {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
				AudioFormat audioFormat = audioInputStream.getFormat();
				DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
				SourceDataLine sourceLine = (SourceDataLine) AudioSystem.getLine(info);
				sourceLine.open(audioFormat);
				sourceLine.start();
				int nBytesRead = 0;
				byte[] abData = new byte[128000];
				while (nBytesRead != -1) {
					try {
						nBytesRead = audioInputStream.read(abData, 0, abData.length);
					} catch (IOException f) {
						f.printStackTrace();
					}
					if (nBytesRead >= 0) {
						sourceLine.write(abData, 0, nBytesRead);
					}
				}
				sourceLine.drain();
				sourceLine.close();
			} catch (UnsupportedAudioFileException | IOException f) {
				f.printStackTrace();
			} catch (LineUnavailableException f) {
				f.printStackTrace();
			}
		}
	}
}
