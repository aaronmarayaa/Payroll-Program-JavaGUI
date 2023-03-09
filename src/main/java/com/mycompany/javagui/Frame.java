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
                
                // salary rate text                
                JLabel salaryRate = new JLabel("Salary Rate:");
                salaryRate.setBounds(10, 45, 80, 25);
                salaryInformation_panel.add(salaryRate);
                
                //salary rate text field
                JTextField salaryRate_textField = new JTextField();
                salaryRate_textField.setBounds(100, 45, 150, 20);
                salaryInformation_panel.add(salaryRate_textField);
                
                //salary rate button
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
                
                //late text
                JLabel late = new JLabel("Late:");
                late.setBounds(10, 70, 60, 20);
                salaryInformation_panel.add(late);
                
                //late text field
                JTextField late_textField = new JTextField();
                late_textField.setBounds(45, 70, 40, 20);
                late_textField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyTyped(KeyEvent e) {
                    // Check if the key pressed is not a digit
                        if (!Character.isDigit(e.getKeyChar())) {
                            e.consume(); // Consume the event to prevent it from being processed
                        }
                    }
                });
                salaryInformation_panel.add(late_textField);
                
                //absent text
                JLabel absent = new JLabel("Absent:");
                absent.setBounds(100, 70, 60, 20);
                salaryInformation_panel.add(absent);
                
                //absent text field
                JTextField absent_textField = new JTextField();
                absent_textField.setBounds(150, 70, 40, 20);
                absent_textField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (!Character.isDigit(e.getKeyChar())) {
                            e.consume(); // Consume the event to prevent it from being processed
                        }
                    }
                });
                salaryInformation_panel.add(absent_textField);
                
                // hours working text
                JLabel hoursWorking = new JLabel("Hours working:");
                hoursWorking.setBounds(265, 15, 90, 20);
                salaryInformation_panel.add(hoursWorking);
                
                // hours working text field
                JTextField hoursWorking_textField = new JTextField();
                hoursWorking_textField.setBounds(365, 15, 85, 20);
                hoursWorking_textField.addKeyListener(new KeyAdapter(){
                   @Override
                   public void keyTyped(KeyEvent e) {
                       char ch = e.getKeyChar();
                       if(!Character.isDigit(ch) && ch != '.'){
                           e.consume();
                       }
                   }
                });
                salaryInformation_panel.add(hoursWorking_textField);
                
                //hours overtime text
                JLabel hoursOverTime = new JLabel("Hours OverTime:");
                hoursOverTime.setBounds(265, 45, 120, 20);
                salaryInformation_panel.add(hoursOverTime);
                
                //hours overtime text field
                JTextField hoursOverTime_textField = new JTextField();
                hoursOverTime_textField.setBounds(365, 48, 85, 20);
                hoursOverTime_textField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyTyped(KeyEvent e){
                        char ch = e.getKeyChar();
                        if(!Character.isDigit(ch) && ch != '.'){
                            e.consume();
                        }
                    }    
                });
                salaryInformation_panel.add(hoursOverTime_textField);
                
                //regular pay text
                JLabel regularPay = new JLabel("Regular Pay:");
                regularPay.setBounds(470, 15, 90, 20);
                salaryInformation_panel.add(regularPay);
                
                //regular pay text field
                JTextField regularPay_textField = new JTextField();
                regularPay_textField.setBounds(550, 15, 85, 20);
                salaryInformation_panel.add(regularPay_textField);
                
                //overtime pay text
                JLabel overtimePay = new JLabel("Overtime Pay:");
                overtimePay.setBounds(470, 45, 90, 20);
                salaryInformation_panel.add(overtimePay);
                
                //overtime pay text field
                JTextField overtimePay_textField = new JTextField();
                overtimePay_textField.setBounds(550, 45, 85, 20);
                salaryInformation_panel.add(overtimePay_textField);
                
                //gross pay text
                JLabel grossPay = new JLabel("Gross pay:");
                grossPay.setBounds(472,70, 90, 20);
                salaryInformation_panel.add(grossPay);
                
                //gross pay text field
                JTextField grossPay_textField = new JTextField();
                grossPay_textField.setBounds(550, 70, 85, 20);
                salaryInformation_panel.add(grossPay_textField);
                
                //compute button
                JButton compute_button = new JButton("Compute");
                compute_button.setBounds(300, 75, 90, 20);
        informationPanel.add(salaryInformation_panel, BorderLayout.SOUTH);
        frame.add(informationPanel, BorderLayout.NORTH);
        
        //Footer Panel
        JPanel footer = new JPanel(new BorderLayout());
            footer.setLayout(new GridLayout(2, 2, 5, 0));
            
            //earnings section
            JPanel earnings_panel = new JPanel();
            TitledBorder earnings_border = BorderFactory.createTitledBorder("Earnings");
            earnings_border.setTitleColor(Color.BLUE);
            earnings_panel.setBorder(earnings_border);
            earnings_panel.setBackground(new Color(128, 128, 255));
            earnings_panel.setPreferredSize(new Dimension(350, 160));
                
                earnings_panel.setLayout(null);
                JLabel allowance = new JLabel("Allowance");
                allowance.setBounds(10, 15, 80, 20);
                earnings_panel.add(allowance);
                
                JLabel amount = new JLabel("Amount");
                amount.setBounds(190, 15, 80, 20);
                earnings_panel.add(amount);
                
                //transaction allowance text
                JLabel transactionAllowance = new JLabel("TRANSACTION ALLOWANCE:");
                transactionAllowance.setBounds(10, 45, 200, 20);
                earnings_panel.add(transactionAllowance);
                
                //transaction allowance text field
                JTextField transactionAllowance_textField = new JTextField();
                transactionAllowance_textField.setBounds(180, 45, 105, 20);
                transactionAllowance_textField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e){
                        char ch = e.getKeyChar();
                        if(!Character.isDigit(ch) && ch != '.'){
                            e.consume();
                        }
                    }
                });
                earnings_panel.add(transactionAllowance_textField);
                
                //incentives text
                JLabel incentives = new JLabel("INCENTIVES");
                incentives.setBounds(13, 70, 90, 20);
                earnings_panel.add(incentives);
                
                //incentives text field
                JTextField incentives_textField = new JTextField();
                incentives_textField.setBounds(180, 70, 105, 20);
                incentives_textField.addKeyListener(new KeyAdapter(){
                   @Override
                   public void keyTyped(KeyEvent e){
                       char ch = e.getKeyChar();
                       if(!Character.isDigit(ch) && ch != '.'){
                           e.consume();
                       }
                   }
                });
                earnings_panel.add(incentives_textField);
                
                //total allowance text
                JLabel totalAllowance = new JLabel("TOTAL ALLOWANCE:");
                totalAllowance.setBounds(55, 125, 150, 20);
                earnings_panel.add(totalAllowance);
                
                //total allowance text field
                JTextField totalAllowance_textField = new JTextField();
                totalAllowance_textField.setBounds(180, 125, 105, 20);
                earnings_panel.add(totalAllowance_textField);
                
                //uniform allowance text
                JLabel uniformAllowance = new JLabel("UNIFORM ALLOWANCE");
                uniformAllowance.setBounds(13, 95, 130, 20);
                earnings_panel.add(uniformAllowance);
                
                //uniform allowance text field
                JTextField uniformAllowance_textField = new JTextField();
                uniformAllowance_textField.setBounds(180, 95, 105, 20);
                uniformAllowance_textField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyTyped(KeyEvent e){
                        char ch = e.getKeyChar();
                        if(!Character.isDigit(ch) && ch != '.'){
                            e.consume();
                        }
                    }
                });
                
            JPanel earnings = new JPanel(new BorderLayout());
                earnings.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
                earnings.add(earnings_panel, BorderLayout.NORTH);
            footer.add(earnings, BorderLayout.WEST);
            
            //deduction section
            JPanel deductions_panel = new JPanel();
            TitledBorder deductions_border = BorderFactory.createTitledBorder("Deductions");
            deductions_border.setTitleColor(Color.BLUE);
            deductions_panel.setBorder(deductions_border);
            deductions_panel.setBackground(new Color(128, 128, 255));
            deductions_panel.setPreferredSize(new Dimension(350, 160));
                
                deductions_panel.setLayout(null);
                //deduction text
                JLabel deduction = new JLabel("Deduction");
                deduction.setBounds(10, 15, 90, 20);
                deductions_panel.add(deduction);
                
                JLabel deduction_amount = new JLabel("Amount");
                deduction_amount.setBounds(195, 15, 80, 20);
                deductions_panel.add(deduction_amount);
                
                //pera/sss text
                JLabel peraSSS = new JLabel("PERA/SSS");
                peraSSS.setBounds(10, 35, 85, 20);
                deductions_panel.add(peraSSS);
                
                //pera/sss text field
                JTextField peraSSS_textField = new JTextField();
                peraSSS_textField.setBounds(190, 35, 85, 15);
                peraSSS_textField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyTyped(KeyEvent e){
                        char ch = e.getKeyChar();
                        if(!Character.isDigit(ch) && ch != '.'){
                            e.consume();
                        }
                    }
                });
                deductions_panel.add(peraSSS_textField);
                
                //sss loan text
                JLabel sssLoan = new JLabel("SSS LOAN");
                sssLoan.setBounds(10, 55, 90, 20);
                deductions_panel.add(sssLoan);
                
                //sss loan text field
                JTextField sssLoan_textField = new JTextField();
                sssLoan_textField.setBounds(190, 55, 85, 15);
                sssLoan_textField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyTyped(KeyEvent e){
                        char ch = e.getKeyChar();
                        if(!Character.isDigit(ch) && ch != '.'){
                            e.consume();
                        }
                    }
                });
                deductions_panel.add(sssLoan_textField);
                
                //gsis text
                JLabel gsis = new JLabel("GSIS");
                gsis.setBounds(10, 75, 85, 20);
                deductions_panel.add(gsis);
                
                //gsis text field
                JTextField gsis_textField = new JTextField();
                gsis_textField.setBounds(190, 75, 85, 15);
                gsis_textField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyTyped(KeyEvent e){
                        char ch = e.getKeyChar();
                        if(!Character.isDigit(ch) && ch != '.'){
                            e.consume();
                        }
                    }
                });

                deductions_panel.add(gsis_textField);
                
                //tax withheld text
                JLabel taxWithheld = new JLabel("TAX WITHHELD");
                taxWithheld.setBounds(10, 95, 100, 20);
                deductions_panel.add(taxWithheld);
                
                //tax withheld text field
                JTextField taxWithheld_textField = new JTextField();
                taxWithheld_textField.setBounds(190, 95, 85, 15);
                taxWithheld_textField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyTyped(KeyEvent e){
                        char ch = e.getKeyChar();
                        if(!Character.isDigit(ch) && ch != '.'){
                            e.consume();
                        }
                    }
                });

                deductions_panel.add(taxWithheld_textField);
                
                //tardiness text
                JLabel tardiness = new JLabel("TARDINESS");
                tardiness.setBounds(10, 115, 85, 20);
                deductions_panel.add(tardiness);
                
                //tardiness text field
                JTextField tardiness_textField = new JTextField();
                tardiness_textField.setBounds(190, 115, 85, 15);
                deductions_panel.add(tardiness_textField);
                
                //total deductions text
                JLabel totalDeductions = new JLabel("TOTAL DEDUCTIONS");
                totalDeductions.setBounds(10, 135, 120, 20);
                deductions_panel.add(totalDeductions);
                
                //total deductions text field
                JTextField totalDeductions_textField = new JTextField();
                totalDeductions_textField.setBounds(190, 135, 85, 15);
                deductions_panel.add(totalDeductions_textField);
            
            JPanel deductions = new JPanel(new BorderLayout());
                deductions.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
                deductions.add(deductions_panel, BorderLayout.NORTH);
            footer.add(deductions, BorderLayout.EAST);
            
            //summary section
            JPanel summary_panel = new JPanel();
            TitledBorder summary_border = BorderFactory.createTitledBorder("SUMMARY");
            summary_border.setTitleColor(Color.BLUE);
            summary_panel.setBorder(summary_border);
            summary_panel.setBackground(new Color(128, 128, 255));
            summary_panel.setPreferredSize(new Dimension(354, 90));
            
                summary_panel.setLayout(null);
                //gross pay php text
                JLabel grossPayPhp = new JLabel("GROSS PAY:                          PHP");
                grossPayPhp.setBounds(10, 25, 200, 20);
                summary_panel.add(grossPayPhp);
                
                //gross pay php text field
                JTextField grossPayPhp_textField = new JTextField();
                grossPayPhp_textField.setBounds(200, 25, 90, 20);
                summary_panel.add(grossPayPhp_textField);
                
                //total allowance php text
                JLabel  totalAllowancePhp = new JLabel("TOTAL ALLOWANCE:          PHP");
                totalAllowancePhp.setBounds(10, 50, 200, 20);
                summary_panel.add(totalAllowancePhp);
                
                //total allowance php text field
                JTextField totalAllowancePhp_textField = new JTextField();
                totalAllowancePhp_textField.setBounds(200, 50, 90, 20);
                summary_panel.add(totalAllowancePhp_textField);                
                
                //total deduction php text
                JLabel totalDeductionPhp = new JLabel("TOTAL DEDUCTIONS:          PHP");
                totalDeductionPhp.setBounds(10, 80, 200, 20);
                summary_panel.add(totalDeductionPhp);
                
                //total deduction php text field
                JTextField totalDeductionPhp_textField = new JTextField();
                totalDeductionPhp_textField.setBounds(200, 80, 90, 20);
                summary_panel.add(totalDeductionPhp_textField);
                
                //net pay php text
                JLabel netPayPhp = new JLabel("NET PAY:     PHP");
                netPayPhp.setBounds(50, 115, 200, 20);
                netPayPhp.setForeground(new Color(102, 26, 255));
                summary_panel.add(netPayPhp);
                
                //net pay php text field
                JTextField netPayPhp_textField =new JTextField();
                netPayPhp_textField.setBounds(200, 115, 90, 20);
                summary_panel.add(netPayPhp_textField);
            
            JPanel summary = new JPanel(new BorderLayout());
                summary.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
                summary.add(summary_panel, BorderLayout.WEST);
            footer.add(summary, BorderLayout.SOUTH);

            //received section            
            JPanel received_panel = new JPanel();
            received_panel.setBackground(new Color(128, 128, 255));
            received_panel.setPreferredSize(new Dimension(350, 90));
            
                received_panel.setLayout(null);
                JLabel receivedBy = new JLabel("RECEIVED BY:");
                receivedBy.setBounds(10, 20, 100, 20);
                received_panel.add(receivedBy);
                
                JLabel employee_name = new JLabel("");
                employeeName_textField.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        employee_name.setText(employeeName_textField.getText());
                    }
                });
                employee_name.setBounds(120, 60, 200, 20);
                received_panel.add(employee_name);
                
                JLabel separator = new JLabel("");
                separator.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));                
                separator.setBounds(70, 90, 200, 20);
                received_panel.add(separator);
                
                JLabel signature = new JLabel("Signature");
                signature.setBounds(140, 110, 85, 20);
                received_panel.add(signature);
            
            JPanel received = new JPanel(new BorderLayout());
                received.setBorder(BorderFactory.createEmptyBorder(5, 0, 5,0));
                received.add(received_panel, BorderLayout.EAST);
            footer.add(received, BorderLayout.SOUTH);
            frame.add(footer, BorderLayout.CENTER);
        
        //buttons
        JPanel buttons = new JPanel();
            buttons.add(new JButton("Print"));
            
            JButton clear = new JButton("Clear");
        
            buttons.add(clear);
            
            JButton exit = new JButton("Exit");
            exit.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e){
                   frame.dispose();
               }
            });
            buttons.add(exit);
            
            buttons.setPreferredSize(new Dimension(350, 40));
        frame.add(buttons, BorderLayout.SOUTH);
        
        //compute button
                        compute_button.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        try {
                            double hourlyRate = Double.parseDouble(salaryRate_textField.getText()) / 8;
                            double regularPay_value = hourlyRate * Double.parseDouble(hoursWorking_textField.getText());
                            regularPay_textField.setText(String.format("%.2f", regularPay_value));
                            double overTimePay = Double.parseDouble(hoursOverTime_textField.getText()) * (Double.parseDouble(salaryRate_textField.getText()) / 8) * 1.1;
                            overtimePay_textField.setText(String.format("%.2f",overTimePay));
                            double grossPay_value = regularPay_value + overTimePay;
                            grossPay_textField.setText(String.format("%.2f", grossPay_value));
                            
                            //gross pay php
                            grossPayPhp_textField.setText(String.format("%.2f", grossPay_value));
                            
                            //tardiness
                            double late_arrival = Integer.parseInt(late_textField.getText()) / 60.0;
                            double absences = Integer.parseInt(absent_textField.getText()) * Double.parseDouble(salaryRate_textField.getText());
                            tardiness_textField.setText(String.format("%.2f", hourlyRate * late_arrival + absences));
                            
                            //gsis value
                            String salaryLevel_value = salaryLevel_textField.getText();
                            double gsis_value = Double.parseDouble(regularPay_textField.getText());
                            if(salaryLevel_value.equals("1")){
                                gsis_value *= 0.01;
                                gsis_textField.setText(String.format("%.2f", gsis_value));
                            } 
                            else if(salaryLevel_value.equals("2")){
                                gsis_value *= 0.015;
                                gsis_textField.setText(String.format("%.2f", gsis_value));
                            }
                            else if(salaryLevel_value.equals("3")){
                                gsis_value *= 0.02;
                                gsis_textField.setText(String.format("%.2f", gsis_value));
                            }
                            else if(salaryLevel_value.equals("4")){
                                gsis_value *= 0.03;
                                gsis_textField.setText(String.format("%.2f", gsis_value));
                            }
                            else if(salaryLevel_value.equals("5")){
                                gsis_value *= 0.04;
                                gsis_textField.setText(String.format("%.2f", gsis_value));
                            }
                            else {
                                gsis_textField.setText("0.00");
                            }
                        } catch(NumberFormatException a) {
                        }
                    }
                });
                salaryInformation_panel.add(compute_button);
                
                //uniform allowance text field function
                uniformAllowance_textField.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        double totalAllowance_value =
                        Double.parseDouble(transactionAllowance_textField.getText()) +
                        Double.parseDouble(incentives_textField.getText()) +
                        Double.parseDouble(uniformAllowance_textField.getText());
                        
                        totalAllowance_textField.setText(String.format("%.2f", totalAllowance_value));
                        totalAllowancePhp_textField.setText(String.format("%.2f", totalAllowance_value));
                    }
                });
                earnings_panel.add(uniformAllowance_textField);
                
                //tax withheld text field function
                taxWithheld_textField.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e){
                       double totalDeductions_value = Double.parseDouble(peraSSS_textField.getText()) +
                               Double.parseDouble(sssLoan_textField.getText()) + 
                               Double.parseDouble(gsis_textField.getText()) +
                               Double.parseDouble(taxWithheld_textField.getText()) +
                               Double.parseDouble(tardiness_textField.getText());
                       totalDeductions_textField.setText(String.format("%.2f", totalDeductions_value));
                       totalDeductionPhp_textField.setText(String.format("%.2f", totalDeductions_value));
                       
                       //net pay text field value
                       double netPayPhp_value = Double.parseDouble(grossPayPhp_textField.getText()) +
                               Double.parseDouble(totalAllowancePhp_textField.getText()) - 
                               Double.parseDouble(totalDeductionPhp_textField.getText());
                       netPayPhp_textField.setText(String.format("%.2f", netPayPhp_value));
                   }
                });

        
        frame.setLocationRelativeTo(null);
        frame.setResizable(false); //disallowed resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // make the frame visible

    }
}
