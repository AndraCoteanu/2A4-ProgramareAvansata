import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andra. C
 *
 * <p> Clasa Church memoreaza numele, religia si adresa unei biserici. </p>
 */
public class Church extends Location implements Visitable, Classifiable{
    public String name;
    public String religion;

    public Church(String name, String religion) {
        this.name = name;
        this.religion = religion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    @Override
    public int getRank() {
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
        return "Church{" +
                "name='" + name + '\'' +
                ", religion='" + religion + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
