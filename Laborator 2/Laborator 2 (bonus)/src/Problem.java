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

    public int MATRIX_DIM = (int) (Math.random() * 9 + 2); //"macro" pentru matrice
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

        for (int i = 0; i < MATRIX_DIM; i++) {
            int type = (int) (Math.random() * 3 + 1);
            int capacitate = (int) (Math.random() * 55 + 5);
            String numeSursa = "S";
            int id = i + 1;
            numeSursa = numeSursa.concat(String.valueOf(id));
            if (type == 1) {
                Factories S1 = new Factories(numeSursa, capacitate);
                /* voi pune obiectele declarate mai sus in 2 liste pentru a fi mai organizate */
                surse.add(S1);
            } else {
                Warehouse S1 = new Warehouse(numeSursa, capacitate);
                surse.add(S1);
            }
            int comoditate = (int) (Math.random() * 55 + 5);
            String numeDestinaatie = "D";
            numeDestinaatie = numeDestinaatie.concat(String.valueOf(id));
            Destination D1 = new Destination(numeDestinaatie, comoditate);
            destinatii.add(D1);
        }


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
        int i, j;
        for (i = 0; i < MATRIX_DIM; i++) {
            System.out.println(surse.get(i));
        }
        for (i = 0; i < MATRIX_DIM; i++) {
            System.out.println(destinatii.get(i));
        }


        /* se afiseaza matricea de cost */
        System.out.println("Costul de deplasare a unei unitati de la Sursa x la Destinatia y este:");
        System.out.print("   | ");
        for (j = 0; j < MATRIX_DIM; j++) {
            int id = j + 1;
            System.out.print("D" + id + " ");
        }
        System.out.println("");
        System.out.print("---+");
        for (j = 0; j < MATRIX_DIM; j++) {
            System.out.print("---");
        }
        System.out.println("");
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
