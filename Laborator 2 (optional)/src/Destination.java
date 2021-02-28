import java.util.Objects;

public class Destination {
    //declararea variabilelor
    public String name;
    public int commodity; //=demand

    //settere si gettere
    public int getCommodity() {
        return commodity;
    }

    public void setCommodity(int commodity) {
        this.commodity = commodity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //constructor
    public Destination(String name, int commodity) {
        this.name = name;
        this.commodity = commodity;
    }

    //toString()
    @Override
    public String toString() {
        return "Destination {" +
                "name='" + name + '\'' +
                ", commodity=" + commodity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return commodity == that.commodity && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, commodity);
    }
}
