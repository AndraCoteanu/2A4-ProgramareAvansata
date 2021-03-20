import java.util.*;

/**
 * <p> Clasa Problem descrie o problema ca cea din enunt. </p>
 */
public class Problem {
    private Map<Student, List<School>> preferinteStudent = new HashMap<>();
    private Map<School, List<Student>> preferinteLiceu = new HashMap<>();

    private Solution solutie = new Solution();

    public Problem() {
    }

    public void addToStudenti(Student S, List<School> preferinteS) {
        preferinteStudent.put(S, preferinteS);
    }

    public void addToLicee(School H, List<Student> preferinteH) {
        preferinteLiceu.put(H, preferinteH);
    }

    /**
     * <p> Metoda makeSolution calculeaza repartizarea studentilor. </p>
     * <p> Se ordoneaza descrescator studentii in functie de nota din examen. </p>
     * <p> Se parcurge lista ordonata si pentru fiecare student se parcurge lista de preferinte. </p>
     * <p> La primul liceu disponibil va fi repartizat studentul. </p>
     */
    public void makeSolution() {
        List<Student> studenti = new ArrayList<>();
        studenti.addAll(preferinteStudent.keySet());
        TreeSet<School> licee = new TreeSet<>();

        Collections.sort(studenti, Collections.reverseOrder(Comparator.comparing(Student::getExamScore)));

        for (Student S : studenti) {
            licee.addAll(preferinteStudent.get(S));
            for (School H : licee) {
                if (H.getCapacitate() > 0) {
                    solutie.addMatching(S, H);
                    H.setCapacitate(H.getCapacitate() - 1);
                }
                break;
            }
        }

        System.out.println(solutie);
    }
}
