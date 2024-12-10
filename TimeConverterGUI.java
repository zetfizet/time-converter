import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeConverterGUI {
    public TimeConverterGUI() {
        // Frame utama
        JFrame frame = new JFrame("Time Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Panel input dan output
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        frame.add(panel, BorderLayout.CENTER);

        // Komponen input
        JLabel inputLabel = new JLabel("Enter value:");
        JTextField inputField = new JTextField();
        panel.add(inputLabel);
        panel.add(inputField);

        // Pilihan unit asal
        JLabel fromLabel = new JLabel("From unit:");
        String[] units = { "Seconds", "Minutes", "Hours", "Days", "Weeks", "Years" };
        JComboBox<String> fromComboBox = new JComboBox<>(units);
        panel.add(fromLabel);
        panel.add(fromComboBox);

        // Pilihan unit tujuan
        JLabel toLabel = new JLabel("To unit:");
        JComboBox<String> toComboBox = new JComboBox<>(units);
        panel.add(toLabel);
        panel.add(toComboBox);

        // Tombol konversi
        JButton convertButton = new JButton("Convert");
        panel.add(new JLabel()); // Placeholder
        panel.add(convertButton);

        // Label hasil
        JLabel resultLabel = new JLabel("Result: ");
        frame.add(resultLabel, BorderLayout.SOUTH);

        // Aksi tombol
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputValue = Double.parseDouble(inputField.getText());
                    String fromUnit = (String) fromComboBox.getSelectedItem();
                    String toUnit = (String) toComboBox.getSelectedItem();

                    double result = TimeConverter.convert(inputValue, fromUnit, toUnit);
                    resultLabel.setText("Result: " + result + " " + toUnit);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Tampilkan frame
        frame.setVisible(true);
    }
}
