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
     *
     * @param args lista de parametri data in consola
     */
    public static void main(String[] args) {
        /* 1. */
        City Iasi = new City("Iasi");

        /* 2. */
        Hotel v1 = new Hotel("Unirea", 50, 100);
        v1.address = "v1";
        Iasi.locatii.add(v1);
        Museum v2 = new Museum("Natura", 30);
        v2.address = "v2";
        Iasi.locatii.add(v2);
        Museum v3 = new Museum("Istorie", 50);
        v3.address = "v3";
        Iasi.locatii.add(v3);
        Church v4 = new Church("Sfanta Maria", "ortodoxa");
        v4.address = "v4";
        Iasi.locatii.add(v4);
        Church v5 = new Church("Sfantul Iosif", "catolica");
        v5.address = "v5";
        Iasi.locatii.add(v5);
        Restaurant v6 = new Restaurant("Mammamia", "fast food");
        v6.address = "v6";
        Iasi.locatii.add(v6);

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
            System.out.println(Iasi.locatii.get(i).address + ": " + Iasi.locatii.get(i));
        }

        for (i = 0; i < Iasi.locatii.size(); i++) {
            for (Location id : Iasi.locatii.get(i).cost.keySet()) {
                System.out.println(Iasi.locatii.get(i).address + " -> " + id.address + " are costul " + Iasi.locatii.get(i).cost.get(id));
            }
        }

    }
}
