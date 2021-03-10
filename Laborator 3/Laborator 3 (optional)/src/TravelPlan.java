import java.util.ArrayList;
import java.util.List;

/**
 * @author Andra C.
 *
 * <p> In clasa Travel plan se va retine orasul vizitat si o lista cu preferinte. </p>
 * <p> Un calator poate insera maxim 5 locatii pe care vrea sa le viziteze. </p>
 */
public class TravelPlan {
    private City oras;
    List<Location> prefer = new ArrayList<>();

    public TravelPlan(City oras, List<Location> prefer) {
        this.oras = oras;
        this.prefer = prefer;
    }

    public TravelPlan() {
    }

    public String getOras() {
        return oras.getName();
    }

    public void setOras(City oras) {
        this.oras = oras;
    }

    public List<Location> getPrefer() {
        return prefer;
    }

    public void setPrefer(List<Location> prefer) {
        this.prefer = prefer;
    }

    @Override
    public String toString() {
        return "TravelPlan{" +
                "oras=" + oras +
                ", prefer=" + prefer +
                '}';
    }
}
