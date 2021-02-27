/* @autor: Andra C. */
public class main {
    public static void main(String[] args) {
        /* declar un obiect de tipul Problem pentru ai putea accesa functionalitatile */
        Problem problema = new Problem();

        /* se initializeaza datele problemei */
        problema.makeProblem();

        /* se afiseaza datele problemei */
        System.out.println(problema);
        problema.printProblem();
    }
}
 
