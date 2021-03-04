import java.util.ArrayList;
import java.util.List;

/**
 * @author Andra C.
 *
 * <p> Clasa City tine evidenta oraselor si in ce tara se afla acestea. </p>
 */
public class City {
    public String name;
    private List<Location> locatii = new ArrayList<>();

    /**
     * <p> Class constructor. </p>
     * <p> Initializeaza numele orasului la declararea unui obiect de acest tip. </p>
     *
     * @param name numele orasului
     */
    public City(String name) {
        this.name = name;
    }

    /**
     * <p> Primeste numele orasului unui obiect de tip City. </p>
     *
     * @return numele orasului
     */
    public String getName() {
        return name;
    }

    /**
     * <p> Initializeaza numele unui obiect de tip City. </p>
     *
     * @param name numele orasului
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p> In lista de locatii dintr-un oras se mai poate adauga inca un hotel, museu, restaurant etc. </p>
     *
     * @param node obiectul adaugat in lista
     */
    public void addLocation(Location node) {
        locatii.add(node);
    }

}
