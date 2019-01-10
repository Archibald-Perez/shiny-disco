
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

public class showpicture {
	static int NbrJoueurs = 0;
	static int fintour = 0;
	static int posx = 0;
	static int posy = 0;
	static String orientation = "";
	static ImageIcon iconchoisie = new ImageIcon("45-1.jpg");  // A CHANGER EN FONCTION DU DOMINO
	static RotatedIcon roticon = new RotatedIcon(iconchoisie, 0.0);
	static JLabel rotdomino = new JLabel(roticon);
	static RotatedIcon roticon2 = new RotatedIcon(iconchoisie, 90.0);
	static JLabel rotdomino2 = new JLabel(roticon2);
	static RotatedIcon roticon3 = new RotatedIcon(iconchoisie, 180.0);
	static JLabel rotdomino3 = new JLabel(roticon3);
	static RotatedIcon roticon4 = new RotatedIcon(iconchoisie, 270.0);
	static JLabel rotdomino4 = new JLabel(roticon4);
	
	
	public static void main(String args[]) {

		/////////// CREATE IMAGES
		JFrame frame1 = new JFrame();
		frame1.setLayout(new FlowLayout());
		ImageIcon menu = new ImageIcon("Menu1.jpg");
		JLabel labelmenu = new JLabel(menu);
		frame1.add(labelmenu);
		frame1.pack();
		frame1.setVisible(true);
		
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		ImageIcon board = new ImageIcon("Board2.jpg");
		JLabel label = new JLabel(board);
		JLabel label1 = new JLabel(new ImageIcon("1-1.jpg"));
		JLabel label2 = new JLabel(new ImageIcon("2-1.jpg"));
		JLabel label3 = new JLabel(new ImageIcon("3-1.jpg"));
		JLabel label4 = new JLabel(new ImageIcon("4-1.jpg"));
		JLabel label5 = new JLabel(new ImageIcon("5-1.jpg"));
		JLabel label6 = new JLabel(new ImageIcon("6-1.jpg"));
		JLabel label7 = new JLabel(new ImageIcon("7-1.jpg"));
		JLabel label8 = new JLabel(new ImageIcon("8-1.jpg"));
		JLabel label9 = new JLabel(new ImageIcon("9-1.jpg"));
		JLabel label10 = new JLabel(new ImageIcon("10-1.jpg"));
		JLabel label11 = new JLabel(new ImageIcon("11-1.jpg"));
		JLabel label12 = new JLabel(new ImageIcon("12-1.jpg"));
		JLabel label13 = new JLabel(new ImageIcon("13-1.jpg"));
		JLabel label14 = new JLabel(new ImageIcon("14-1.jpg"));
		JLabel label15 = new JLabel(new ImageIcon("15-1.jpg"));
		JLabel label16 = new JLabel(new ImageIcon("16-1.jpg"));
		JLabel label17 = new JLabel(new ImageIcon("17-1.jpg"));
		JLabel label18 = new JLabel(new ImageIcon("18-1.jpg"));
		JLabel label19 = new JLabel(new ImageIcon("19-1.jpg"));
		JLabel label20 = new JLabel(new ImageIcon("20-1.jpg"));
		JLabel label21 = new JLabel(new ImageIcon("21-1.jpg"));
		JLabel label22 = new JLabel(new ImageIcon("22-1.jpg"));
		JLabel label23 = new JLabel(new ImageIcon("23-1.jpg"));
		JLabel label24 = new JLabel(new ImageIcon("24-1.jpg"));
		JLabel label25 = new JLabel(new ImageIcon("25-1.jpg"));
		JLabel label26 = new JLabel(new ImageIcon("26-1.jpg"));
		JLabel label27 = new JLabel(new ImageIcon("27-1.jpg"));
		JLabel label28 = new JLabel(new ImageIcon("28-1.jpg"));
		JLabel label29 = new JLabel(new ImageIcon("29-1.jpg"));
		JLabel label30 = new JLabel(new ImageIcon("30-1.jpg"));
		JLabel label31 = new JLabel(new ImageIcon("31-1.jpg"));
		JLabel label32 = new JLabel(new ImageIcon("32-1.jpg"));
		JLabel label33 = new JLabel(new ImageIcon("33-1.jpg"));
		JLabel label34 = new JLabel(new ImageIcon("34-1.jpg"));
		JLabel label35 = new JLabel(new ImageIcon("35-1.jpg"));
		JLabel label36 = new JLabel(new ImageIcon("36-1.jpg"));
		JLabel label37 = new JLabel(new ImageIcon("37-1.jpg"));
		JLabel label38 = new JLabel(new ImageIcon("38-1.jpg"));
		JLabel label39 = new JLabel(new ImageIcon("39-1.jpg"));
		JLabel label40 = new JLabel(new ImageIcon("40-1.jpg"));
		JLabel label41 = new JLabel(new ImageIcon("41-1.jpg"));
		JLabel label42 = new JLabel(new ImageIcon("42-1.jpg"));
		JLabel label43 = new JLabel(new ImageIcon("43-1.jpg"));
		JLabel label44 = new JLabel(new ImageIcon("44-1.jpg"));
		JLabel label45 = new JLabel(new ImageIcon("45-1.jpg"));
		JLabel label46 = new JLabel(new ImageIcon("46-1.jpg"));
		JLabel label47 = new JLabel(new ImageIcon("47-1.jpg"));
		JLabel label48 = new JLabel(new ImageIcon("48-1.jpg"));
		JLabel label49 = new JLabel(new ImageIcon("Castle.jpg"));
		
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
						label.add(label49);
						label49.setBounds(282, 299, 132, 66); // A CHANGER EN FONCTION DU CHATEAU
						label.add(rotdomino);
						rotdomino.setBounds(865, 61, 132, 66);
						frame.pack();
						frame.setVisible(true);
					}
					if (1027 < x && x < 1075) {
						NbrJoueurs = 3;
						frame1.setVisible(false);
						frame.add(label);
						label.add(label49);
						label49.setBounds(282, 299, 132, 66); // A CHANGER EN FONCTION DU CHATEAU
						label.add(rotdomino);
						rotdomino.setBounds(865, 61, 132, 66);
						frame.pack();
						frame.setVisible(true);
					}
					if (1092 < x && x < 1140) {
						NbrJoueurs = 4;
						frame1.setVisible(false);
						frame.add(label);
						label.add(label49);
						label49.setBounds(282, 299, 132, 66); // A CHANGER EN FONCTION DU CHATEAU
						label.add(rotdomino);
						rotdomino.setBounds(865, 61, 132, 66);
						frame.pack();
						frame.setVisible(true);
					}
				}
				if (853 < x && x < 1195 && 367 < y && y < 423) {
					frame1.setVisible(false);
					frame.add(label);
					label.add(label49);
					label49.setBounds(282, 299, 132, 66); // A CHANGER EN FONCTION DU CHATEAU
					label.add(rotdomino);
					rotdomino.setBounds(865, 61, 132, 66);
					frame.pack();
					frame.setVisible(true);					
				}
			}
		});
		
		closeall(frame1);
		closeall(frame);
		
		////////// MOUSE CLICKING
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
		music(new File("theme.wav"));
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
