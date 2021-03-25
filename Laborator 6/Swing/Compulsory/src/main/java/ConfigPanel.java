import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape
    JComboBox size; //size of shape
    JComboBox shape; //name of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(3); //default number of sides
        //create the colorCombo, containing the values: Random and Black
        String[] colorStrings = { "Black", "Blue", "Purple", "Red", "Green" };
        colorCombo = new JComboBox(colorStrings);
        colorCombo.setSelectedIndex(0);
        String[] sizeStrings = {"small", "medium", "big", "huge"};
        size = new JComboBox(sizeStrings);
        String[] shapeStrings = {"square", "circle", "triangle", "polygon"};
        shape = new JComboBox(shapeStrings);
        shape.setSelectedIndex(3);
 //...TODO
//        JLabel label = new JLabel("       Insert your preffered configuration for the image.  Note: The polygon will be only one with the number of sides specified. Other shapes can be 1-100.\n                                                                                                                                                                                  ");
//        add(label);
        JLabel label1 = new JLabel("   Choose a shape:  ");
        add(label1);
        add(shape);
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
