package com.mycompany.javagui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class MyFrame extends JFrame {
    public MyFrame() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JTextField textField = new JTextField("Type here", 20);
        panel.add(button1);
        panel.add(button2);
        panel.add(textField);
        add(panel);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MyFrame();
    }
}

