import java.io.*;
import java.util.*;
public class PlayerManager {
    public static List<Player> players = new ArrayList<>();

    public static boolean choix(){
        Scanner scan = new Scanner(System.in);
        System.out.println("y/n?");
        while (true){
            try{
                String yesno= scan.nextLine();
                if (yesno.equals("y") || yesno.equals("n")){
                    break;
                }
                else {
                    System.out.println("Ce n'est pas la réponse attendue");
                    continue;
                }
            }
            catch(Exception e) {
                System.out.println();
            }
        }

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
