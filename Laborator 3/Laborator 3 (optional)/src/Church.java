import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andra. C
 *
 * <p> Clasa Church memoreaza numele, religia, adresa si programul de functionare al unei biserici. </p>
 */
public class Church extends Location implements Visitable {
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";

    private String name;
    private String religion;
    private LocalTime openingHour;
    private LocalTime closingHour;
    private long OpenDuration;

    /**
     * <p> Class constructor </p>
     *
     * @param street      strada pe care se afla biserica
     * @param name        numele bisericii
     * @param religion    religia pe care o reprezinta
     * @param openingHour ora la care se deschide
     * @param closingHour ora la care se inchide
     */
    public Church(String street, String name, String religion, LocalTime openingHour, LocalTime closingHour) {
        super(street);
        this.name = name;
        this.religion = religion;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    /**
     * <p> Class constructor </p>
     * <p> Daca la instantierea obiectului nu este specificata ora, atunci aceasta va fi by default 6:00 - 18:00. </p>
     *
     * @param street   strada pe care se afla biserica
     * @param name     numele bisericii
     * @param religion religia pe care o reprezinta
     */
    public Church(String street, String name, String religion) {
        super(street);
        this.name = name;
        this.religion = religion;
        this.openingHour = LocalTime.of(6, 00, 00);
        this.closingHour = LocalTime.of(18, 00, 00);
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
        return BLUE + "Biserica " + RESET + religion + " " +
                name + " se afla pe strada " + street +
                " si este deschisa intre " + openingHour +
                " - " + closingHour + "." + "\n";
    }
}
