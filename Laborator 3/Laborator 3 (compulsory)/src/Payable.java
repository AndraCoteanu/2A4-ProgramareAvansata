/**
 * @author Andra C.
 *
 * <p> In interfata Payable avem metoda care primeste pretul unui bilet de la un obiect. </p>
 */
public interface Payable {
    /**
     * <p> Primeste pretul biletului. </p>
     *
     * @return pretul biletului daca acesta exista; 0 altfel
     */
    double getTicketPrice();
}
