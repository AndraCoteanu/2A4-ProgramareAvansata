/**
 * @author Andra C.
 * @version "%I%, %G%"
 * <p> Obiectele sursa pot fi de 2 tipuri, unul din ele este warehouse: </p>
 */
public class Warehouse extends Source {

    /**
     * <p> Class constructor pentru sursele de tip warehouse </p>
     *
     * @param name     numele sursei de tip warehouse
     * @param capacity capacitatea sursei de ip warehouse
     */
    public Warehouse(String name, int capacity) {
        super(name, capacity);
    }

    /**
     * <p> Creaza un string cu informatii despre sursele warehouse </p>
     *
     * @return stringul cu date
     */
    @Override
    public String toString() {
        return "Source {" +
                "Warehouse " + name +
                ", capacity=" + capacity +
                '}';
    }
}
