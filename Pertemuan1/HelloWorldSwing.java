import javax.swing.*;

public class HelloWorldSwing {
    private static void createAndShowGUI() {
        // Create and set up the window
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a label with text
        JLabel label = new JLabel("Hello Fadhilla!");
        frame.getContentPane().add(label);

        // Display the window 
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
