import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Random;

public class Player {
    public String name;
    public Boolean isAI;
    public Color color;
    public Byte ordre;
    public static List<Integer> sequence = new ArrayList<Integer>();

    public Player(String name, Boolean isAI, Color color, Byte ordre){
        this.name = name;
        this.isAI=isAI;
        this.color= color;
        this.ordre = ordre;
    }

    public static void sequenceInitial(){
        Random rand = new Random();
        Byte nbPlayer = PlayerManager.nbPlayer;
        for (int i = 1; i<nbPlayer+1; i++){
            sequence.add(i);

        }
        for (Byte i = 0; i<nbPlayer; i++){
            int sequence = rand.nextInt(nbPlayer)+1;
        }

    }
    @Override
    public String toString() {
        return "Joueur "+name+" {" +
                "est une IA = " + isAI +
                ", couleur = " + color +
                '}';
    }
}

