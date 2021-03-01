import java.util.Objects;

/**
 * @author Andra C.
 * @version "%I%, %G%"
 * <p> Stocheaza destinatiile unde trebuie trimise unitatile </p>
 * <p> Fiecare destinatie are un demand/commodity de unitati </p>
 */
public class Destination {
    public String name;
    public int commodity; // = demand

    /**
     * <p> Class getter pentru commodity </p>
     *
     * @return demandul unui obiect/destinatii
     */
    public int getCommodity() {
        return commodity;
    }

    /**
     * <p> Class setter pentru commodity </p>
     *
     * @param commodity initializeaza demandul unui obiect
     */
    public void setCommodity(int commodity) {
        this.commodity = commodity;
    }

    /**
     * <p> Class getter pentru nume </p>
     *
     * @return numele destinatiei
     */
    public String getName() {
        return name;
    }

    /**
     * <p> Class setter pentru nume </p>
     *
     * @param name initializeaza numele destinatiei
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p> Class constructor </p>
     *
     * @param name      initializeaza numele destinatiei
     * @param commodity initializeaza demandul destinatiei
     */
    public Destination(String name, int commodity) {
        this.name = name;
        this.commodity = commodity;
    }

    /**
     * <p> Creaza un string cu informatii despre destinatie </p>
     *
     * @return stringul cu informatii
     */
    //toString()
    @Override
    public String toString() {
        return "Destination {" +
                "name='" + name + '\'' +
                ", commodity=" + commodity +
                '}';
    }

    /**
     * <p> Metoda equals verifica un obiect sa nu fie declarat a doua oara </p>
     *
     * @param o obiectul de tip destinatie care este verificat sa nu mai fie declarat anterior
     * @return true/false in functie de obiectul o: daca a mai fost sau nu declarat
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return commodity == that.commodity && name.equals(that.name);
    }

    /**
     * <p> Metoda hash </p>
     *
     * @return valoarea functiei hash aplicata pe obiect
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, commodity);
    }
}
