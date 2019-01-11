
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	static byte nbPlayer = 0;
	static int fintour = 0;
	static int posx = 0;
	static int posy = 0;
	static String orientation = "";
	
	static JFrame frame1 = new JFrame();
	static JFrame frame = new JFrame();
	static ImageIcon menu = new ImageIcon("Menu1.jpg");
	static JLabel labelmenu = new JLabel(menu);
	static ImageIcon board0 = new ImageIcon("BoardPlayer1.jpg");
	static JLabel labelB0 = new JLabel(board0);
	static ImageIcon board1 = new ImageIcon("BoardPlayer2.jpg");
	static JLabel labelB1 = new JLabel(board1);
	static ImageIcon board2 = new ImageIcon("BoardPlayer3.jpg");
	static JLabel labelB2 = new JLabel(board2);
	static ImageIcon board3 = new ImageIcon("BoardPlayer4.jpg");
	static JLabel labelB3 = new JLabel(board3);
	static List<JLabel> labelsB = new ArrayList<>();
	static JLabel label49 = new JLabel(new ImageIcon("Castle.jpg"));
	static JLabel label49_1 = new JLabel(new ImageIcon("Castle.jpg"));
	static JLabel label49_2 = new JLabel(new ImageIcon("Castle.jpg"));
	static JLabel label49_3 = new JLabel(new ImageIcon("Castle.jpg"));
	static MouseListener mouse = new MouseAdapter() {};
	
	
	//////////LES 4 DOMINOS DE CHAQUE TOUR
	static List<ImageIcon> dominoIcons = new ArrayList<>();
	
	public static void main(String args[]) {
		//music(new File("theme.wav"));
	}
	
	public static void creation() throws IOException{
		frame1.setLayout(new FlowLayout());
		frame1.add(labelmenu);
		frame1.pack();
		frame1.setVisible(true);
		frame.setLayout(new FlowLayout());
		for(int i = 1; i < 49; i++) {
			dominoIcons.add(new ImageIcon(i+"-1.jpg"));
		}
		labelB0.add(label49);
		label49.setBounds(282, 299, 132, 66);
		labelB1.add(label49_1);
		label49_1.setBounds(282, 299, 132, 66);
		labelB2.add(label49_2);
		label49_2.setBounds(282, 299, 132, 66);
		labelB3.add(label49_3);
		label49_3.setBounds(282, 299, 132, 66);
		labelsB.add(labelB0);
		labelsB.add(labelB1);
		labelsB.add(labelB2);
		labelsB.add(labelB3);
		frame.add(labelB0);
		frame.add(labelB1);
		frame.add(labelB2);
		frame.add(labelB3);
		frame.pack();
		for(int playNum=0; playNum<4; playNum++) {
			BufferedImage img = new BufferedImage(1100, 726, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = img.createGraphics();
			labelsB.get(playNum).printAll(g2d);
			g2d.dispose();
			ImageIO.write(img, "png", new File("PLAYERBOARD"+playNum+".png"));
		}
	}
	
	///////////MENU PRINCIPAL
	public static boolean menu() {
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
						nbPlayer = 2;
						frame1.setVisible(false);
						frame.setVisible(true);
					}
					if (1027 < x && x < 1075) {
						nbPlayer = 3;
						frame1.setVisible(false);
						frame.setVisible(true);
					}
					if (1092 < x && x < 1140) {
						nbPlayer = 4;
						frame1.setVisible(false);
						frame.setVisible(true);
					}
				}
				if (853 < x && x < 1195 && 367 < y && y < 423) {
					frame1.setVisible(false);
					frame.setVisible(true);	
				}
			}
		});
		return true;
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
	
	public static void showDominos(){
		reload();
		for(int i = 0; i <PlayerManager.getNbKing(); i++) {
			ImageIcon iconchoisie = dominoIcons.get(DominoManager.getSelectedDominos().get(i).getNumber()-1);
			RotatedIcon roticon = new RotatedIcon(iconchoisie, 0.0);
			JLabel rotdomino = new JLabel(roticon);
			JLabel rotdomino1 = new JLabel(roticon);
			JLabel rotdomino2 = new JLabel(roticon);
			JLabel rotdomino3 = new JLabel(roticon);
			labelB0.add(label49);
			labelB0.add(rotdomino);
			labelB1.add(label49_1);
			labelB1.add(rotdomino1);
			labelB2.add(label49_2);
			labelB2.add(rotdomino2);
			labelB3.add(label49_3);
			labelB3.add(rotdomino3);
			rotdomino.setBounds(865, 61+110*i, 132, 66);
			rotdomino1.setBounds(865, 61+110*i, 132, 66);
			rotdomino2.setBounds(865, 61+110*i, 132, 66);
			rotdomino3.setBounds(865, 61+110*i, 132, 66);
		}
	}
	////////// END TURN
	public static void endturn(Player player, Board board, Domino domino, int x, int y)  throws IOException{
		int playNum = PlayerManager.getPlayers().indexOf(player);
		if (578 < x && x < 645 && 638 < y && y < 673) {
			int option = JOptionPane.showConfirmDialog(frame, "Voulez-vous valider votre tour?",
					"Close Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.YES_OPTION) {
				if (fintour == 1) {
					// Vérification à faire.
					int a = (posx-55)/66;
					int b = (posy-55)/66;
					int orient = 0;
					if(orientation.equals("gauche")) {
						orient = 1;
					}
					if(orientation.equals("haut")) {
						orient = 2;
					}
					if(orientation.equals("droite")) {
						orient = 3;
					}
					if(player.verifyDomino(board, domino, a, b, orient)) {
						System.out.println("Le domino est orienté vers " + orientation + "");
						System.out.println("Position: [" + a + ";" + b + "]");
						System.out.println("Fin du tour!");
						BufferedImage img = new BufferedImage(1100, 726, BufferedImage.TYPE_INT_ARGB);
						Graphics2D g2d = img.createGraphics();
						labelsB.get(playNum).printAll(g2d);
						g2d.dispose();
						ImageIO.write(img, "png", new File("PLAYERBOARD"+playNum+".png"));
					}
					showDominos();
					fintour = 0;
					labelsB.get(playNum).removeMouseListener(mouse);
				} else {
					JOptionPane.showMessageDialog(frame,"Veuillez d'abord placer un domino!");
				}
				return;
			}
			return;
		}
		return;
	}
	
	///////////PLACE DOMINO
	public static void placement(Player player, Board board, Domino domino) throws IOException{
		int playNum = PlayerManager.getPlayers().indexOf(player);
		labelB0.setVisible(false);
		labelB1.setVisible(false);
		labelB2.setVisible(false);
		labelB3.setVisible(false);
		if(playNum == 0) {
			String imageName = "PLAYERBOARD0.png";
			labelB0.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );
			labelB0.setVisible(true);
		}
		if(playNum == 1) {
			String imageName = "PLAYERBOARD1.png";
			labelB1.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );
			labelB1.setVisible(true);
		}
		if(playNum == 2) {
			String imageName = "PLAYERBOARD2.png";
			labelB2.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );
			labelB2.setVisible(true);
		}
		if(playNum == 3) {
			String imageName = "PLAYERBOARD3.png";
			labelB3.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );
			labelB3.setVisible(true);
		}
		frame.revalidate();
		frame.repaint();
		ImageIcon iconchoisie = dominoIcons.get(domino.getNumber()-1);
		RotatedIcon roticon = new RotatedIcon(iconchoisie, 0.0);
		JLabel rotdomino = new JLabel(roticon);
		RotatedIcon roticon2 = new RotatedIcon(iconchoisie, 90.0);
		JLabel rotdomino2 = new JLabel(roticon2);
		RotatedIcon roticon3 = new RotatedIcon(iconchoisie, 180.0);
		JLabel rotdomino3 = new JLabel(roticon3);
		RotatedIcon roticon4 = new RotatedIcon(iconchoisie, 270.0);
		JLabel rotdomino4 = new JLabel(roticon4);	
		mouse = new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				System.out.println("LE DOMINO: "+domino.getNumber());
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
									labelsB.get(playNum).add(rotdomino);
									labelsB.get(playNum).remove(rotdomino2);
									labelsB.get(playNum).remove(rotdomino3);
									labelsB.get(playNum).remove(rotdomino4);
									labelsB.get(playNum).revalidate();
									labelsB.get(playNum).repaint();
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
									labelsB.get(playNum).remove(rotdomino);
									labelsB.get(playNum).add(rotdomino2);
									labelsB.get(playNum).remove(rotdomino3);
									labelsB.get(playNum).remove(rotdomino4);
									labelsB.get(playNum).revalidate();
									labelsB.get(playNum).repaint();
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
									labelsB.get(playNum).remove(rotdomino);
									labelsB.get(playNum).remove(rotdomino2);
									labelsB.get(playNum).add(rotdomino3);
									labelsB.get(playNum).remove(rotdomino4);
									labelsB.get(playNum).revalidate();
									labelsB.get(playNum).repaint();
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
									labelsB.get(playNum).remove(rotdomino);
									labelsB.get(playNum).remove(rotdomino2);
									labelsB.get(playNum).remove(rotdomino3);
									labelsB.get(playNum).add(rotdomino4);
									labelsB.get(playNum).revalidate();
									labelsB.get(playNum).repaint();
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
				try{
				endturn(player,board,domino,x,y);
				} catch (IOException err) {
					throw new RuntimeException(err);
				}
			} 
		};
		labelsB.get(playNum).addMouseListener(mouse);
		return;
	}
	
	public static void reload() {
		labelB0.removeAll();
		labelB0.revalidate();
		labelB0.repaint();
		labelB0.add(label49);
		labelB1.removeAll();
		labelB1.revalidate();
		labelB1.repaint();
		labelB1.add(label49);
		labelB2.removeAll();
		labelB2.revalidate();
		labelB2.repaint();
		labelB2.add(label49);
		labelB3.removeAll();
		labelB3.revalidate();
		labelB3.repaint();
		labelB3.add(label49);
		label49.setBounds(282, 299, 132, 66);
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
