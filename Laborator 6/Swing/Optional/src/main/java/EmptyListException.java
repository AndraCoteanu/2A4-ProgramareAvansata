/**
 * <p> Exceptia aruncata cand se apasa butonul de "undo" si lista de figuri este goala si nu se mai pot sterge elemente. </p>
 */
public class EmptyListException extends RuntimeException {
    public EmptyListException(String message) {
        super(message);
    }
}