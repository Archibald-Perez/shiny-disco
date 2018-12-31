
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
	public static void main(String args[]) {
			
		  ///////////CREATE IMAGES
		  JFrame frame = new JFrame();
		  frame.setLayout(new FlowLayout());
		  ImageIcon board = new ImageIcon("Board1.jpg");
		  JLabel label = new JLabel(board);
		  ImageIcon domino1 = new ImageIcon("1-1.jpg");
		  JLabel label1 = new JLabel(domino1);
		  ImageIcon domino2 = new ImageIcon("2-1.jpg");
		  JLabel label2 = new JLabel(domino2);
		  ImageIcon domino3 = new ImageIcon("3-1.jpg");
		  JLabel label3 = new JLabel(domino3);
		  ImageIcon domino4 = new ImageIcon("4-1.jpg");
		  JLabel label4 = new JLabel(domino4);
		  ImageIcon domino5 = new ImageIcon("5-1.jpg");
		  JLabel label5 = new JLabel(domino5);
		  ImageIcon domino6 = new ImageIcon("6-1.jpg");
		  JLabel label6 = new JLabel(domino6);
		  ImageIcon domino7 = new ImageIcon("7-1.jpg");
		  JLabel label7 = new JLabel(domino7);
		  ImageIcon domino8 = new ImageIcon("8-1.jpg");
		  JLabel label8 = new JLabel(domino8);
		  ImageIcon domino9 = new ImageIcon("9-1.jpg");
		  JLabel label9 = new JLabel(domino9);
		  ImageIcon domino10 = new ImageIcon("10-1.jpg");
		  JLabel label10 = new JLabel(domino10);
		  ImageIcon domino11 = new ImageIcon("11-1.jpg");
		  JLabel label11 = new JLabel(domino11);
		  ImageIcon domino12 = new ImageIcon("12-1.jpg");
		  JLabel label12 = new JLabel(domino12);
		  ImageIcon domino13 = new ImageIcon("13-1.jpg");
		  JLabel label13 = new JLabel(domino13);
		  ImageIcon domino14 = new ImageIcon("14-1.jpg");
		  JLabel label14 = new JLabel(domino14);
		  ImageIcon domino15 = new ImageIcon("15-1.jpg");
		  JLabel label15 = new JLabel(domino15);
		  ImageIcon domino16 = new ImageIcon("16-1.jpg");
		  JLabel label16 = new JLabel(domino16);
		  ImageIcon domino17 = new ImageIcon("17-1.jpg");
		  JLabel label17 = new JLabel(domino17);
		  ImageIcon domino18 = new ImageIcon("18-1.jpg");
		  JLabel label18 = new JLabel(domino18);
		  ImageIcon domino19 = new ImageIcon("19-1.jpg");
		  JLabel label19 = new JLabel(domino19);
		  ImageIcon domino20 = new ImageIcon("20-1.jpg");
		  JLabel label20 = new JLabel(domino20);
		  ImageIcon domino21 = new ImageIcon("21-1.jpg");
		  JLabel label21 = new JLabel(domino21);
		  ImageIcon domino22 = new ImageIcon("22-1.jpg");
		  JLabel label22 = new JLabel(domino22);
		  ImageIcon domino23 = new ImageIcon("23-1.jpg");
		  JLabel label23 = new JLabel(domino23);
		  ImageIcon domino24 = new ImageIcon("24-1.jpg");
		  JLabel label24 = new JLabel(domino24);
		  ImageIcon domino25 = new ImageIcon("25-1.jpg");
		  JLabel label25 = new JLabel(domino25);
		  ImageIcon domino26 = new ImageIcon("26-1.jpg");
		  JLabel label26 = new JLabel(domino26);
		  ImageIcon domino27 = new ImageIcon("27-1.jpg");
		  JLabel label27 = new JLabel(domino27);
		  ImageIcon domino28 = new ImageIcon("28-1.jpg");
		  JLabel label28 = new JLabel(domino28);
		  ImageIcon domino29 = new ImageIcon("29-1.jpg");
		  JLabel label29 = new JLabel(domino29);
		  ImageIcon domino30 = new ImageIcon("30-1.jpg");
		  JLabel label30 = new JLabel(domino30);
		  ImageIcon domino31 = new ImageIcon("31-1.jpg");
		  JLabel label31 = new JLabel(domino31);
		  ImageIcon domino32 = new ImageIcon("32-1.jpg");
		  JLabel label32 = new JLabel(domino32);
		  ImageIcon domino33 = new ImageIcon("33-1.jpg");
		  JLabel label33 = new JLabel(domino33);
		  ImageIcon domino34 = new ImageIcon("34-1.jpg");
		  JLabel label34 = new JLabel(domino34);
		  ImageIcon domino35 = new ImageIcon("35-1.jpg");
		  JLabel label35 = new JLabel(domino35);
		  ImageIcon domino36 = new ImageIcon("36-1.jpg");
		  JLabel label36 = new JLabel(domino36);
		  ImageIcon domino37 = new ImageIcon("37-1.jpg");
		  JLabel label37 = new JLabel(domino37);
		  ImageIcon domino38 = new ImageIcon("38-1.jpg");
		  JLabel label38 = new JLabel(domino38);
		  ImageIcon domino39 = new ImageIcon("39-1.jpg");
		  JLabel label39 = new JLabel(domino39);
		  ImageIcon domino40 = new ImageIcon("40-1.jpg");
		  JLabel label40 = new JLabel(domino40);
		  ImageIcon domino41 = new ImageIcon("41-1.jpg");
		  JLabel label41 = new JLabel(domino41);
		  ImageIcon domino42 = new ImageIcon("42-1.jpg");
		  JLabel label42 = new JLabel(domino42);
		  ImageIcon domino43 = new ImageIcon("43-1.jpg");
		  JLabel label43 = new JLabel(domino43);
		  ImageIcon domino44 = new ImageIcon("44-1.jpg");
		  JLabel label44 = new JLabel(domino44);
		  ImageIcon domino45 = new ImageIcon("45-1.jpg");
		  RotatedIcon rot45 = new RotatedIcon(domino45, 45.0);
		  JLabel label45 = new JLabel(domino45);
		  JLabel rotlabel45 = new JLabel(rot45);
		  ImageIcon domino46 = new ImageIcon("46-1.jpg");
		  JLabel label46 = new JLabel(domino46);
		  ImageIcon domino47 = new ImageIcon("47-1.jpg");
		  JLabel label47 = new JLabel(domino47);
		  ImageIcon domino48 = new ImageIcon("48-1.jpg");
		  JLabel label48 = new JLabel(domino48);	  
		  ImageIcon chateau = new ImageIcon("Castle.jpg");
		  JLabel label49 = new JLabel(chateau);
		  ImageIcon iconchoisie = new ImageIcon("45-1.jpg"); //A CHANGER EN FONCTION DU DOMINO
		  double angle = 0.0;
		  RotatedIcon roticon = new RotatedIcon(iconchoisie, angle);
	      JLabel rotdomino = new JLabel(roticon);
		  
		  frame.add(label);
		  label.add(label49);
		  label49.setBounds(282, 299, 132, 66);
		  frame.pack();
		  frame.setVisible(true);
		  
		  ///////////CLOSE ALL
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
		  
    //////////MOUSE CLICKING
	label.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			int click = e.getClickCount();
			
			
			////////////POWER OFF
			if(55<x && x<115 && 641<y && y<671) {
					int option = JOptionPane.showConfirmDialog(frame, "Voulez-vous arrêter la partie?",
							"Close Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
			}
			
			///////////END TURN
			if(578<x && x<645 && 638<y && y<673) {
				int option = JOptionPane.showConfirmDialog(frame, "Voulez-vous valider votre tour?",
						"Close Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					//FINIR TOUR
				}
		    }
			
			///////////PLACE DOMINO
			for (int i = 51; i < 645; i = i + 66) {
				for (int j = 35; j < 629 ; j = j + 66) {
					if(i<x && x<i+65 && j<y && y<j+65) {
						double angle = 0.0;
						int posx = 0;
						int posy = 0;
						if(click == 1) {
							angle = 0.0;
							posx = 132;
							posy = 66;
						} else if (click == 2) {
							angle = 90.0;
							posx = 66;
							posy = 132;
						} else if (click == 3) {
							angle = 180.0;
							posx = 132;
							posy = 66;
						} else if (click == 4) {
							angle = -90.0;
							posx = 66;
							posy = 132;
						}
						label.add(rotdomino);  
						rotdomino.setBounds(i, j, posx, posy);
						if(315<x && x<380 && 299<y && y<364) {  //CHANGER LES VALEURS EN FONCTION DU CHATEAU
							JOptionPane.showMessageDialog(frame, "Vous ne pouvez pas placer de domino sur le château!");
						}
					}
				}
			}
		}
	});	
	
	/////////BACKGROUND MUSIC	  
			File file = new File("theme.wav");
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
					} catch (IOException e) {
						e.printStackTrace();
					}
					if (nBytesRead >= 0) {
						sourceLine.write(abData, 0, nBytesRead);
					}
				}
				sourceLine.drain();
				sourceLine.close();
			} catch (UnsupportedAudioFileException | IOException e) {
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}	
	}
}


// Ok alors déjà bonjour comment va la famille toussa toussa.
// Ensuite, j'ai un problème avec la pivotation (pivotement?) des dominos:
// En gros je créé un domino avec un angle nul aux lignes 126-127, et je prévois de changer l'angle plus tard
// Aux lignes 177 à 196, je fais varier l'angle (et la position mais ca ca marche bien) en fonction du nombre de clicks
// C'est à dire que si tu cliques 2 fois par exemple ca va le faire pivoter 1 fois (si tu cliques 1 fois ca le place juste)
// MAIS vu que l'image dépendante de l'angle (initialisé à 0 à la ligne 125) est créée hors de la boucle, ben elle existe pas!
// Du coup ben je suis bien baisé, vu que l'angle reste à 0 mais la position change bien, ce qui donne un "bout" de domino
// Et au cas ou, je te préviens qu'essayer de recréer le domino dans les boucles if ne marche pas
// Enfin si ca marche mais vu que les 4 "if" comptent comme des boucles différentes, ca créé des images differentes (meme si c'est 4 fois la meme)
// Et du coup ca superpose les images (teste, tu verra bien, remplace juste les lignes 177 à 196 par ça:
/*                      if(click == 1) {
							angle = 0.0;
							posx = 132;
							posy = 66;
							RotatedIcon roticon = new RotatedIcon(iconchoisie, angle);
	      					JLabel rotdomino = new JLabel(roticon);
	      					label.add(rotdomino);  
						rotdomino.setBounds(i, j, posx, posy);
						} else if (click == 2) {
							angle = 90.0;
							posx = 66;
							posy = 132;
							RotatedIcon roticon = new RotatedIcon(iconchoisie, angle);
	      					JLabel rotdomino = new JLabel(roticon);
	      					label.add(rotdomino);  
						rotdomino.setBounds(i, j, posx, posy);
						} else if (click == 3) {
							angle = 180.0;
							posx = 132;
							posy = 66;
							RotatedIcon roticon = new RotatedIcon(iconchoisie, angle);
	      					JLabel rotdomino = new JLabel(roticon);
	      					label.add(rotdomino);  
						rotdomino.setBounds(i, j, posx, posy);
						} else if (click == 4) {
							angle = -90.0;
							posx = 66;
							posy = 132;
							RotatedIcon roticon = new RotatedIcon(iconchoisie, angle);
	      					JLabel rotdomino = new JLabel(roticon);
	      					label.add(rotdomino);  
						rotdomino.setBounds(i, j, posx, posy);
						}

 */





