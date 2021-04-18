import oracle.jdbc.datasource.impl.OracleDataSource;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * <h3> Clasa Database </h3>
 * <p> Deschide conexiunea cu baza noastra de date. </p>
 * <p> Contine informatii care nu ar trebui sa fie open source, ex: credentialele pentru conectarea la baza de date.</p>
 */
public class Database {
    private static Database instance;
    public Connection connection;

    /**
     * <p> Constructorul este privat deoarece contine credentialele pentru conecatrea la baza de date.</p>
     *
     * @throws SQLException          atunci cand ceva nu s-a comportat normal in baza de date.
     * @throws FileNotFoundException atunci cand nu gaseste scriptul lab8.sql pentru construirea tabelelor din abza noastra de date.
     */
    private Database() throws SQLException, FileNotFoundException {
        // Create DataSource and connect to the local database
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@localhost:1521:XE");
        ods.setUser("student");
        ods.setPassword("STUDENT");

        connection = ods.getConnection();
        ScriptRunner sr = new ScriptRunner(connection);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader("E:\\[FII] Facultate\\[JAVA] Programare Avansata\\Lab8\\src\\main\\resources\\lab8.sql"));
        //Running the script
        sr.runScript(reader);
    }

    /**
     * <p> Functia verifica daca exista sau nu conexiunea. Daca nu exista o va stabili prin apelarea unui obiect nou de tipul Database</p>
     *
     * @return starea conexiunii
     * @throws SQLException          atuci cand baza noastra de date are un comportament neobisnuit.
     * @throws FileNotFoundException atunci cand nu gaseste fisierul lab8.sql pentru crearea tabelelor
     */
    public static Database getInstance() throws SQLException, FileNotFoundException {
        if (instance == null)
            instance = new Database();
        return instance;
    }
}
