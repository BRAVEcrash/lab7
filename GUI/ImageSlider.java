package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageSlider {
 
    private String[] imageFiles = 
    {"D:\\Документы\\2학기\\객체지향프로그래밍\\lab7_UTF-8\\lab7_UTF-8/dog.png",
    "D:\\Документы\\2학기\\객체지향프로그래밍\\lab7_UTF-8\\lab7_UTF-8/bird.png",
    "D:\\Документы\\2학기\\객체지향프로그래밍\\lab7_UTF-8\\lab7_UTF-8/cat.png",
     "D:\\Документы\\2학기\\객체지향프로그래밍\\lab7_UTF-8\\lab7_UTF-8/pig.png",
     "D:\\Документы\\2학기\\객체지향프로그래밍\\lab7_UTF-8\\lab7_UTF-8/rabbit.png"};
    private int currentIndex = 0;
    private JLabel imageLabel;

    public ImageSlider() {

        JFrame frame = new JFrame("이미지 슬라이더");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton firstButton = new JButton("|<");
        JButton previousButton = new JButton("<<");
        JButton nextButton = new JButton(">>");
        JButton lastButton = new JButton(">|");

        buttonPanel.add(firstButton);
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(lastButton);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        displayImage(currentIndex);

        frame.add(imageLabel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);


        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = 0;
                displayImage(currentIndex);
            }
        });

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    displayImage(currentIndex);
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < imageFiles.length - 1) {
                    currentIndex++;
                    displayImage(currentIndex);
                }
            }
        });

        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = imageFiles.length - 1;
                displayImage(currentIndex);
            }
        });

        frame.setVisible(true);
    }


    private void displayImage(int index) {
        ImageIcon icon = new ImageIcon(imageFiles[index]);
        imageLabel.setIcon(icon);
    }

    public static void main(String[] args) { 
        new ImageSlider();
    }
}
