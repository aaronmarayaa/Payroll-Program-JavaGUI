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

        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);
        
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
            Border border = BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.white, 2),
                    "Employee Information",
                    TitledBorder.DEFAULT_JUSTIFICATION,
                    TitledBorder.DEFAULT_POSITION,
                    new Font("Arial", Font.BOLD, 14), // create a custom font object with the desired color
                    Color.blue // set the font color to red
            );
            employeeInformation_panel.setBorder(border);
            employeeInformation_panel.setBackground(new Color(128, 128, 255));
            employeeInformation_panel.setPreferredSize(new Dimension(300, 75));
            JPanel employeeInformation = new JPanel(new BorderLayout());
                employeeInformation.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
                employeeInformation.add(employeeInformation_panel, BorderLayout.NORTH);
        headerPanel.add(employeeInformation, BorderLayout.CENTER);
        
        

// create a nested panel for the salary information
        JPanel salaryInformation_panel = new JPanel();
        Border salaryInformation_border = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.white, 2),
                "Salary Information",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 14), // create a custom font object with the desired color
                Color.blue // set the font color to red
        );
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
            Border earnings_border = BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.white, 2),
                    "Earnings",
                    TitledBorder.DEFAULT_JUSTIFICATION,
                    TitledBorder.DEFAULT_POSITION,
                    new Font("Arial", Font.BOLD, 14), // create a custom font object with the desired color
                    Color.blue // set the font color to red
            );
            earnings_panel.setBorder(earnings_border);
            earnings_panel.setBackground(new Color(128, 128, 255));
            earnings_panel.setPreferredSize(new Dimension(350, 160));
            JPanel earnings = new JPanel(new BorderLayout());
                earnings.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
                earnings.add(earnings_panel, BorderLayout.NORTH);
            footer.add(earnings, BorderLayout.WEST);
            
            JPanel deductions_panel = new JPanel();
            Border deductions_border = BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.white, 2),
                    "Deductions",
                    TitledBorder.DEFAULT_JUSTIFICATION,
                    TitledBorder.DEFAULT_POSITION,
                    new Font("Arial", Font.BOLD, 14), // create a custom font object with the desired color
                    Color.blue // set the font color to red
            );
            deductions_panel.setBorder(deductions_border);
            deductions_panel.setBackground(new Color(128, 128, 255));
            deductions_panel.setPreferredSize(new Dimension(350, 160));
            JPanel deductions = new JPanel(new BorderLayout());
                deductions.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 5));
                deductions.add(deductions_panel, BorderLayout.NORTH);
            footer.add(deductions, BorderLayout.EAST);
            frame.add(footer, BorderLayout.CENTER);
        
        JPanel footer2 = new JPanel();
            JPanel summary_panel = new JPanel();
            Border summary_border = BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.white, 2),
                    "Summary",
                    TitledBorder.DEFAULT_JUSTIFICATION,
                    TitledBorder.DEFAULT_POSITION,
                    new Font("Arial", Font.BOLD, 14), // create a custom font object with the desired color
                    Color.blue // set the font color to red
            );
            summary_panel.setBorder(summary_border);
            summary_panel.setBackground(new Color(128, 128, 255));
            summary_panel.setPreferredSize(new Dimension(350, 160));
            JPanel summary = new JPanel(new BorderLayout());
                summary.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                summary.add(summary_panel, BorderLayout.WEST);
            footer2.add(summary, BorderLayout.WEST);
            
            JPanel received_panel = new JPanel();
            received_panel.setBackground(new Color(128, 128, 255));
            received_panel.setPreferredSize(new Dimension(350, 160));
            JPanel received = new JPanel(new BorderLayout());
                received.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                received.add(received_panel, BorderLayout.EAST);
            footer2.add(received, BorderLayout.NORTH);
            frame.add(footer2, BorderLayout.SOUTH);
        
        
        frame.setResizable(false); //disallowed resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // make the frame visible

    }
}
