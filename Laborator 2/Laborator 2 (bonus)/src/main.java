/**
 * @author Andra C.
 * @version "%I%, %G%"
 * <p> Programul principal unde se afla metoda main si se acceseaza toate clasele </p>
 */
public class main {
    private static final long MEGABYTE = 1024L * 1024L;

    /**
     * <p> Transforma dintr-o unitate de masura in alta </p>
     *
     * @param bytes numarul care trebuie transformat
     * @return echivalentul parametrului bytes in megabytes
     */
    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    /**
     * <p> Se creaza o problema, se afiseaza datele acesteia si apoi o rezolvare de cost minim </p>
     * <p> Dupa calcularea si afisarii unei solutii se va afisa memoria ocupata si timpul de rulare al programului </p>
     * <p> Pentru aflarea informatiilor despre program am consultat <a href="url">https://www.vogella.com/tutorials/JavaPerformance/article.html</a> </p>
     *
     * @param args valorile declarate la linia de comanda folosite in interiorul programului (nu sunt folosite astfel de valori)
     */
    public static void main(String[] args) {
        /* momentul la care programul a inceput sa ruleze */
        long startTime = System.currentTimeMillis();

        /* se solicita o solutie la o problema de transport */
        Solution solutie = new Solution();
        System.out.println("");
        solutie.solutia();

        /* Se calculeaza memoria ocupata de program */
        System.out.println("");
        System.out.println("Date despre program: ");
        // primeste runtime-ul programului
        Runtime runtime = Runtime.getRuntime();
        // garbage collector - elibereaz adresele de memorie unde se afla variabile si parametri care nu mai sunt folositi
        runtime.gc();
        // Memoria folosita este:
        long memory;
        memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memoria folosita: " + memory + " bytes.");
        System.out.println("Memoria folosita: " + bytesToMegabytes(memory) + "MB.");

        /* se calculeaza timpul de rulare */
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Programul a rulat timp de " + elapsedTime + " milisecunde.");
    }
}

