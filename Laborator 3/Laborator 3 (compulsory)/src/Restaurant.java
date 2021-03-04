import java.rmi.registry.LocateRegistry;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andra C.
 *
 * <p> Clasa Restaurant retine numele, tipul de mancare servita si adresa localului </p>
 */
public class Restaurant extends Location implements Visitable, Payable, Classifiable {
    public String name;
    public String type;

    public Restaurant(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getRank() {
        return 0;
    }

    @Override
    public double getTicketPrice() {
        return 0;
    }

    @Override
    public LocalTime getOpeningTime() {
        return null;
    }

    @Override
    public LocalTime getClosingTime() {
        return null;
    }

    @Override
    public int compareTo(Location o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
