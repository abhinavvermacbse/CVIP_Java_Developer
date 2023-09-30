
package bmi_interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMI_interface extends JFrame {
    private final JTextField weightField;
    private final JTextField heightField;
    private final JLabel resultLabel;

    public BMI_interface() {
        // Set up the main frame
        setTitle("BMI Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create components
        JLabel weightLabel = new JLabel("Enter Weight (kg):");
        JLabel heightLabel = new JLabel("Enter Height (m):");
        weightField = new JTextField(10);
        heightField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate BMI");
        resultLabel = new JLabel();

        // Add components to the frame
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(calculateButton);
        panel.add(resultLabel);
        add(panel);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            double bmi = weight / (height * height);

            // Display the result
            String bmiCategory = getBMICategory(bmi);
            resultLabel.setText("BMI: " + String.format("%.2f", bmi) + " (" + bmiCategory + ")");
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter numeric values.");
        }
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal Weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BMI_interface().setVisible(true);
        });
    }
}
