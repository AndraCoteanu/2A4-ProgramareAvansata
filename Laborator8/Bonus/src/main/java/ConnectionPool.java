import com.mchange.v2.c3p0.*;

/**
 * <h3> Clasa ConnectionPool </h3>
 * <h3> Creaza o conexiune la baza de date cu ajutorul c3p0 </h3>
 */
public class ConnectionPool {
    private static ConnectionPool single_instance = null;
    private ComboPooledDataSource comboPooledDataSource;

    private ConnectionPool() {
        this.comboPooledDataSource = new ComboPooledDataSource();
        this.comboPooledDataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE" );
        this.comboPooledDataSource.setUser("student");
        this.comboPooledDataSource.setPassword("STUDENT");
        this.comboPooledDataSource.setMinPoolSize(5);
        this.comboPooledDataSource.setAcquireIncrement(5);
        this.comboPooledDataSource.setMinPoolSize(30);
    }

    public static ConnectionPool getInstance() {
        if(single_instance == null)
            single_instance = new ConnectionPool();
        return single_instance;
    }

    public ComboPooledDataSource getComboPooledDataSource() {
        return this.comboPooledDataSource;
    }

    public void close() {
        this.comboPooledDataSource.close();
    }

}