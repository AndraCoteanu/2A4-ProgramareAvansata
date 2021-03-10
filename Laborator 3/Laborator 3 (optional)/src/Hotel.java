import java.time.LocalTime;

/**
 * @author Andra C.
 *
 * <p> Clasa Hotel retine locatia, numele, numarul de persoane pe care le poate caza si pretul RON/persoana/noapte. </p>
 */
public class Hotel extends Location implements Visitable, Payable, Classifiable {
    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    private String name;
    private int capacity;
    private int price;
    private int stars;
    private LocalTime openingHour;
    private LocalTime closingHour;
    private long OpenDuration;

    /**
     * <p> Class constructor </p>
     *
     * @param street      numele strazii pe care se afla hotelul
     * @param name        numele hotelului
     * @param capacity    numarul de persoane care se pot caza intr-o noapte
     * @param price       pretul RON/persoana/noapte
     * @param stars       numarul de stele acordat hotelului
     * @param openingHour ora deschiderii (ora de la care se fac cazari)
     * @param closingHour ora inchiderii (ora pana cand se pot face cazari)
     */
    public Hotel(String street, String name, int capacity, int price, int stars, LocalTime openingHour, LocalTime closingHour) {
        super(street);
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.stars = stars;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    /**
     * <p> Class constructor </p>
     *
     * @param street   numele strazii pe care se afla hotelul
     * @param name     numele hotelului
     * @param capacity numarul de persoane care se pot caza intr-o noapte
     * @param price    pretul RON/persoana/noapte
     * @param stars    numarul de stele acordat hotelului
     */
    public Hotel(String street, String name, int capacity, int price, int stars) {
        super(street);
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.stars = stars;
        this.openingHour = LocalTime.of(11, 00, 00);
        this.closingHour = LocalTime.of(16, 00, 00);
    }

    /**
     * <p> Class constructor </p>
     *
     * @param street   numele strazii pe care se afla hotelul
     * @param name     numele hotelului
     * @param capacity numarul de persoane care se pot caza intr-o noapte
     * @param price    pretul RON/persoana/noapte
     */
    public Hotel(String street, String name, int capacity, int price) {
        super(street);
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.stars = 2;
        this.openingHour = LocalTime.of(11, 00, 00);
        this.closingHour = LocalTime.of(16, 00, 00);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public LocalTime getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public LocalTime getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    public long getOpenDuration() {
        return this.OpenDuration;
    }

    public void setOpenDuration() {
        OpenDuration = Visitable.getVisitingDuration(openingHour, closingHour);
    }

    @Override
    public int getRank() {
        return this.stars;
    }

    @Override
    public double getTicketPrice() {
        return this.price;
    }

    @Override
    public void setOpeningTime(LocalTime hour) {
        this.openingHour = hour;
    }

    @Override
    public void setClosingTime(LocalTime hour) {
        this.closingHour = hour;
    }

    @Override
    public LocalTime getOpeningTime() {
        return this.openingHour;
    }

    @Override
    public LocalTime getClosingTime() {
        return this.closingHour;
    }

    @Override
    public int compareTo(Location o) {
        if (this == o) return 1;
        return 0;
    }

    @Override
    public String toString() {

        return PURPLE + "Hotelul " + RESET + name + " se afla pe Strada " + street +
                ", are " + stars + " stele si poate caza " + capacity +
                " persoane pe noapte la pretul de " + price +
                " RON/pers/noapte. Programul pentru cazari este: " + openingHour +
                " - " + closingHour + '.' + "\n";
    }
}
