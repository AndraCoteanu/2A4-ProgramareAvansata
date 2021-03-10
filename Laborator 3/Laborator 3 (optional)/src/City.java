import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Andra C.
 *
 * <p> Clasa City tine evidenta oraselor si in ce tara se afla acestea. </p>
 */
public class City {
    public String name;
    protected List<Location> locatii = new ArrayList<>();

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

    /**
     * <p> Functia Visit verifica daca un obiect este vizitable dar nu si payable </p>
     */
    public void Visit() {
        int i;
        List<Location> sortare = new ArrayList<>();
        for (i = 0; i < this.locatii.size(); i++) {
            if (this.locatii.get(i).address instanceof Visitable) {
                if (!(this.locatii.get(i).address instanceof Payable)) {
                    sortare.add(this.locatii.get(i).address);
                }
            }
        }
        System.out.println("");
        System.out.println(" Locatiile vizitabile, unde nu se plateste, ordonate dupa ora deschiderii sunt: ");
        sortare.sort(Comparator.comparing(Location::toString));
        for (i = 0; i < sortare.size(); i++) {
            System.out.println(sortare.get(i));
        }
    }
}
