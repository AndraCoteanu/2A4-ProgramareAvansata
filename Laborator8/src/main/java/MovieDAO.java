public interface MovieDAO {
    void create(int id_movie, String nume, int year, int duration, double score);
    Movie findByName(String name);
}
