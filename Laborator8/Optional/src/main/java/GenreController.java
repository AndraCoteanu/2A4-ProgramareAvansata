import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h3> Clasa GenreController </h3>
 * <p> Implementeaza functiile din interfata GenreDAO </p>
 * <p> Se coneteaza la baza de date cu ajutorul unui obiect de tip Database. </p>
 */
public class GenreController implements GenreDAO {

    Database database;

    public GenreController(Database database) {
        this.database = database;
    }

    @Override
    public void create(int id_genre, String nume) {
        try {
            PreparedStatement statement = database.connection.prepareStatement("insert into genres (id_genre, nume) values(?, ?)");
            statement.setInt(1, id_genre);
            statement.setString(2, nume);
            statement.execute();
            System.out.println("New row inserted");
            statement.close();
            //database.connection.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

    @Override
    public void findByName(String name) throws NullPointerException {
        try {
            PreparedStatement statement = database.connection.prepareStatement("select M.title from movies M, genres G, film F where M.id_movie = F.id_movie and G.id_genre = F.id_genre and G.nume = ? order by M.title");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }
}
