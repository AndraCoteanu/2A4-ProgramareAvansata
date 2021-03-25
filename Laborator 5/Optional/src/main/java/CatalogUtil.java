import java.awt.*;
import java.io.*;

/**
 * <p> Clasa care implementeaza functii utile pentru obiectele din catalog. </p>
 */
public class CatalogUtil {
    Catalog catalog;

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public static void save(Catalog catalog)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getLocation()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (Catalog) ois.readObject();
        } catch (ClassNotFoundException | IOException exception) {
            throw new InvalidCatalogException(exception);
        }

    }

    public static void view(Catalog registru) {
        Desktop desktop = Desktop.getDesktop();


    }
}
