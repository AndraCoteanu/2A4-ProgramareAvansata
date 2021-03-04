import java.util.HashMap;
import java.util.Map;

/**
 * @author Andra C.
 *
 * <p> Clasa Location retine adresele tuturor tipurilor de locatii. </p>
 */
public abstract class Location implements Comparable<Location>{
    protected String address;
    protected Map<Location, Integer> cost = new HashMap<>();

    public Location() {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    @Override
    public String toString() {
        return "Location{" +
                "address='" + address + '\'' +
                '}';
    }
}
