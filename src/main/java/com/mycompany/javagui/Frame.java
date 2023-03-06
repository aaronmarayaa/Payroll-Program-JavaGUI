package com.mycompany.javagui;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.Border;

public class Frame {
    Frame(){
        
        JFrame frame = new JFrame(); //Frame class
        // Frame format
        frame.setSize(720, 630); //size of frame or canvas
        frame.setTitle("Payroll"); //title of frame

        //Menu bar
        JMenuBar menu = new JMenuBar(); //JMenu class
            JMenu file = new JMenu("File");
            JMenu edit = new JMenu("Edit");

            //file menu
            file.add(new JMenu("new"));
            file.add(new JMenu("open"));
            file.add(new JMenu("save"));

            //edit menu
            edit.add(new JMenu("cut"));
            edit.add(new JMenu("copy"));
            edit.add(new JMenu("paste"));

            menu.add(file);
            menu.add(edit);
        frame.setJMenuBar(menu);

        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);

        //PAYROLL program font and employee information panel wrapper
        JLabel payrollFont = new JLabel(); // JLabel class
            payrollFont.setText("PAYROLL PROGRAM");
            payrollFont.setFont(new Font("Oswald", Font.BOLD, 23));
            payrollFont.setVerticalAlignment(SwingConstants.TOP);
            payrollFont.setForeground(new Color(0, 0, 0));
            payrollFont.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
            JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(payrollFont, BorderLayout.WEST);

        //Date
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, h:mm:ss a");
        String formattedDateTime = now.format(formatter);
            JLabel dateLabel = new JLabel("Date: " + formattedDateTime);
            dateLabel.setVerticalAlignment(SwingConstants.TOP);
            dateLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 50));
        headerPanel.add(dateLabel, BorderLayout.EAST);

        //Employee Information
        JPanel employeeInformation_panel = new JPanel();
            Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white, 2), "Employee Information");
            employeeInformation_panel.setBorder(border);
            employeeInformation_panel.setBackground(new Color(128, 128, 255));
            employeeInformation_panel.setPreferredSize(new Dimension(300, 100));
            headerPanel.add(employeeInformation_panel, BorderLayout.SOUTH);
            //Add padding to the header panel to position the employee information panel lower
            headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        frame.add(headerPanel, BorderLayout.NORTH);

        frame.setResizable(false); //disallowed resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // make the frame visible

    }
}
