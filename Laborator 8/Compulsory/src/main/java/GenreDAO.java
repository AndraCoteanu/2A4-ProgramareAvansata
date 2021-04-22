/**
 * <h3> Interfata GenreDAO </h3>
 * <p> Contine functii pentru inserarea / crearea de noua linie in tabelul genre si pentru a identifica un anumit tip de filme dupa nume. </p>
 */
public interface GenreDAO {
    void create(int id_genre, String nume);

    Genres findByName(String name);
}
