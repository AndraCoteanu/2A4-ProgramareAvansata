/**
 * @author Andra C.
 *
 * <p> In interfata Classifiable avem o metoda care va primi mereu rank-ul intr-un clasament. </p>
 * <p> Exemplu de clasament: Top 10 hotele din Iasi. </p>
 */
public interface Classifiable {
    /**
     * <p> Metoda primeste locul intr-un clasament al unui obiect si il returneaza. </p>
     *
     * @return numarul in clasament
     */
    int getRank();
}
