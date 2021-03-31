import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> Clasa DrawingPanel controleaza figurile afisate in canvas. </p>
 */
public class DrawingPanel extends JPanel {
    final MainFrame frame;
    List<Shape> shapes = new ArrayList<>();
    final static int W = 1250, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    protected void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        shapes.clear();
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }

    public void deleteLastShape() {
        int lastIndex = shapes.size()-1;
        shapes.remove(lastIndex);
        drawShapeList();
    }

    public void drawShapeList() {
        this.createOffscreenImage();
        frame.repaint();
        for (Shape shape : this.shapes) {
            graphics.setColor(shape.getColor());
            if(shape.getType().equals("Polygon"))
            {
                graphics.fill(new RegularPolygon(shape.getX(), shape.getY(), shape.getRadius(), shape.getSides()));
            } else {
                graphics.fill(new NodeShape(shape.getX(), shape.getY(), shape.getRadius()));
            }
        }
    }

    private void drawShape(int x, int y) {
        int radius = frame.configPanel.size.getValue();
        int sides = (int) frame.configPanel.sidesField.getValue();
        //System.out.println(sides);
        String culoare = (String) frame.configPanel.colorCombo.getSelectedItem();
        Color Color = new Color((int) (100 * Math.random()), (int) (100 * Math.random()), (int) (100 * Math.random()), 70);
        if (culoare != null && culoare.equals("Black")) {
            Color = new Color(0, 0, 0, 50);
        }

        String type = (String) frame.configPanel.shapeType.getSelectedItem();
        shapes.add(new Shape(x,y,radius,sides,type,Color));
        drawShapeList();
    }

    @Override
    public void update(Graphics g) {
    } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}