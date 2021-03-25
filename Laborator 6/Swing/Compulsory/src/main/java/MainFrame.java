import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.NORTH;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing App - Laborator 6");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        ConfigPanel panel = new ConfigPanel(this);
 //...TODO

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(panel, BorderLayout.NORTH);
        add(canvas, CENTER); //this is BorderLayout.CENTER
 //...TODO

        //invoke the layout manager
        pack();
        setContentPane(panel);
        setVisible(true);
    }
}
