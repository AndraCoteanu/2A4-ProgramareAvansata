import java.util.ArrayList;
import java.util.List;

/**
 * @author Andra C.
 * @version "%I%, %G%"
 * <p> Clasa Problem instantiaza un obiect cu informatii despre o problema de transport </p>
 */
public class Problem {
    /**
     * <p> Creaza un string cu informatii </p>
     *
     * @return stringul
     */
    @Override
    public String toString() {
        return "Acestea sunt datele problemei:";
    }

    /**
     * <p> Class empty constructor </p>
     */
    public Problem() {
    }

    public int MATRIX_DIM = 3; //"macro" pentru matrice

    public List<Source> surse = new ArrayList<>();
    public List<Destination> destinatii = new ArrayList<>();
    public int[][] cost = new int[MATRIX_DIM][MATRIX_DIM];

    /* metoda makeProblem initializeaza un obiect de tip Problem cu instantele unei probleme ca cea din enunt */

    /**
     * <p> Declara si initializeaza obiecte sursa si destinatie. </p>
     * <p> Le adauga in listele aferente pentru o mai buna organizare a datelor </p>
     * <p> Se genereaza random o matrice de cost pentru trasportul de la o sursa la destinatie </p>
     */
    public void makeProblem() {
        /* 3 obiecte de tipul sursa folosind valorile din enunt */
        Factories S1 = new Factories("S1", 10);
        Warehouse S2 = new Warehouse("S2", 35);
        Warehouse S3 = new Warehouse("S3", 30);

        /* 3 obiecte de tipul destinatie folosint valorile din enunt */
        Destination D1 = new Destination("D1", 20);
        Destination D2 = new Destination("D2", 25);
        Destination D3 = new Destination("D3", 25);

        /* voi pune obiectele declarate mai sus in 2 liste pentru a fi mai organizate */
        surse.add(S1);
        surse.add(S2);
        surse.add(S3);
        destinatii.add(D1);
        destinatii.add(D2);
        destinatii.add(D3);

        int i, j;
        /* se genereaza random o matrice de costuri, costul aflanduse in intervalul [1,9]*/
        /* se stiu cate surse si destinatii avem pentru declararea matricei de cost si generarea acesteia */
        for (i = 0; i < MATRIX_DIM; i++) {
            for (j = 0; j < MATRIX_DIM; j++) {
                cost[i][j] = (int) (Math.random() * 9 + 1);
            }
        }
    }

    /**
     * <p> Metoda afiseaza datele problemei dupa ce au fost create </p>
     */
    public void printProblem() {
        /* accesez elementele de pe pozitiile 0,1,2 din ambele liste;
           acestea apeleaza mai apoi functiile toString din clasele aferente pentru a face print-ul mai eficient */
        System.out.println(surse.get(0));
        System.out.println(surse.get(1));
        System.out.println(surse.get(2));
        System.out.println(destinatii.get(0));
        System.out.println(destinatii.get(1));
        System.out.println(destinatii.get(2));

        /* se afiseaza matricea de cost */
        int i, j;
        System.out.println("Costul de deplasare a unei unitati de la Sursa x la Destinatia y este:");
        System.out.println("   | D1 D2 D3");
        System.out.println("---+---------");
        for (i = 0; i < MATRIX_DIM; i++) {
            int id = i + 1;
            System.out.print("S" + id + " | ");
            for (j = 0; j < MATRIX_DIM; j++) {
                System.out.print(cost[i][j] + "  ");
            }
            System.out.println("");
        }
    }
}
