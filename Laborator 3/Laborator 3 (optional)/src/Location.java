import java.util.HashMap;
import java.util.Map;

/**
 * @author Andra C.
 *
 * <p> Clasa Location retine adresele tuturor tipurilor de locatii. </p>
 */
public abstract class Location implements Comparable<Location> {
    protected Location address; //adresa obiectului
    protected String address_name;  //numele acestei adrese, eg: v1
    protected String street;
    protected Map<Location, Integer> cost = new HashMap<>();

    public Location(String street) {
        this.street = street;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
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
