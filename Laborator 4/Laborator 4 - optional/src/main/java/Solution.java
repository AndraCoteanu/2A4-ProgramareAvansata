import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Clasa solution descrie o solutie a unei probleme. </p>
 */
public class Solution {
    private List<Pair<Student, School>> matching = new ArrayList<>();

    public Solution() {
    }

    /**
     * <p> Metoda va adauga o pereche Student-Liceu in lista cu repartizarile.</p>
     *
     * @param S studentul
     * @param H liceul
     */
    public void addMatching(Student S, School H) {
        Pair<Student, School> pair = new Pair<>(S, H);
        matching.add(pair);
    }

    @Override
    public String toString() {
        String solutie = "Distribution: [";
        solutie += "(";
        solutie += matching.get(0).getKey().getNume();
        solutie += ":";
        solutie += matching.get(0).getValue().getNume();
        solutie += ")";
        for (int index = 1; index < matching.size(); index++) {
            solutie += ", (";
            solutie += matching.get(index).getKey().getNume();
            solutie += ":";
            solutie += matching.get(index).getValue().getNume();
            solutie += ")";
        }
        solutie += "]";
        return solutie;
    }
}
