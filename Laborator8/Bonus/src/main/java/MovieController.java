
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void allInfo() {
        try {
            PreparedStatement statement = database.connection.prepareStatement("select M.title, M.release_date, M.duration, M.score, G.nume from movies M, genres G, film F where M.id_movie = F.id_movie and G.id_genre = F.id_genre order by M.title");
            ResultSet resultSet = statement.executeQuery();
            String lastMovie = "null";
            while (resultSet.next()) {
                if(lastMovie.equals(resultSet.getString(1)))
                {
                    System.out.print(", " + resultSet.getString(5));
                } else {
                    PreparedStatement stmtDir = database.connection.prepareStatement("select P.prenume, P.nume from movies M, directors D, person P where M.id_movie = D.id_movie and D.id_pers = P.id_pers and M.title = ?");
                    stmtDir.setString(1, resultSet.getString(1));
                    ResultSet rsDir = stmtDir.executeQuery();

                    List<String> actori = new ArrayList<>();
                    PreparedStatement stmtActor = database.connection.prepareStatement("select P.prenume, P.nume from movies M, actors A, person P where M.id_movie = A.id_movie and A.id_pers = P.id_pers and M.title = ?");
                    stmtActor.setString(1, resultSet.getString(1));
                    ResultSet rsActor = stmtActor.executeQuery();
                    int i = 0;
                    while(rsActor.next()) {
                        actori.addAll(Collections.singleton(rsActor.getString(2) + " " + rsActor.getString(1)));
                        i++;
                    }
                    System.out.println();
                    System.out.println("Movie:" + resultSet.getString(1));
                    System.out.println("      - score: " + resultSet.getDouble(4));
                    rsDir.next();
                    System.out.println("      - director: " + rsDir.getString(2) + " " + rsDir.getString(1));
                    System.out.println("      - released: " + resultSet.getString(2));
                    System.out.println("      - " + resultSet.getInt(3) + " minutes");
                    System.out.print("      - actors: " + actori.get(0));
                    for(int j=1; j<actori.size();j++) {
                        System.out.print(", " + actori.get(j));
                    }
                    System.out.println();
                    System.out.print("      - genre: " + resultSet.getString(5));
                }
                lastMovie = resultSet.getString(1);
            }
            System.out.println();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }
}
