import java.util.ArrayList;
import java.util.List;

public class Student {
    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    private String nume;
    private List<School> preferinte = new ArrayList<>();

    public Student(String nume) {
        this.nume = nume;
    }

    public List<School> getPreferinte() {
        return preferinte;
    }

    public void setPreferinte(List<School> preferinte) {
        this.preferinte.addAll(preferinte);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        String text = ("Preferinte ");
        text = text + this.nume + ": ";
        int marime = this.getPreferinte().size();
        for (int i = 0; i < marime; i++) {
            text = text + this.getPreferinte().get(i).getNume();
            if (marime >= 0 && i < marime - 1) {
                text = text + ", ";
            }
        }
        return PURPLE + "Student" + RESET +
                "{ nume='" + nume + '\'' + ", " +
                text + "}";
    }
}
