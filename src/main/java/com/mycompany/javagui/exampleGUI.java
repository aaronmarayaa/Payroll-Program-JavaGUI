package com.mycompany.javagui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class exampleGUI extends JFrame {
    public exampleGUI() {
        // Set the layout of the frame
        setLayout(new BorderLayout());

        // Create and add a JLabel to the frame
        JLabel label = new JLabel("Label:");
        add(label, BorderLayout.NORTH);

        // Create and add a JTextField to the frame
        JTextField textField = new JTextField(20);
        add(textField, BorderLayout.CENTER);

        // Create and add a JTextArea to the frame
        JTextArea textArea = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Set the size and visibility of the frame
        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new exampleGUI();
    }
}
