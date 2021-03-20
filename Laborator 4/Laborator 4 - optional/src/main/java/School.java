import java.util.ArrayList;
import java.util.List;

public class School implements Comparable {
    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";

    private String nume;
    private int capacitate;
    private List<Student> preferinte = new ArrayList<>();

    public School(String nume, int capacitate) {
        this.nume = nume;
        this.capacitate = capacitate;
    }

    public List<Student> getPreferinte() {
        return preferinte;
    }

    public void setPreferinte(List<Student> preferinte) {
        this.preferinte.addAll(preferinte);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
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
        return CYAN + "School" + RESET +
                "{ nume='" + nume + '\'' +
                ", capacitate=" + capacitate + ", " +
                text + "}";
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}