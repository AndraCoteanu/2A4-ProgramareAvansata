import java.time.LocalTime;

/**
 * @author Andra C.
 *
 * <p> In interfata Visitable avem metode ce primesc ora deschiderii si ora inchiderii oricarei locatii care este vizitabila cu un program. </p>
 */
public interface Visitable {
    /**
     * <p> Primeste ora deschiderii. </p>
     *
     * @return ora deschiderii daca aceasta exista; null altfel
     */
    LocalTime getOpeningTime();

    /**
     * <p> Primeste ora inchiderii. </p>
     *
     * @return ora inchiderii daca aceasta exista; null altfel
     */
    LocalTime getClosingTime();
}
