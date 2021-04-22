/**
 * <h3> Interfata MovieDAO </h3>
 * <p> Contine functii pentru inserarea / crearea de noua linie in tabelul movie si pentru a identifica un anumit film dupa nume. </p>
 */
public interface MovieDAO {
    void create(int id_movie, String nume, int year, int duration, double score);

    Movie findByName(String name);
}
