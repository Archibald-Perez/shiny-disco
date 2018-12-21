import java.awt.Color;
import java.util.*;

public class PlayerManager {
    private static List<Player> players = new ArrayList<>();
    private static Byte nbKing = 4;
    private static Byte nbPlayer = 4;
    private static List<Integer> sequence = new ArrayList<Integer>();
    private static List<Integer> nextSequence = sequence;
    private static List<Domino> dominoSequence = new ArrayList<Domino>();


    public static void main(String[] args){
        initialSequence();
        for (int i = 0; i< sequence.size(); i++){
            System.out.println(sequence.get(i));
        }
    }

    public static boolean choix(){
        Scanner scan = new Scanner(System.in);
        System.out.println("y/n?");
        while (true){
            try{
                String yesno= scan.nextLine();
                if (yesno.equals("y") || yesno.equals("n")){
                    if(yesno.equals("y")){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    System.out.println("Ce n'est pas la réponse attendue");
                    continue;
                }
            }
            catch(Exception e) {
                System.out.println("Ce n'est pas la réponse attendue");
            }
        }

    }

    public static void chooseNbPlayers(){ //la fonction qui récupère le nombre de joueur
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le nombre de joueurs");
        Byte n = null;
        while (true){
            try {
                n=scan.nextByte();
                if (n > 4 || n<=0) {
                    System.out.println("Nombre de joueurs incorrect.");
                    continue;
                } else {
                    break;
                }
            }
            catch(Exception e) {
                System.out.println("Nombre incorrect.");
                scan.nextLine();
            }
        }
        if (n==3) {
        	nbKing = 3;
        }
        nbPlayer = n;

    }

    public static void createPlayers(){
        Scanner scan = new Scanner(System.in);
        for (Byte i = 1; i< nbPlayer+1; i++){
            String namePlayer = "Player" + i;
            System.out.println(namePlayer);
            System.out.println("Le joueur est-il une IA ?");
            Boolean choixAI = choix();
            if (!choixAI) {
                System.out.println("Veuillez saisir votre nom");
                namePlayer = scan.nextLine();
            }
            Color color;
            switch (i){
                case 1 :
                    color = Color.pink;
                    break;
                case 2 :
                    color = Color.cyan;
                    break;
                case 3 :
                    color = Color.magenta;
                    break;
                default:
                    color = Color.green;
                    break;
            }
            Player player = new Player(namePlayer, choixAI, color );
            players.add(player);
        }
    }

    public static void initialSequence(){
        Random rand = new Random();
            for (Byte i = 0; i<nbKing; i++){
                int num = rand.nextInt(nbKing);
                if (sequence.contains(num)){
                    while(sequence.contains(num)){
                        int n = rand.nextInt(nbKing);
                        num = n;

                    }
                }
                sequence.add(num);
            }
            if(nbPlayer == 2) {
            	for(int i = 2; i<4; i++) {
                	int index = sequence.indexOf(i);
                	sequence.remove(index);
                	sequence.add(index, i-2);
            	}
            }

    }
    public static List<Player> getPlayers() {
    	return players;
    }
    public static int getNbPlayer() {
    	return nbPlayer;
    }
    public static int getNbKing() {
    	return nbKing;
    }
    public static List<Integer> getSequence() {
    	return sequence;
    }
    public static List<Domino> getDominoSequence() {
    	return dominoSequence;
    }
}
