import java.awt.*;
import javax.swing.*;


public class SwingInterface implements Runnable {
    public void run() {
        // Create the window
        JFrame f = new JFrame("Hello, !");
        // Sets the behavior for when the window is closed
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Add a layout manager so that the button is not placed on top of the label
        f.setLayout(new FlowLayout());
        // Add a label and a button
        f.add(new JLabel("Hello, world!"));
        f.add(new JButton("Press me!"));
        f.add(new JFormattedTextField(""));
        f.add(Box.createRigidArea(new Dimension(0,5)));
        // Arrange the components inside the window
        f.pack();
        // By default, the window is not visible. Make it visible.
        f.setSize(400,300);

        f.setVisible(true);

    }

    public static void main(String[] args){
        SwingInterface se = new SwingInterface();
        SwingUtilities.invokeLater(se);
    }



}
