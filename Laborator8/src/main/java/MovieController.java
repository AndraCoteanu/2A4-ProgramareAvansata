import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieController implements MovieDAO{

    public MovieController() {

    }

    @Override
    public void create(int id_movie, String nume, int year, int duration, double score) {
        try {
            Database database = Database.getInstance();
            PreparedStatement statement = database.connection.prepareStatement("insert into movies (id_movie, title, release_date, duration, score) values(?, ?, ?, ?, ?);");
            statement.setInt(1, id_movie);
            statement.setString(2, nume);
            statement.setInt(3, year);
            statement.setInt(4, duration);
            statement.setDouble(5, score);
            int rowsInserted;
            rowsInserted = statement.executeUpdate();
            System.out.println(String.format("Number of rows inserted %d", rowsInserted));
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

    @Override
    public Movie findByName(String name) throws NullPointerException {
        Movie lastMovie = null;
        try {
            Database database = Database.getInstance();
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
