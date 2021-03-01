/**
 * @author Andra C.
 * @version "%I%, %G%"
 * <p> Programul principal unde se afla meoda main si se acceseaza toate clasele </p>
 */
public class main {
    /**
     * <p> Se creaza o problema, se afiseaza datele acesteia si apoi o rezolvare de cost minim </p>
     *
     * @param args valorile declarate la linia de comanda folosite in interiorul programului (nu sunt folosite astfel de valori)
     */
    public static void main(String[] args) {
        /* se solicita o solutie la o problema de transport */
        Solution solutie = new Solution();
        System.out.println("");
        System.out.println(solutie);
        solutie.solutia();
    }
}

