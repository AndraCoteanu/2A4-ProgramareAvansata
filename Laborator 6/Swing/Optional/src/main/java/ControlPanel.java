import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <p> Clasa ControlPanel initializeaza panelul care controleaza imaginea din canvas. </p>
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton undoBtn = new JButton("Undo");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    JFileChooser fileChooser = new JFileChooser();

    //create all buttons (Load, Reset, Exit)
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new FlowLayout());
        add(saveBtn);
        add(loadBtn);
        add(undoBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        undoBtn.addActionListener(this::undo);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        int verif = fileChooser.showSaveDialog(null);
        if (verif == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(frame.canvas.image, "PNG", new File(fileChooser.getSelectedFile().getAbsolutePath()));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    private void load(ActionEvent e) {
        int verif = fileChooser.showOpenDialog(null);
        if (verif == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage image = ImageIO.read(new File(fileChooser.getSelectedFile().getAbsolutePath()));
                frame.canvas.image = image;
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    private void undo(ActionEvent e) throws EmptyListException {
        frame.canvas.deleteLastShape();
        frame.canvas.drawShapeList();
    }

    private void reset(ActionEvent e) {
        frame.repaint();
        frame.canvas.shapes.clear();
        frame.canvas.createOffscreenImage();
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }
}