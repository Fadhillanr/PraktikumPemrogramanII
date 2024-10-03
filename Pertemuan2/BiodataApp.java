import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class BiodataApp extends JFrame {

    public BiodataApp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label for Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 20, 350, 20);

        // TextField for Nama
        JTextField textNama = new JTextField();
        textNama.setBounds(15, 50, 350, 30);

        // Label for Nomor Telepon
        JLabel labelTelepon = new JLabel("Nomor Telepon:");
        labelTelepon.setBounds(15, 90, 350, 20);

        // TextField for Nomor Telepon
        JTextField textTelepon = new JTextField();
        textTelepon.setBounds(15, 120, 350, 30);

        // Button to Save Data
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 170, 350, 40);

        // TextArea to display the saved biodata
        JTextArea txtOutput = new JTextArea();
        txtOutput.setBounds(15, 230, 350, 150);
        txtOutput.setEditable(false);

        // Add ActionListener to button
        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textNama.getText();
                String telepon = textTelepon.getText();

                // Check if both fields are filled
                if (!nama.isEmpty() && !telepon.isEmpty()) {
                    txtOutput.append("Nama: " + nama + "\n" + 
                                     "Nomor Telepon: " + telepon + "\n" +
                                     "===========================\n");

                    // Clear the input fields after saving
                    textNama.setText("");
                    textTelepon.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Mohon isi semua field!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Add components to JFrame
        this.add(labelNama);
        this.add(textNama);
        this.add(labelTelepon);
        this.add(textTelepon);
        this.add(buttonSimpan);
        this.add(txtOutput);

        // Frame settings
        this.setSize(400, 450);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataApp app = new BiodataApp();
                app.setVisible(true);
            }
        });
    }
}
