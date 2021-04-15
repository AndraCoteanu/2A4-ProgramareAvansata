public interface GenreDAO {
    void create(int id_genre, String nume);
    Genres findByName(String name);
}
