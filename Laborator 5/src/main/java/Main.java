import java.io.IOException;

/**
 * <p> Aplicatia principala unde se apeleaza functiile din clase. </p>
 */
public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();

    }
    private void testCreateSave() throws IOException {
        Catalog registru = new Catalog("1", "Ecran","c:/Users/andra/Desktop");
        Picture image = new Picture("img1","Pozica", "c:/Users/andra/Desktop");
        registru.add(image);

        CatalogUtil.save(registru);
    }
    private void testLoadView() throws InvalidCatalogException {
        Catalog NUL = new Catalog("NUL", "NUL", "NUL");
        Catalog registru = CatalogUtil.load("c:/Users/andra/Desktop");
        Item doc = registru.findById("img1");
        if (doc != NUL) {
            System.out.println(registru.findById("img1").getName());
        }
        CatalogUtil.view(registru);
    }
}
