public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception exe) {
        super("Invalid catalog file.", exe);
    }
}
