import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database{
    private static Database instance;
    private final String user = "student";
    private final String pass = "STUDENT";
    private final String link = "jdbc:oracle:thin:@localhost:1521:XE";
    public Connection connection;
    private Database(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(link, user, pass);
        }
        catch (ClassNotFoundException | SQLException exc){
            System.out.println(exc);
        }
    }
    public static Database getInstance(){
        if(instance == null)
            instance = new Database();
        return instance;
    }
}
