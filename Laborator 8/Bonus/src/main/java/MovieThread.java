import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h3> Clasa MovieThread </h3>
 * <p> Implementeaza functii pe care le vor rula threadurile din connection pool. </p>
 * <p> Functionalitatea implementata este sa se caute in baza de date toate detaliile despre filmul cu id-ul 2. </p>
 */
public class MovieThread implements Runnable{
    private int id;

    public MovieThread(int id) {
        this.id = id;
    }

    private void displayMovie(int id) throws SQLException, PropertyVetoException {
        Connection connection = null;
        String sql = "select * from movies where id_movie = ?";
        PreparedStatement statement = null;
        try {
            ComboPooledDataSource filme = ConnectionPool.getInstance().getComboPooledDataSource();
            connection = filme.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println(" id: " + rs.getInt(1) + "\n movie: " + rs.getString(2) + "\n duration: " + rs.getInt(4) + " minutes\n score: " + rs.getInt(5));
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void run() {
        try {
            this.displayMovie(2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
}