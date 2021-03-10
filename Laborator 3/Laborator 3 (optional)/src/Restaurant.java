import java.time.LocalTime;

/**
 * @author Andra C.
 *
 * <p> Clasa Restaurant retine numele, tipul de mancare servita, numarul de stele,
 * pretul in medie, intervalul orar de functionare si adresa localului. </p>
 */
public class Restaurant extends Location implements Visitable, Payable, Classifiable {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    private long OpenDuration;
    private String name;
    private String type;
    private int stars;
    private int avgPrice; //pretul mancarii in medie
    private LocalTime openingHour;
    private LocalTime closingHour;

    /**
     * <p> Class constructor </p>
     *
     * @param name        numele restaurantului
     * @param type        tipul de mancare servita
     * @param stars       clasificarea - numarul de stele ale restaurantului
     * @param avgPrice    pretul in medie al mancarii servite
     * @param openingHour ora deschiderii
     * @param closingHour ore inchiderii
     */
    public Restaurant(String street, String name, String type, int stars, int avgPrice, LocalTime openingHour, LocalTime closingHour) {
        super(street);
        this.name = name;
        this.type = type;
        this.stars = stars;
        this.avgPrice = avgPrice;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    /**
     * <p> Class constructor </p>
     * <p> Daca la instantierea obiectului nu se da programul de vizitare acesta va fi initializat by default cu intervalul 09-20. </p>
     *
     * @param name     numele restaurantului
     * @param type     tipul de mancare servita
     * @param stars    clasificarea - numarul de stele ale restaurantului
     * @param avgPrice pretul in medie al mancarii servite
     */
    public Restaurant(String street, String name, String type, int stars, int avgPrice) {
        super(street);
        this.name = name;
        this.type = type;
        this.stars = stars;
        this.avgPrice = avgPrice;
        this.openingHour = LocalTime.of(9, 00, 00);
        this.closingHour = LocalTime.of(22, 00, 00);
    }

    /**
     * <p> Class constructor </p>
     * <p> Daca la instantierea obiectului nu se da programul de vizitare acesta va fi initializat by default cu intervalul 09-20. </p>
     * <p> Daca pretul nu este mentionat la instantierea unui obiect, atunci acesta va fi dat by default ca fiind 15. (valoarea in RONi). </p>
     *
     * @param name  numele restaurantului
     * @param type  tipul de mancare servita
     * @param stars clasificarea - numarul de stele ale restaurantului
     */
    public Restaurant(String street, String name, String type, int stars) {
        super(street);
        this.name = name;
        this.type = type;
        this.stars = stars;
        this.avgPrice = 15;
        this.openingHour = LocalTime.of(9, 00, 00);
        this.closingHour = LocalTime.of(22, 00, 00);
    }

    /**
     * <p> Class constructor </p>
     * <p> Daca la instantierea obiectului nu se da programul de vizitare acesta va fi initializat by default cu intervalul 09-20. </p>
     * <p> Daca pretul nu este mentionat la instantierea unui obiect, atunci acesta va fi dat by default ca fiind 15. (valoarea in RONi). </p>
     * <p> Daca nu se mentioneaza numarul de stele al restaurantului, acesta va fi by default 3. </p>
     *
     * @param name numele restaurantului
     * @param type tipul de mancare servita
     */
    public Restaurant(String name, String type, String street) {
        super(street);
        this.name = name;
        this.type = type;
        this.street = street;
        this.stars = 3;
        this.avgPrice = 15;
        this.setDefaultProgram();
    }

    public long getOpenDuration() {
        return this.OpenDuration;
    }

    public void setOpenDuration() {
        OpenDuration = Visitable.getVisitingDuration(openingHour, closingHour);
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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(int avgPrice) {
        this.avgPrice = avgPrice;
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

    @Override
    public int getRank() {
        return this.stars;
    }

    @Override
    public double getTicketPrice() {
        return this.avgPrice;
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
        return RED + "Restaurantul " + RESET + name + " de " + stars + " stele " +
                " se afla pe Strada " + street +
                " si serveste mancare " + type +
                ". Pretul in medie este " + avgPrice +
                " RON. Programul de functionare este " + openingHour +
                " - " + closingHour +
                '.' + "\n";
    }
}
