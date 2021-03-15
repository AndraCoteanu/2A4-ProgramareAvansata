import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p> 1. Declararea obiectelor din enunt </p>
 * <p> 2. In studentList adaug obiectele de tip stundets de la indicii 1-3 si la urma pe cel de pe indicele 0.
 * Se poate observa la afisare ca sunt sortate dupa nume. </p>
 * <p> 3. Afisarea TreeSet-ului. </p>
 * <p> 4. Afisarea map-urilor cu preferinte. </p>
 */
public class main {

    public static void main(String[] args) {
        /* 1. */
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i)).toArray(Student[]::new);
        var licee = IntStream.rangeClosed(0, 2).mapToObj(i -> new School("H" + i, 0)).toArray(School[]::new);

        licee[0].setCapacitate(1);
        licee[1].setCapacitate(2);
        licee[2].setCapacitate(2);

        List<School> preferinteS = new ArrayList<>();
        List<Student> preferinteH = new ArrayList<>();

        /* H0: */
        preferinteH.add(students[3]);
        preferinteH.add(students[0]);
        preferinteH.add(students[1]);
        preferinteH.add(students[2]);

        licee[0].setPreferinte(preferinteH);
        preferinteH.clear();

        /* H1: */
        preferinteH.add(students[0]);
        preferinteH.add(students[2]);
        preferinteH.add(students[1]);

        licee[1].setPreferinte(preferinteH);
        preferinteH.clear();

        /* H2: */
        preferinteH.add(students[0]);
        preferinteH.add(students[1]);
        preferinteH.add(students[3]);

        licee[2].setPreferinte(preferinteH);
        preferinteH.clear();

        /* S0: */
        preferinteS.add(licee[0]);
        preferinteS.add(licee[1]);
        preferinteS.add(licee[2]);

        students[0].setPreferinte(preferinteS);
        preferinteS.clear();

        /* S1: */
        preferinteS.add(licee[0]);
        preferinteS.add(licee[1]);
        preferinteS.add(licee[2]);

        students[1].setPreferinte(preferinteS);
        preferinteS.clear();

        /* S2: */
        preferinteS.add(licee[0]);
        preferinteS.add(licee[1]);

        students[2].setPreferinte(preferinteS);
        preferinteS.clear();

        /* S3: */
        preferinteS.add(licee[0]);
        preferinteS.add(licee[2]);

        students[3].setPreferinte(preferinteS);
        preferinteS.clear();

        System.out.println("Licee si studenti: ");
        for (int i = 0; i < licee.length; i++) {
            System.out.println(licee[i]);
        }
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
        /* 2. */
        System.out.println("");
        System.out.println("Lista de studenti sortata: ");
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i < students.length; i++) {
            studentList.add(students[i]);
        }
        studentList.add(students[0]);
        List<Student> newSortedList = studentList.stream().sorted(Comparator.comparing(Student::getNume)).collect(Collectors.toList());
        System.out.println(newSortedList);

        /* 3. */
        System.out.println("");
        System.out.println("TreeSet-ul scolilor: ");
        TreeSet<School> tsH = new TreeSet<School>();
        for (int i = 0; i < licee.length; i++) {
            tsH.add(licee[i]);
        }
        System.out.println(tsH);

        /* 4. */
        System.out.println("");
        System.out.println("Mapele studentilor si a liceelor: ");
        Map<Student, List> preferS = new HashMap<Student, List>();
        Map<School, List> preferH = new HashMap<School, List>();

        List<School> preferinteS0 = new ArrayList<>();
        preferinteS0.add(licee[0]);
        preferinteS0.add(licee[1]);
        preferinteS0.add(licee[2]);
        preferS.put(students[0], preferinteS0);

        List<School> preferinteS1 = new ArrayList<>();
        preferinteS1.add(licee[0]);
        preferinteS1.add(licee[1]);
        preferinteS1.add(licee[2]);
        preferS.put(students[0], preferinteS0);

        List<School> preferinteS2 = new ArrayList<>();
        preferinteS2.add(licee[0]);
        preferinteS2.add(licee[1]);

        List<School> preferinteS3 = new ArrayList<>();
        preferinteS3.add(licee[0]);
        preferinteS3.add(licee[2]);

        preferS.put(students[0],preferinteS0);
        preferS.put(students[1],preferinteS1);
        preferS.put(students[2],preferinteS2);
        preferS.put(students[3],preferinteS3);

        List<Student> preferinteH0 = new ArrayList<>();
        preferinteH0.add(students[3]);
        preferinteH0.add(students[0]);
        preferinteH0.add(students[1]);
        preferinteH0.add(students[2]);

        List<Student> preferinteH1 = new ArrayList<>();
        preferinteH1.add(students[0]);
        preferinteH1.add(students[2]);
        preferinteH1.add(students[1]);

        List<Student> preferinteH2 = new ArrayList<>();
        preferinteH2.add(students[0]);
        preferinteH2.add(students[1]);
        preferinteH2.add(students[3]);

        preferH.put(licee[0], preferinteH0);
        preferH.put(licee[1], preferinteH1);
        preferH.put(licee[2], preferinteH2);

        for (Map.Entry<Student, List> i : preferS.entrySet()) {
            System.out.print(i.getKey().getNume() + ":");
            System.out.println(i.getValue());
        }
        for (Map.Entry<School, List> i : preferH.entrySet()) {
            System.out.print(i.getKey().getNume() + ":");
            System.out.println(i.getValue());
        }

    }
}
