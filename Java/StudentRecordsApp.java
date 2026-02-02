// Programmer Identifier: [CLENT AGAN CANETE] [24-1917-717]
// Student Records Management System - Java Swing Implementation

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentRecordsApp extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField idField, firstNameField, lastNameField;
    private JTextField lab1Field, lab2Field, lab3Field;
    private JTextField prelimField, attendanceField;

    private JButton addButton, deleteButton;

    private JLabel messageLabel; // For temporary messages

    public StudentRecordsApp() {
        setTitle("Student Records - [CLENT AGAN CANETE] [24-1917-717]");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
        loadDataFromCSV();
    }

    private void initializeComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Message label at top
        messageLabel = new JLabel(" ", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        messageLabel.setForeground(new Color(0, 128, 0));
        mainPanel.add(messageLabel, BorderLayout.NORTH);

        // Table columns
        String[] columnNames = {
            "ID", "First Name", "Last Name",
            "Lab 1", "Lab 2", "Lab 3",
            "Prelim Exam", "Attendance"
        };

        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setRowHeight(30);

        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Input panel horizontal layout
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createTitledBorder("Student Information"));
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

        inputPanel.add(createVerticalLabelField("ID", idField = new JTextField(8)));
        inputPanel.add(createVerticalLabelField("First Name", firstNameField = new JTextField(10)));
        inputPanel.add(createVerticalLabelField("Last Name", lastNameField = new JTextField(10)));
        inputPanel.add(createVerticalLabelField("Lab 1", lab1Field = new JTextField(5)));
        inputPanel.add(createVerticalLabelField("Lab 2", lab2Field = new JTextField(5)));
        inputPanel.add(createVerticalLabelField("Lab 3", lab3Field = new JTextField(5)));
        inputPanel.add(createVerticalLabelField("Prelim Exam", prelimField = new JTextField(6)));
        inputPanel.add(createVerticalLabelField("Attendance", attendanceField = new JTextField(6)));

        // Add and Delete buttons side by side
        addButton = new JButton("Add");
        addButton.addActionListener(e -> addRecord());
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deleteRecord());

        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    private JPanel createVerticalLabelField(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(labelText);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setMaximumSize(textField.getPreferredSize());
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 3)));
        panel.add(textField);
        panel.setPreferredSize(new Dimension(textField.getPreferredSize().width + 20, 55));

        return panel;
    }

    private void loadDataFromCSV() {
        String csvFile = "MOCK_DATA.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d.length >= 8) {
                    tableModel.addRow(new Object[]{
                        d[0].trim(), d[1].trim(), d[2].trim(),
                        d[3].trim(), d[4].trim(), d[5].trim(),
                        d[6].trim(), d[7].trim()
                    });
                }
            }
            showMessage("Data loaded successfully!", Color.BLUE);
        } catch (IOException e) {
            showMessage("Error reading CSV file.", Color.RED);
        }
    }

    private void addRecord() {
        if (idField.getText().isEmpty() || firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty()) {
            showMessage("Please fill in required fields (ID, First Name, Last Name)!", Color.RED);
            return;
        }

        tableModel.addRow(new Object[]{
            idField.getText(),
            firstNameField.getText(),
            lastNameField.getText(),
            lab1Field.getText(),
            lab2Field.getText(),
            lab3Field.getText(),
            prelimField.getText(),
            attendanceField.getText()
        });

        // Clear fields
        idField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        lab1Field.setText("");
        lab2Field.setText("");
        lab3Field.setText("");
        prelimField.setText("");
        attendanceField.setText("");

        showMessage("Record added successfully!", new Color(0, 128, 0));
    }

    private void deleteRecord() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            showMessage("Please select a record to delete.", Color.RED);
            return;
        }
        tableModel.removeRow(selectedRow);
        showMessage("Record deleted successfully!", Color.MAGENTA);
    }

    // Display temporary message for 3 seconds
    private void showMessage(String message, Color color) {
        messageLabel.setText(message);
        messageLabel.setForeground(color);

        // Clear message after 3 seconds
        Timer timer = new Timer(3000, e -> messageLabel.setText(" "));
        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRecordsApp().setVisible(true));
    }
}
