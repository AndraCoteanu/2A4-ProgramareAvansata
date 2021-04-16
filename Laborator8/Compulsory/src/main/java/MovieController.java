
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h3> Clasa MovieController </h3>
 * <p> Implementeaza functiile din interfata MovieDAO </p>
 * <p> Se coneteaza la baza de date cu ajutorul unui obiect de tip Database. </p>
 */
public class MovieController implements MovieDAO {

    Database database;

    public MovieController(Database database) {
        this.database = database;
    }

    @Override
    public void create(int id_movie, String nume, int year, int duration, double score) {
        try {
            PreparedStatement statement = database.connection.prepareStatement("insert into movies (id_movie, title, release_date, duration, score) values(?, ?, to_date(?, 'yyyy'), ?, ?)");
            statement.setInt(1, id_movie);
            statement.setString(2, nume);
            statement.setInt(3, year);
            statement.setInt(4, duration);
            statement.setDouble(5, score);
            statement.execute();
            System.out.println("New row inserted");
            statement.close();
            //database.connection.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

    @Override
    public Movie findByName(String name) throws NullPointerException {
        Movie lastMovie = null;
        try {
            PreparedStatement statement = database.connection.prepareStatement("select * from movie where title=?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lastMovie = new Movie(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5));
                System.out.println(lastMovie);
            }
            return lastMovie;
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        return lastMovie;
    }
}
