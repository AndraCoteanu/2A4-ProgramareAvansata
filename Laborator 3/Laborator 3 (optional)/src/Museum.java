import java.time.LocalTime;

/**
 * @author Andra C.
 *
 * <p> Clasa Museun retine adresa, numele si pretul unui bilet al muzeelor. </p>
 */
public class Museum extends Location implements Visitable, Payable {
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";

    private String name;
    private int nrExpozitii;
    private int price;
    private LocalTime openingHour;
    private LocalTime closingHour;
    private long OpenDuration;

    /**
     * <p> Class constructor </p>
     *
     * @param street      strada pe care se afla muzeul
     * @param name        numele muzeului
     * @param nrExpozitii cate expozitii are muzeul deschise
     * @param price       pretul unui bilet la o expozitie
     * @param openingHour ora deschiderii
     * @param closingHour ora inchiderii
     */
    public Museum(String street, String name, int nrExpozitii, int price, LocalTime openingHour, LocalTime closingHour) {
        super(street);
        this.name = name;
        this.nrExpozitii = nrExpozitii;
        this.price = price;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    /**
     * <p> Class constructor </p>
     *
     * @param street      strada pe care se afla muzeul
     * @param name        numele muzeului
     * @param nrExpozitii cate expozitii are muzeul deschise
     * @param price       pretul unui bilet la o expozitie
     */
    public Museum(String street, String name, int nrExpozitii, int price) {
        super(street);
        this.name = name;
        this.nrExpozitii = nrExpozitii;
        this.price = price;
        this.openingHour = LocalTime.of(10, 00, 00);
        this.closingHour = LocalTime.of(16, 00, 00);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrExpozitii() {
        return nrExpozitii;
    }

    public void setNrExpozitii(int nrExpozitii) {
        this.nrExpozitii = nrExpozitii;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
    public double getTicketPrice() {
        return price;
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
        return YELLOW + "Muzeul " + RESET + name + " de pe Strada " + street +
                " are " + nrExpozitii + " expozitii, fiecare la pretul de " + price +
                " RON. Programul de functionare este: " + openingHour + " - " +
                closingHour + "." + "\n";
    }
}
