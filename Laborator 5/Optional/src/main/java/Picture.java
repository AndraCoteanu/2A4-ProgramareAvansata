/**
 * <p> Clasa specifica pentru itemii de tipul poza. </p>
 */
public class Picture extends Item {

    private String type;

    public Picture(String id, String name, String location) {
        super(id, name, location);
    }

    public Picture(String id, String name, String location, String type) {
        super(id, name, location);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType() {
        this.type = "img";
    }
}
