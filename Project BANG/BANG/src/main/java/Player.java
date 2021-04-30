import java.util.ArrayList;
import java.util.List;

/**
 * <h3> Player class </h3>
 * <p> This class stores anything that is needed to know about a player. </p>
 */
public class Player {
    private String name;
    private int life;
    private int maxLife;
    private int noCards;
    private int distanceSEE; //distanta la care vede
    private int distanceSEEN; //+distanta la care este vazut de alti jucatori ex: daca are mustang distanceSEEN = 1
    private Role role;
    private Character character;
    private List<Card> blue = new ArrayList<>();
    private List<Card> hand = new ArrayList<>();

    public Player(String name, int life, int maxLife, int noCards, Role role, Character character, List<Card> blue, List<Card> hand) {
        this.distanceSEE = 1;
        this.distanceSEEN = 0;
        this.name = name;
        this.life = life;
        this.maxLife = maxLife;
        this.noCards = noCards;
        this.role = role;
        this.character = character;
        this.blue = blue;
        this.hand = hand;
    }

    public int getDistanceSEE() {
        return distanceSEE;
    }

    public void setDistanceSEE(int distanceSEE) {
        this.distanceSEE = distanceSEE;
    }

    public int getDistanceSEEN() {
        return distanceSEEN;
    }

    public void setDistanceSEEN(int distanceSEEN) {
        this.distanceSEEN = distanceSEEN;
    }

    public List<Card> getBlue() {
        return blue;
    }

    public void setBlue(List<Card> blue) {
        this.blue = blue;
    }

    public int getNoCards() {
        return noCards;
    }

    public void setNoCards(int noCards) {
        this.noCards = noCards;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}
