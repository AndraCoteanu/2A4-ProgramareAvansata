/**
 * <p> Main Class face vizibil frame-ul configurat in clasa MainFrame. </p>
 */
public class Main {
    public static void main(String[] args) {
        try{
            new MainFrame().setVisible(true);
        }
        catch (EmptyListException ex)
        {
            String message = "Empty list";
        }
    }
}
