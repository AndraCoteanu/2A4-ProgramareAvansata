import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Catalog registru = new Catalog("1", "Ecran", "c:/Users/andra/Desktop");
        Picture image = new Picture("img1", "Pozica", "c:/Users/andra/Desktop");
        registru.add(image);
        registru.list();
        CatalogUtil.save(registru);
        Scanner scanner = new Scanner(System.in);
        List<CatalogShellCommand> comenzi = new ArrayList<>();
        CatalogUtilShell.ExitCommand exit = new CatalogUtilShell.ExitCommand("exit");
        CatalogUtilShell input = new CatalogUtilShell(registru, scanner, 0, comenzi, exit);
        input.initialize();
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
