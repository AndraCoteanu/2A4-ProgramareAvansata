import java.time.LocalTime;

/**
 * @author Andra C.
 *
 * <p> Clasa Museun retine adresa, numele si pretul unui bilet al muzeelor. </p>
 */
public class Museum extends Location implements Visitable, Payable {
    public String name;
    public int price;

    /**
     * <p> Class constructor. </p>
     *
     * @param name  numele museului
     * @param price pretul biletului
     */
    public Museum(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * <p> Primeste numele muzeului. </p>
     *
     * @return numele muzeului
     */
    public String getName() {
        return name;
    }

    /**
     * <p> Initiaizeaza numele muzeului. </p>
     *
     * @param name numele muzeului
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p> Primeste pretul unei intrari la muzeu. </p>
     *
     * @return pretul
     */
    public int getPrice() {
        return price;
    }

    /**
     * <p> Initializeaza pretul unei intrari la muzeu. </p>
     *
     * @param price pretul unei intrari
     */
    public void setPrice(int price) {
        this.price = price;
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
        return "Museum{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
