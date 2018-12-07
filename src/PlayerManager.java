import java.io.*;
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
            String player = "Player" + i;
            System.out.println("Player"+i);
            System.out.println("AI ?");

        }

}
}
