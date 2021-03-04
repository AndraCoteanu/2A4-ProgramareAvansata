import java.time.LocalTime;

/**
 * @author Andra C.
 *
 * <p> Clasa Hotel retine locatia, numele, numarul de persoane pe care le poate caza si pretul RON/persoana/noapte. </p>
 */
public class Hotel extends Location implements Visitable, Payable, Classifiable {
    public String name;
    public int capacity;
    public int price;

    /**
     * <p> Class constructor. </p>
     *
     * @param name     numele hotelului
     * @param capacity numarul de persoane care pot fi cazate intr-o noapte
     * @param price    pretul cazarii RON/persoana/noapte
     */
    public Hotel(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    /**
     * <p> Primeste numele unui obiect si il returneaza. </p>
     *
     * @return numele hotelului
     */
    public String getName() {
        return name;
    }

    /**
     * <p> Initializeaza numele unui obiect. </p>
     *
     * @param name numele hotelului
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p> Primeste capacitatea unui obiect si o returneaza. </p>
     *
     * @return capacitatea hotelului
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * <p> Initializeaza capacitatea unui obiect. </p>
     *
     * @param capacity capacitatea hotelului
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * <p> Primeste pretul unui obiect si il returneaza. </p>
     *
     * @return pretul de cazare la hotel
     */
    public int getPrice() {
        return price;
    }

    /**
     * <p> Initializeaza pretul unui obiect. </p>
     *
     * @param price pretul de cazare la hotel
     */
    public void setPrice(int price) {
        this.price = price;
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
}
