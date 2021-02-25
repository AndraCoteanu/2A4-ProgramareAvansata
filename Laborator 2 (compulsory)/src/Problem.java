/* @autor: Andra C. */
public class Problem {
    @Override
    public String toString() {
        return "Acestea sunt datele problemei:";
    }

    public Problem() {
    }

    public static void main(String[] args) {
        Problem problema = new Problem();
        Source S1 = new Source("S1", SourceType.FACTORY, 10);
        Source S2 = new Source("S2", SourceType.WAREHOUSE, 35);
        Source S3 = new Source("S3", SourceType.WAREHOUSE, 30);

        Destination D1 = new Destination("D1", 20);
        Destination D2 = new Destination("D2", 25);
        Destination D3 = new Destination("D3", 25);

        int[][] cost = new int[4][4];
        int i, j;

        /* se genereaza random o matrice de costuri, costul aflanduse in intervalul [1,9]*/
        /* se stiu cate surse si destinatii avem pentru declararea matricei de cost si generarea acesteia */
        for (i = 1; i <= 3; i++) {
            for (j = 1; j <= 3; j++) {
                cost[i][j] = (int) (Math.random() * 9 + 1);
            }
        }

        System.out.println(problema);

        /* se folosesc functiile toString din clasele Source si Destination pentru a afisa detaliile obiectelor create */
        System.out.println(S1);
        System.out.println(S2);
        System.out.println(S3);
        System.out.println(D1);
        System.out.println(D2);
        System.out.println(D3);

        /* se afiseaza matricea de cost */
        System.out.println("Costul de deplasare a unei unitati de la Sursa x la Destinatia y este:");
        System.out.println("   | D1 D2 D3");
        System.out.println("---+---------");
        for (i = 1; i <= 3; i++) {
            System.out.print("S" + i + " | ");
            for (j = 1; j <= 3; j++) {
                System.out.print(cost[i][j] + "  ");
            }
            System.out.println("");
        }
    }
}
