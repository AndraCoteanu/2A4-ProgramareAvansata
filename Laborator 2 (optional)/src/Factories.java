public class Factories extends Source {

    public Factories(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public String toString() {
        return "Source {" +
                "Factory " + name +
                ", capacity=" + capacity +
                '}';
    }
}
