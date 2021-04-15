public class Movie {
    int id_Movie;
    String title;
    int release_date;
    int duration;
    double score;

    public Movie(int id_Movie, String title, int release_date, int duration, double score) {
        this.id_Movie = id_Movie;
        this.title = title;
        this.release_date = release_date;
        this.duration = duration;
        this.score = score;
    }

    public int getId_Movie() {
        return id_Movie;
    }

    public void setId_Movie(int id_Movie) {
        this.id_Movie = id_Movie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelease_date() {
        return release_date;
    }

    public void setRelease_date(int release_date) {
        this.release_date = release_date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
