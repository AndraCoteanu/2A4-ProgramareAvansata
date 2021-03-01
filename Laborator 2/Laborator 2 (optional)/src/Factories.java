/**
 * @author Andra C.
 * @version "%I%, %G%"
 * <p> Obiectele sursa pot fi de 2 tipuri, unul din ele este factory: </p>
 */
public class Factories extends Source {
    /**
     * <p> Class constructor se initializeaza obiecte de tip factory </p>
     *
     * @param name     numele sursei
     * @param capacity capacitatea obiectului de tip sursa
     */
    public Factories(String name, int capacity) {
        super(name, capacity);
    }

    /**
     * <p> Creaza un string cu informatii despre sursele de tip factory </p>
     *
     * @return stringul cu informatii
     */
    @Override
    public String toString() {
        return "Source {" +
                "Factory " + name +
                ", capacity=" + capacity +
                '}';
    }
}
