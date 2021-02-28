public class Warehouse extends Source {

    public Warehouse(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public String toString() {
        return "Source {" +
                "Warehouse " + name +
                ", capacity=" + capacity +
                '}';
    }
}
