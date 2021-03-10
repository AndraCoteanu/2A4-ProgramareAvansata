import java.util.ArrayList;
import java.util.List;

/**
 * @author Andra C.
 *
 * <p> Clasa main va contine programul principal. </p>
 * <p> Toate obiectele instantiate vor avea numele "vx", unde x este indicele incepand de la 0. </p>
 */
public class main {
    /**
     * <p> 1. Initializez un oras. </p>
     * <p> 2. Adaug locatii pe "harta" orasului si le memorez adresa in lista acestuia. </p>
     * <p> 3. In mapa pun costurile deplasarilor de la o locatie la alta. </p>
     * <p> 4. Afisez informatiile cunoscute despre locatii si mai apoi despre costul deplasarii intre acestea. </p>
     * <p> 5. Verifica daca avem in Iasi locatii vizitabile unde nu trebuie sa plateasca. </p>
     * <p> 6. Se calculeaza cat timp este deschis Restaurantul v6. </p>
     * <p> 7. Initializam lista de preferinte a Calatorului_1 si le afisam. </p>
     *
     * @param args lista de parametri data in consola
     */

    public static void main(String[] args) {
        /* 1. */
        City Iasi = new City("Iasi");

        /* 2. */
        Hotel v1 = new Hotel("Unirii", "Unirea", 100, 80, 4);
        v1.address = v1;
        v1.address_name = "v1";
        Iasi.locatii.add(v1);
        Museum v2 = new Museum("Iancu Bacalu", "Natura", 5, 30);
        v2.address = v2;
        v2.address_name = "v2";
        Iasi.locatii.add(v2);
        Museum v3 = new Museum("Garii", "Istorie", 10, 50);
        v3.address = v3;
        v3.address_name = "v3";
        Iasi.locatii.add(v3);
        Church v4 = new Church("Carol I", "Sfanta Maria", "ortodoxa");
        v4.address = v4;
        v4.address_name = "v4";
        Iasi.locatii.add(v4);
        Church v5 = new Church("Palas", "Sfantul Iosif", "catolica");
        v5.address = v5;
        v5.address_name = "v5";
        Iasi.locatii.add(v5);
        Restaurant v6 = new Restaurant("Mammamia", "fast-food", "Unirii");
        v6.address = v6;
        v6.address_name = "v6";
        v6.setOpenDuration();
        Iasi.locatii.add(v6);
        Park v7 = new Park("Garii", "de copii", 18);
        v7.address = v7;
        v7.address_name = "v7";
        Iasi.locatii.add(v7);

        /* 3. */
        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);
        v3.setCost(v2, 20);
        v3.setCost(v4, 20);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v4, 30);
        v5.setCost(v6, 20);

        /* 4. */
        int i;
        for (i = 0; i < Iasi.locatii.size(); i++) {
            System.out.println(Iasi.locatii.get(i).address_name + ":" + Iasi.locatii.get(i).address);
        }

        for (i = 0; i < Iasi.locatii.size(); i++) {
            for (Location id : Iasi.locatii.get(i).cost.keySet()) {
                System.out.println(Iasi.locatii.get(i).address_name + " -> " + id.address_name + " are costul " + Iasi.locatii.get(i).cost.get(id));
            }
        }

        /* 5. */
        Iasi.Visit();
        System.out.println("");

        /* 6. */
        long ora, minute;
        ora = v6.getOpenDuration() / 60;
        minute = v6.getOpenDuration() % 60;
        System.out.println(" Restaurantul " + v6.getName() + " este deschis " + ora + " ore si " + minute + " minute.");

        /* 7. */
        TravelPlan calator_1 = new TravelPlan();
        calator_1.setOras(Iasi);
        List<Location> preferinte = new ArrayList<>();
        preferinte.add(v1);
        preferinte.add(v4);
        preferinte.add(v7);
        preferinte.add(v2);
        preferinte.add(v5);
        calator_1.setPrefer(preferinte);
        System.out.println(calator_1.getOras());
        System.out.println(calator_1.getPrefer());
    }
}
