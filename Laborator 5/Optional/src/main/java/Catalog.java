import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andra C.
 *
 * <p> Catalogul de iteme multimedia. </p>
 */
public class Catalog extends Item implements Serializable {
    private List<Item> items = new ArrayList<>();

    /**
     * <p> Class constructor. </p>
     *
     * @param id       id-ul itemului din catalog
     * @param name     numele itemului din catalog
     * @param location path-ul sau link-ul itemului
     */
    public Catalog(String id, String name, String location) {
        super(id, name, location);
    }

    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        return items.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public void list() {
        System.out.println("Catalog: " + this.getId() + "  " + this.getName() + "  " + this.getLocation());
        System.out.println("Items:");
        for (Item item : items) {
            System.out.println(item.getId() + "   " + item.getName() + "   " + item.getLocation());
        }
    }

}