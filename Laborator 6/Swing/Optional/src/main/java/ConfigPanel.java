import javax.swing.*;

/**
 * <p> Clasa ConfigPanel initializeaza panelul de configurare a figurilor geometrice. </p>
 */
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape
    JSlider size; //size of shape
    JComboBox shapeType;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
        sidesField.setValue(sidesField.getValue());

        sidesField.setValue(3); //default number of sides
        String[] shapeString = {"Polygon", "Circle"};
        shapeType = new JComboBox(shapeString);
        //create the colorCombo, containing the values: Random and Black
        String[] colorStrings = { "Black", "Random" };
        colorCombo = new JComboBox(colorStrings);
        colorCombo.setSelectedIndex(0);

        size = new JSlider(JSlider.HORIZONTAL, 0, 300, 150);
        size.setMinorTickSpacing(25);
        size.setMajorTickSpacing(50);
        size.setPaintTicks(true);
        size.setPaintLabels(true);
        add(size);

        JLabel label1 = new JLabel("    Choose shape:  ");
        add(label1);
        add(shapeType);
        JLabel label2 = new JLabel("    Choose the size:  ");
        add(label2);
        add(size);
        JLabel label3 = new JLabel("   Choose the number of sides / shapes:  ");
        add(label3); //JPanel uses FlowLayout by default
        add(sidesField);
        JLabel label4 = new JLabel("   Choose the color:  ");
        add(label4);
        add(colorCombo);
    }
}