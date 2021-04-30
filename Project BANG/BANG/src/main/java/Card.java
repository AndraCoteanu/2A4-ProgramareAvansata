/**
 * <h3> Card class </h3>
 * <p> This class deffines all that is needed to know about a card. </p>
 */
public class Card {
    private int id;
    private String name;
    private String value;
    private String symbol;
    private int user;
    /* user codes:
    0 - no one
    -1 - player that created the game
    1 - bot 1
    2 - bot 2
    ...
    */

    public Card(int id, String name, String value, String symbol) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.symbol = symbol;
        this.user = 0;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", symbol='" + symbol + '\'' +
                ", user=" + user +
                '}';
    }
}
