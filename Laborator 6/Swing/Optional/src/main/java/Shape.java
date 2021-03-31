import java.awt.*;

/**
 * <p> Clasa Shape retine toate datele despre formele din canvas. </p>
 */
public class Shape {
    protected int x;
    protected int y;
    protected int radius;
    protected int sides;
    protected String type;
    protected Color color;

    public Shape(int x, int y, int radius, int sides, String type, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.sides = sides;
        this.type = type;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}