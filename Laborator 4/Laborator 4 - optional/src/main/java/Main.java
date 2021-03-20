import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <h> Compulsory: </h>
 * <p> 1. Declararea obiectelor din enunt </p>
 * <p> 2. In studentList adaug obiectele de tip stundets de la indicii 1-3 si la urma pe cel de pe indicele 0.
 * Se poate observa la afisare ca sunt sortate dupa nume. </p>
 * <p> 3. Afisarea TreeSet-ului. </p>
 * <p> 4. Afisarea map-urilor cu preferinte. </p>
 *
 * <h> Optional: </h>
 * <p> 5. Studenti care au in lista de preferinte o mini-lista de licee. </p>
 * <p> 6. Liceele care au un anumit student ca top preference. </p>
 * <p> 7. Genereaza nume fake random pentru studenti si licee. </p>
 * <p> 8. Se repartizeaza studentii la licee in baza notei de la examen si a preferintelor. </p>
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("COMPULSORY:");
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

        preferS.put(students[0], preferinteS0);
        preferS.put(students[1], preferinteS1);
        preferS.put(students[2], preferinteS2);
        preferS.put(students[3], preferinteS3);

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


        /* 5. */
        System.out.println("\nOPTIONAL:");
        List<School> target = Arrays.asList(licee[0], licee[2]);
        List<Student> result = studentList.stream().filter(std -> preferS.get(std).containsAll(target)).collect(Collectors.toList());
        System.out.print("Students who find acceptable schools H0 and H2: ");
        for (int index = 0; index < result.size(); index++) {
            System.out.print(result.get(index).getNume() + " ");
        }

        /* 6. */
        System.out.println("\nSchools that have student S3 as their top preference: ");
        tsH.stream().filter(std -> preferH.get(std).contains(students[3])).forEach(System.out::println);

        /* 7. */
        System.out.println("\nFake student and school:");
        Faker faker = new Faker();
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton

        Student S1 = new Student(firstName);
        School H1 = new School(lastName, 3);

        System.out.println(S1);
        System.out.println(H1);

        /* 8. */
        students[0].setExamScore(70);
        students[1].setExamScore(96);
        students[2].setExamScore(83);
        students[3].setExamScore(64);

        Problem repartizare = new Problem();
        repartizare.addToLicee(licee[0], licee[0].getPreferinte());
        repartizare.addToLicee(licee[1], licee[1].getPreferinte());
        repartizare.addToLicee(licee[2], licee[2].getPreferinte());
        repartizare.addToStudenti(students[0], students[0].getPreferinte());
        repartizare.addToStudenti(students[1], students[1].getPreferinte());
        repartizare.addToStudenti(students[2], students[2].getPreferinte());
        repartizare.addToStudenti(students[3], students[3].getPreferinte());

        System.out.println("");
        repartizare.makeSolution();
    }
}
