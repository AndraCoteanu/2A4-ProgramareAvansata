import java.util.Objects;

/**
 * @author Andra C.
 * @version "%I%, %G%"
 * <p> Stocheaza sursele de unde se fac livrari spre destinatii. </p>
 * <p> Fiecare sursa are o capacity/commodity/supply; adica cate unitati poate livra acea sursa. </p>
 */
public abstract class Source {
    public String name;
    public int capacity;

    /**
     * <p> Class getter pentru nume: returneaza numele unui obiect de tipul sursa. </p>
     *
     * @return name - numele obiectului
     */
    public String getName() {
        return name;
    }

    /**
     * <p> Class setter pentru nume. </p>
     *
     * @param name initializeaza numele unui obiect de tip sursa
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p> Class constructor </p>
     *
     * @param name     initializeaza numele unui obiect de tip sursa
     * @param capacity initializeaza capacitatea unui obiect de tip sursa
     */
    public Source(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * <p> Class getter pentru capacitate </p>
     *
     * @return capacity - capacitatea obiectului
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * <p> Class setter pentru capacitate </p>
     *
     * @param capacity initializeaza capacitatea unui obiect de tipul sursa
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * <p> Creaza un string cu informatii despre un obiect </p>
     *
     * @return string-ul cu datele despre obiectul de tip sursa
     */
    @Override
    public String toString() {
        return "Source {" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    /**
     * <p> Metoda equals verifica un obiect sa nu fie declarat a doua oara </p>
     *
     * @param o obiectul de tip sursa care este verificat sa nu mai fie declarat anterior
     * @return true/false in functie de obiectul o: daca a mai fost sau nu declarat
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return capacity == source.capacity && name.equals(source.name);
    }

    /**
     * <p> Metoda hash </p>
     *
     * @return valoarea functiei hash aplicata pe obiect
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, capacity);
    }
}