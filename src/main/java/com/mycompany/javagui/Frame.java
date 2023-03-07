package com.mycompany.javagui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        
        JPanel informationPanel = new JPanel(new BorderLayout());
        JPanel titleAndDatePanel = new JPanel(new BorderLayout());

        //Payroll program font
       JLabel payrollFont = new JLabel(); // JLabel class
            payrollFont.setText("PAYROLL PROGRAM");
            payrollFont.setFont(new Font("Oswald", Font.BOLD, 23));
            payrollFont.setVerticalAlignment(SwingConstants.TOP);
            payrollFont.setForeground(new Color(0, 0, 0));
            payrollFont.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        titleAndDatePanel.add(payrollFont, BorderLayout.WEST);

        //current date and time
        LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, h:mm:ss a");
            String formattedDateTime = now.format(formatter);
            JLabel dateLabel = new JLabel("Date: " + formattedDateTime);
            dateLabel.setVerticalAlignment(SwingConstants.TOP);
            dateLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 50));
            titleAndDatePanel.add(dateLabel, BorderLayout.EAST);
        informationPanel.add(titleAndDatePanel, BorderLayout.NORTH);

        //Employee information section
        JPanel employeeInformation_panel = new JPanel();
            TitledBorder employeeInformation_border = BorderFactory.createTitledBorder("Salary Information");
            employeeInformation_border.setTitleColor(Color.BLUE);
            employeeInformation_panel.setBorder(employeeInformation_border);
            employeeInformation_panel.setBackground(new Color(128, 128, 255));
            employeeInformation_panel.setPreferredSize(new Dimension(300, 75));
                
                //employee Information labels
                employeeInformation_panel.setLayout(null);
                JLabel monthLabel = new JLabel("Month:");
                monthLabel.setBounds(10, 15, 80, 25);
                employeeInformation_panel.add(monthLabel);
                
                String[] month_options = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                JComboBox<String> monthMenu = new JComboBox<>(month_options);
                monthMenu.setBounds(70, 20, 200, 20);
                employeeInformation_panel.add(monthMenu);
                
                JLabel positionLabel = new JLabel("Position:");
                positionLabel.setBounds(10, 45, 80, 25);
                employeeInformation_panel.add(positionLabel);
                
                String[] position_options = {"Merchandiser", "Bagger", "Cashier"};
                JComboBox<String> positionMenu = new JComboBox<>(position_options);
                positionMenu.setBounds(70, 45, 200, 20);
                employeeInformation_panel.add(positionMenu);
                
                JLabel employeeName = new JLabel("Employee Name:");
                employeeName.setBounds(300, 15, 100, 25);
                employeeInformation_panel.add(employeeName);
                
                JTextField employeeName_textField = new JTextField();
                String employeeName_value = employeeName_textField.getText();
                employeeName_textField.setBounds(400, 17, 200, 20);
                employeeInformation_panel.add(employeeName_textField);
                
                JLabel address = new JLabel("Address:");
                address.setBounds(300, 45, 80, 25);
                employeeInformation_panel.add(address);
                
                JTextField address_textField = new JTextField();
                address_textField.setBounds(400, 47, 200, 20);
                employeeInformation_panel.add(address_textField);
                
            JPanel employeeInformation = new JPanel(new BorderLayout());
                employeeInformation.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
                employeeInformation.add(employeeInformation_panel, BorderLayout.NORTH);
        informationPanel.add(employeeInformation, BorderLayout.CENTER);
        
        // salary Information section
        JPanel salaryInformation_panel = new JPanel();
            TitledBorder salaryInformation_border = BorderFactory.createTitledBorder("Salary Information");
            salaryInformation_border.setTitleColor(Color.BLUE);
            salaryInformation_panel.setBorder(salaryInformation_border);
            salaryInformation_panel.setBackground(new Color(128, 128, 255));
            salaryInformation_panel.setPreferredSize(new Dimension(300, 100));
            informationPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

                //salary Information labels
                salaryInformation_panel.setLayout(null);
                JLabel salaryLevel = new JLabel("Salary Level:");
                salaryLevel.setBounds(10, 20, 80, 25);
                salaryInformation_panel.add(salaryLevel);
                
                JTextField salaryLevel_textField = new JTextField();
                salaryLevel_textField.setBounds(100, 20, 50, 20);
                salaryLevel_textField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyTyped(KeyEvent e) {
                    // Check if the key pressed is not a digit
                        if (!Character.isDigit(e.getKeyChar())) {
                            e.consume(); // Consume the event to prevent it from being processed
                        }
                    }
                });
                salaryInformation_panel.add(salaryLevel_textField);
                
                                
                JLabel salaryRate = new JLabel("Salary Rate:");
                salaryRate.setBounds(10, 45, 80, 25);
                salaryInformation_panel.add(salaryRate);
                
                JTextField salaryRate_textField = new JTextField();
                salaryRate_textField.setBounds(100, 45, 150, 20);
                salaryInformation_panel.add(salaryRate_textField);
                
                JButton ok_button = new JButton("Ok");
                ok_button.setBounds(160, 20, 50,20);
                ok_button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String salaryLevel_value = salaryLevel_textField.getText();
                        if(salaryLevel_value.equals("1")){
                            salaryRate_textField.setText("350.00");
                        } 
                        else if(salaryLevel_value.equals("2")){
                            salaryRate_textField.setText("400.00");
                        }
                        else if(salaryLevel_value.equals("3")){
                            salaryRate_textField.setText("450.00");
                        }
                        else if(salaryLevel_value.equals("4")){
                            salaryRate_textField.setText("550.00");
                        }
                        else if(salaryLevel_value.equals("5")){
                            salaryRate_textField.setText("600.00");
                        }
                        else {
                            salaryRate_textField.setText("0.00");
                        }
                    }
                });
                salaryInformation_panel.add(ok_button);
        informationPanel.add(salaryInformation_panel, BorderLayout.SOUTH);
        frame.add(informationPanel, BorderLayout.NORTH);
        
        //Footer Panel
        JPanel footer = new JPanel(new BorderLayout());
            footer.setLayout(new GridLayout(2, 2, 5, 0));

            //earnings section
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
            
            //deduction section
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

            //summary section
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

            //received section            
            JPanel received_panel = new JPanel();
            received_panel.setBackground(new Color(128, 128, 255));
            received_panel.setPreferredSize(new Dimension(350, 90));
            JPanel received = new JPanel(new BorderLayout());
                received.setBorder(BorderFactory.createEmptyBorder(5, 0, 5,5));
                received.add(received_panel, BorderLayout.EAST);
            footer.add(received, BorderLayout.SOUTH);
            frame.add(footer, BorderLayout.CENTER);
        
        //buttons
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
