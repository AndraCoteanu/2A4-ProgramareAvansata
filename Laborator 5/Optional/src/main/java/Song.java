/**
 * <p> Clasa pentru itemi specifici: melodii. </p>
 */
public class Song extends Item {

    private String type;

    public Song(String id, String name, String location) {
        super(id, name, location);
    }

    public Song(String id, String name, String location, String type) {
        super(id, name, location);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType() {
        this.type = "song";
    }
}
