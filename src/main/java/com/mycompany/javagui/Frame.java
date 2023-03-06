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
        
        //PAYROLL program font
        JLabel payrollFont = new JLabel(); // JLabel class
            payrollFont.setText("PAYROLL PROGRAM");
            payrollFont.setFont(new Font("Oswald", Font.BOLD, 23));
            payrollFont.setVerticalAlignment(SwingConstants.TOP);
            payrollFont.setForeground(new Color(0, 0, 0));
            payrollFont.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        frame.add(payrollFont, BorderLayout.WEST);
        
        //Date
        LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, h:mm:ss a");
            String formattedDateTime = now.format(formatter);
            JLabel dateLabel = new JLabel("Date: " + formattedDateTime);
            dateLabel.setVerticalAlignment(SwingConstants.TOP);
            dateLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        frame.add(dateLabel, BorderLayout.EAST);
        
        //Employee Information
        JPanel employeeInformation_panel = new JPanel();
            Border border = BorderFactory.createTitledBorder("Employee Information");
            employeeInformation_panel.setBorder(border);
            employeeInformation_panel.setBackground(Color.blue);
            employeeInformation_panel.setPreferredSize(new Dimension(400, 300));
            employeeInformation_panel.setLayout(new FlowLayout());
            frame.add(employeeInformation_panel, BorderLayout.SOUTH);
        frame.add(employeeInformation_panel);
        
        frame.setResizable(false); //disallowed resize
        //frame.setSize(720, 630);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // make the frame visible
    }
}
