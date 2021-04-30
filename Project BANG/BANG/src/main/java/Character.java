public class Character {
    private int id;
    private int lifePoints;
    private String nume;
    private int user;
    /* user codes:
    0 - no one
    -1 - player that created the game
    1 - bot 1
    2 - bot 2
    ...
    */

    public Character(int id, int lifePoints, String nume) {
        this.id = id;
        this.lifePoints = lifePoints;
        this.nume = nume;
        this.user = 0;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
