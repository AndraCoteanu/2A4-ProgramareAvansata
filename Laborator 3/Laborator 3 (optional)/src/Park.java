import java.time.LocalTime;

/**
 * @author Andra C.
 *
 * <p> Clasa Park retine numele si adresa parcurilor. </p>
 */
public class Park extends Location implements Visitable {
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    private String name;
    private int varstaMax; //varsta maxima pentru a accesa parcul
    private LocalTime openingHour;
    private LocalTime closingHour;
    private long OpenDuration;

    /**
     * <p> Class constructor </p>
     *
     * @param street      numele strazii
     * @param name        numele parcului
     * @param varstaMax   varsta maxima pentru a accesa parcul
     * @param openingHour ora deschiderii
     * @param closingHour ora inchiderii
     */
    public Park(String street, String name, int varstaMax, LocalTime openingHour, LocalTime closingHour) {
        super(street);
        this.name = name;
        this.varstaMax = varstaMax;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    /**
     * <p> Class constructor </p>
     *
     * @param street    numele strazii
     * @param name      numele parcului
     * @param varstaMax varsta maxima pentru a accesa parcul
     */
    public Park(String street, String name, int varstaMax) {
        super(street);
        this.name = name;
        this.varstaMax = varstaMax;
        this.openingHour = LocalTime.of(5, 00, 00);
        this.closingHour = LocalTime.of(23, 00, 00);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVarstaMax() {
        return varstaMax;
    }

    public void setVarstaMax(int varstaMax) {
        this.varstaMax = varstaMax;
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

    public long getOpenDuration() {
        return this.OpenDuration;
    }

    public void setOpenDuration() {
        OpenDuration = Visitable.getVisitingDuration(openingHour, closingHour);
    }

    @Override
    public LocalTime getOpeningTime() {
        return this.openingHour;
    }

    @Override
    public LocalTime getClosingTime() {
        return this.closingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
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
    public int compareTo(Location o) {
        if (this == o) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return GREEN + "Parcul " + RESET + name + " de pe strada " + street + " se adreseaza persoanelor pana in " +
                varstaMax + " ani si functioneaza intre orele " + openingHour + " - " + closingHour + "." + "\n";
    }
}
