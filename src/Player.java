import java.awt.*;

public class Player {
    private String name;
    private Boolean isAI;
    private Color color;


    public Player(String name, Boolean isAI, Color color){
        this.name = name;
        this.isAI=isAI;
        this.color= color;

    }

    @Override
    public String toString() {
        return "Joueur "+name+" {" +
                "est une IA = " + isAI +
                ", couleur = " + color +
                '}';
    }
}

