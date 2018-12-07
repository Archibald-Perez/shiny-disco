import java.awt.Color;
import java.util.*;

public class PlayerManager {
    public static List<Player> players = new ArrayList<>();
    public static Byte nbKing = 4;

    public static boolean choix(){
        Scanner scan = new Scanner(System.in);
        System.out.println("y/n?");
        while (true){
            try{
                String yesno= scan.nextLine();
                if (yesno.equals("y") || yesno.equals("n")){
                    if(yesno.equals("yes")){
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

    public static Byte chooseNbPlayers(){ //la fonction qui récupère le nombre de joueur
        Scanner a = new Scanner(System.in);
        Byte n = null;
        while (true){
            try {
                n=a.nextByte();
                if (n > 4 || n<=0) {
                    System.out.println("Nombre de joueurs incorrect.");
                    continue;
                } else {
                    break;
                }
            }
            catch(Exception e) {
                System.out.println("Ce n'est pas un entier");
            }
        }
        return n;

    }

    public static void createPlayer(Byte nbPlayer){
        Scanner scan = new Scanner(System.in);
        for (Byte i = 1; i< nbPlayer+1; i++){
            String namePlayer = "Player" + i;
            System.out.println(namePlayer);
            System.out.println("Le joueur est-il un AI ?");
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
}
