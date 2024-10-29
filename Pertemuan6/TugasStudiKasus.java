package Pertemuan6;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TugasStudiKasus extends JFrame {
    
    private JTextField namaField;
    private JTextArea alamatArea;
    private JRadioButton lakiRadio, perempuanRadio;
    private JCheckBox olahragaCheck, membacaCheck;
    private JComboBox<String> jurusanBox;
    private JList<String> peminatanList;
    private JTable dataTable;
    private DefaultTableModel tableModel;
    private ButtonGroup genderGroup; // Deklarasi ButtonGroup sebagai variabel kelas

    public TugasStudiKasus() {
        setTitle("Aplikasi Input Data - Tugas Studi Kasus");
        setSize(750, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Panel untuk Input Data
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        // Nama
        c.gridx = 0; c.gridy = 0;
        inputPanel.add(new JLabel("Nama:"), c);
        c.gridx = 1;
        namaField = new JTextField(20);
        inputPanel.add(namaField, c);

        // Alamat
        c.gridx = 0; c.gridy = 1;
        inputPanel.add(new JLabel("Alamat:"), c);
        c.gridx = 1;
        alamatArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(alamatArea), c);

        // Gender
        c.gridx = 0; c.gridy = 2;
        inputPanel.add(new JLabel("Gender:"), c);
        c.gridx = 1;
        lakiRadio = new JRadioButton("Laki-Laki");
        perempuanRadio = new JRadioButton("Perempuan");
        genderGroup = new ButtonGroup(); // Inisialisasi ButtonGroup
        genderGroup.add(lakiRadio);
        genderGroup.add(perempuanRadio);
        JPanel genderPanel = new JPanel();
        genderPanel.add(lakiRadio);
        genderPanel.add(perempuanRadio);
        inputPanel.add(genderPanel, c);

        // Hobi
        c.gridx = 0; c.gridy = 3;
        inputPanel.add(new JLabel("Hobi:"), c);
        c.gridx = 1;
        olahragaCheck = new JCheckBox("Olahraga");
        membacaCheck = new JCheckBox("Membaca");
        JPanel hobiPanel = new JPanel();
        hobiPanel.add(olahragaCheck);
        hobiPanel.add(membacaCheck);
        inputPanel.add(hobiPanel, c);

        // Jurusan
        c.gridx = 0; c.gridy = 4;
        inputPanel.add(new JLabel("Jurusan:"), c);
        c.gridx = 1;
        String[] jurusanOptions = {"Teknik Informatika", "Sistem Informasi", "Teknik Elektro"};
        jurusanBox = new JComboBox<>(jurusanOptions);
        inputPanel.add(jurusanBox, c);

        // Peminatan
        c.gridx = 0; c.gridy = 5;
        inputPanel.add(new JLabel("Peminatan:"), c);
        c.gridx = 1;
        String[] peminatanOptions = {"Artificial Intelligence", "Data Science", "Cybersecurity"};
        peminatanList = new JList<>(peminatanOptions);
        inputPanel.add(new JScrollPane(peminatanList), c);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Tambah Data");
        addButton.addActionListener(new AddDataListener());
        buttonPanel.add(addButton);
        
        // Tabel untuk Menampilkan Data
        tableModel = new DefaultTableModel(new String[]{"Nama", "Alamat", "Gender", "Hobi", "Jurusan", "Peminatan"}, 0);
        dataTable = new JTable(tableModel);

        // Tambah Panel ke Layout Utama
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(new JScrollPane(dataTable), BorderLayout.EAST);
    }

    // Listener untuk Menambah Data ke Tabel
    private class AddDataListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (namaField.getText().isEmpty() || alamatArea.getText().isEmpty() || 
                (!lakiRadio.isSelected() && !perempuanRadio.isSelected()) || 
                peminatanList.isSelectionEmpty()) {
                
                JOptionPane.showMessageDialog(TugasStudiKasus.this, "Lengkapi semua data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String nama = namaField.getText();
            String alamat = alamatArea.getText();
            String gender = lakiRadio.isSelected() ? "Laki-Laki" : "Perempuan";
            String hobi = (olahragaCheck.isSelected() ? "Olahraga " : "") + (membacaCheck.isSelected() ? "Membaca" : "");
            String jurusan = (String) jurusanBox.getSelectedItem();
            String peminatan = peminatanList.getSelectedValue();

            // Tambah Data ke Tabel
            tableModel.addRow(new Object[]{nama, alamat, gender, hobi, jurusan, peminatan});

            // Kosongkan Field Setelah Data Ditambahkan
            namaField.setText("");
            alamatArea.setText("");
            genderGroup.clearSelection(); // Ini akan berfungsi tanpa error
            olahragaCheck.setSelected(false);
            membacaCheck.setSelected(false);
            jurusanBox.setSelectedIndex(0);
            peminatanList.clearSelection();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TugasStudiKasus app = new TugasStudiKasus();
            app.setVisible(true);
        });
    }
}
