import java.awt.Color;
import java.util.*;

public class PlayerManager {
    public static List<Player> players = new ArrayList<>();
    public static Byte nbKing = 4;
    public static Byte nbPlayer = 4;
    public static List<Integer> sequenceInitial = new ArrayList<Integer>();
    public  static List<Integer> sequence = new ArrayList<Integer>();

    public static void main(String[] args){
        initialSequence();
        for (int i = 0; i< sequenceInitial.size(); i++){
            System.out.println(sequenceInitial.get(i));
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
        if (nbPlayer>2){
            for (Byte i = 0; i<nbKing; i++){
                int num = rand.nextInt(nbKing);
                if (sequenceInitial.contains(num)){
                    while(sequenceInitial.contains(num)){
                        int n = rand.nextInt(nbKing);
                        num = n;

                    }
                }
                sequenceInitial.add(num);
            }
        }
        else {

        }

    }
}
