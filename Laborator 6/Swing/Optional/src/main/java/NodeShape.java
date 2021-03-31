import java.awt.geom.Ellipse2D;

/**
 * <p> Constructorul din NodeShape class creaza un cerc cu datele introduse. </p>
 */
public class NodeShape extends Ellipse2D.Double {
    public NodeShape(double x, double y, double radius)
    {
        super(x-radius/2,y-radius/2,radius,radius);
    }
}
