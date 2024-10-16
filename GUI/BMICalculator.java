package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("BMI 계산기");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create labels and text fields for weight and height input
        JLabel weightLabel = new JLabel("나의 체중(kg):");
        weightLabel.setBounds(20, 20, 100, 30);
        JTextField weightField = new JTextField();
        weightField.setBounds(130, 20, 100, 30);

        JLabel heightLabel = new JLabel("나의 키(cm):");
        heightLabel.setBounds(20, 60, 100, 30);
        JTextField heightField = new JTextField();
        heightField.setBounds(130, 60, 100, 30);

        // Create button to calculate BMI
        JButton calculateButton = new JButton("BMI 확인하기");
        calculateButton.setBounds(20, 100, 210, 30);

        // Create label to display result
        JLabel resultLabel = new JLabel("당신의 BMI:");
        resultLabel.setBounds(20, 140, 250, 30);

        // Add components to frame
        frame.add(weightLabel);
        frame.add(weightField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        // Add action listener for the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get weight and height from text fields
                    double weight = Double.parseDouble(weightField.getText());
                    double height = Double.parseDouble(heightField.getText()) / 100; // Convert height to meters

                    // Calculate BMI
                    double bmi = weight / (height * height);

                    // Determine BMI category
                    String category;
                    if (bmi < 18.5) {
                        category = "저체중";
                    } else if (bmi < 23.0) {
                        category = "정상";
                    } else if (bmi < 25.0) {
                        category = "과체중";
                    } else {
                        category = "비만";
                    }

                    // Display result
                    resultLabel.setText(String.format("당신의 BMI: %.1f (%s)", bmi, category));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("체중과 키를 올바르게 입력하세요.");
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
