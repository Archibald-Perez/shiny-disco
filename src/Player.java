import java.awt.*;

public class Player {
    public String name;
    public Boolean isAI;
    public Color color;

    public Player(String name, Boolean isAI, Color color){
        this.name = name;
        this.isAI=isAI;
        this.color= color;
    }

    public static void sequence(){

    }
    @Override
    public String toString() {
        return "Joueur "+name+" {" +
                ", est une IA = " + isAI +
                ", couleur = " + color +
                '}';
    }
}

