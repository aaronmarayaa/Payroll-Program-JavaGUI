package com.mycompany.javagui;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

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

            menu.add(file);
            menu.add(edit);
        frame.setJMenuBar(menu);

        frame.setLayout(new BorderLayout());
        
        JPanel headerPanel = new JPanel(new BorderLayout());
// create a nested panel for the top row of the header
        JPanel topHeaderPanel = new JPanel(new BorderLayout());

//PAYROLL program font and employee information panel wrapper
       JLabel payrollFont = new JLabel(); // JLabel class
            payrollFont.setText("PAYROLL PROGRAM");
            payrollFont.setFont(new Font("Oswald", Font.BOLD, 23));
            payrollFont.setVerticalAlignment(SwingConstants.TOP);
            payrollFont.setForeground(new Color(0, 0, 0));
            payrollFont.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        topHeaderPanel.add(payrollFont, BorderLayout.WEST);

        LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, h:mm:ss a");
            String formattedDateTime = now.format(formatter);
            JLabel dateLabel = new JLabel("Date: " + formattedDateTime);
            dateLabel.setVerticalAlignment(SwingConstants.TOP);
            dateLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 50));
            topHeaderPanel.add(dateLabel, BorderLayout.EAST);
        headerPanel.add(topHeaderPanel, BorderLayout.NORTH);

// create a nested panel for the employee information
        JPanel employeeInformation_panel = new JPanel();
            TitledBorder employeeInformation_border = BorderFactory.createTitledBorder("Salary Information");
            employeeInformation_border.setTitleColor(Color.BLUE);
            employeeInformation_panel.setBorder(employeeInformation_border);
            employeeInformation_panel.setBackground(new Color(128, 128, 255));
            employeeInformation_panel.setPreferredSize(new Dimension(300, 75));
            JPanel employeeInformation = new JPanel(new BorderLayout());
                employeeInformation.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
                employeeInformation.add(employeeInformation_panel, BorderLayout.NORTH);
        headerPanel.add(employeeInformation, BorderLayout.CENTER);
        
        

// create a nested panel for the salary information
        JPanel salaryInformation_panel = new JPanel();
            TitledBorder salaryInformation_border = BorderFactory.createTitledBorder("Salary Information");
            salaryInformation_border.setTitleColor(Color.BLUE);
            salaryInformation_panel.setBorder(salaryInformation_border);
            salaryInformation_panel.setBackground(new Color(128, 128, 255));
            salaryInformation_panel.setPreferredSize(new Dimension(300, 100));
        headerPanel.add(salaryInformation_panel, BorderLayout.SOUTH);

        //Add padding to the header panel to position the employee information and salary information panels lower
        headerPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        frame.add(headerPanel, BorderLayout.NORTH);
        
        //Footer Panel
        JPanel footer = new JPanel(new BorderLayout());
            JPanel earnings_panel = new JPanel();
            TitledBorder earnings_border = BorderFactory.createTitledBorder("Salary Information");
            earnings_border.setTitleColor(Color.BLUE);
            earnings_panel.setBorder(earnings_border);
            earnings_panel.setBackground(new Color(128, 128, 255));
            earnings_panel.setPreferredSize(new Dimension(350, 160));
            JPanel earnings = new JPanel(new BorderLayout());
                earnings.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
                earnings.add(earnings_panel, BorderLayout.NORTH);
            footer.add(earnings, BorderLayout.WEST);
            
            JPanel deductions_panel = new JPanel();
            TitledBorder deductions_border = BorderFactory.createTitledBorder("Salary Information");
            deductions_border.setTitleColor(Color.BLUE);
            deductions_panel.setBorder(deductions_border);
            deductions_panel.setBackground(new Color(128, 128, 255));
            deductions_panel.setPreferredSize(new Dimension(350, 160));
            JPanel deductions = new JPanel(new BorderLayout());
                deductions.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 5));
                deductions.add(deductions_panel, BorderLayout.NORTH);
            footer.add(deductions, BorderLayout.EAST);
        
            JPanel summary_panel = new JPanel();
            TitledBorder summary_border = BorderFactory.createTitledBorder("SUMMARY");
            summary_border.setTitleColor(Color.BLUE);
            summary_panel.setBorder(summary_border);
            summary_panel.setBackground(new Color(128, 128, 255));
            summary_panel.setPreferredSize(new Dimension(354, 90));
            JPanel summary = new JPanel(new BorderLayout());
                summary.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
                summary.add(summary_panel, BorderLayout.WEST);
            footer.add(summary, BorderLayout.SOUTH);
            
            JPanel received_panel = new JPanel();
            received_panel.setBackground(new Color(128, 128, 255));
            received_panel.setPreferredSize(new Dimension(350, 90));
            JPanel received = new JPanel(new BorderLayout());
                received.setBorder(BorderFactory.createEmptyBorder(5, 0, 5,5));
                received.add(received_panel, BorderLayout.EAST);
            footer.add(received, BorderLayout.SOUTH);
            footer.setLayout(new GridLayout(2, 2, 5, 0));
            frame.add(footer, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
            buttons.add(new JButton("Print"));
            buttons.add(new JButton("Clear"));
            buttons.add(new JButton("Exit"));
            buttons.setPreferredSize(new Dimension(350, 40));
        frame.add(buttons, BorderLayout.SOUTH);
        
        
        frame.setResizable(false); //disallowed resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // make the frame visible

    }
}
