public class Role {
    private int id;
    private String nume;
    private int user;
    /* user codes:
    0 - no one
    -1 - player that created the game
    1 - bot 1
    2 - bot 2
    ...
    */

    public Role(int id, String nume, int user) {
        this.id = id;
        this.nume = nume;
        this.user = user;
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", user=" + user +
                '}';
    }
}
