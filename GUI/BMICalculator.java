package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {

    private JFrame frame;
    private JTextField weightField, heightField;
    private JLabel resultLabel;

    public BMICalculator() {
        frame = new JFrame("BMI 비만도 계산기");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Body Mass Index Calculator GUI Components
        JLabel weightLabel = new JLabel("나의 체중(kg):");
        weightLabel.setBounds(20, 20, 100, 30);
        weightField = new JTextField();
        weightField.setBounds(130, 20, 100, 30);

        JLabel heightLabel = new JLabel("나의 키(cm):");
        heightLabel.setBounds(20, 60, 100, 30);
        heightField = new JTextField();
        heightField.setBounds(130, 60, 100, 30);

        JButton calculateButton = new JButton("BMI 확인하기");
        calculateButton.setBounds(20, 100, 210, 30);

        resultLabel = new JLabel("당신의 BMI:");
        resultLabel.setBounds(20, 140, 250, 30);

        frame.add(weightLabel);
        frame.add(weightField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double weight = Double.parseDouble(weightField.getText());
                    double height = Double.parseDouble(heightField.getText()) / 100; // Convert cm to meters

                    double bmi = weight / (height * height);
                    String category = getBMICategory(bmi);

                    resultLabel.setText(String.format("당신의 BMI: %.1f (%s)", bmi, category));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("체중과 키를 올바르게 입력하세요.");
                }
            }
        });

        frame.setVisible(true);
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) return "저체중";
        if (bmi < 23.0) return "정상";
        if (bmi < 25.0) return "과체중";
        return "비만";
    }

    public static void main(String[] args) {
        new BMICalculator(); // This will launch the BMI calculator when executed
    }
}
