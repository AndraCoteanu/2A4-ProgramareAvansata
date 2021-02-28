import java.util.Objects;

public class Source {
    //declararea variabilelor
    public String name;
    public int capacity;

    //settere si gettere
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //constructor
    public Source(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //toString()
    @Override
    public String toString() {
        return "Source {" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return capacity == source.capacity && name.equals(source.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity);
    }
}
