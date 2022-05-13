/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System;

/**
 *
 * @author Dennis
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Payment extends JFrame{ //Fifth

    JTextField textField;
    JTable table;
    JLabel Sector;
    JLabel FlightCode, Capacity, Classcode, Classname, label;

    public static void main(String[] args) {
        new Payment();
    }

    public Payment(){
	initialize();
    }

    private void initialize(){
        setTitle("PAYMENT DETAILS");
	getContentPane().setBackground(Color.WHITE);
	setSize(860,486);
	setLayout(null);
		
	JLabel Fcode = new JLabel("PNR CODE");
	Fcode.setFont(new Font("Montserrat", Font.PLAIN, 17));
	Fcode.setBounds(60, 160, 150, 26);
	add(Fcode);
		
	textField = new JTextField();
	textField.setBounds(200, 160, 150, 26);
	add(textField);
	
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(45, 315, 770, 87);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(45, 320, 790, 100);
        pane.setBackground(Color.WHITE);
        add(pane);
       	
	JButton Show = new JButton("SHOW");
	Show.setFont(new Font("Montserrat", Font.PLAIN, 17));
        Show.setBackground(Color.BLACK);
        Show.setForeground(Color.WHITE);
	Show.setBounds(200, 210, 150, 26);
	add(Show);
		
	Sector = new JLabel("PAYMENT DETAILS");
	Sector.setForeground(Color.BLACK);
	Sector.setFont(new Font("Montserrat", Font.PLAIN, 31));
	Sector.setBounds(51, 17, 300, 39);
	add(Sector);
		
	FlightCode = new JLabel("PNR CODE");
	FlightCode.setFont(new Font("Montserrat", Font.PLAIN, 13));
	FlightCode.setBounds(92, 298, 108, 26);
	add(FlightCode);
		
	Capacity = new JLabel("PAID AMOUNT");
	Capacity.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Capacity.setBounds(237, 298, 92, 26);
	add(Capacity);
		
	Classcode = new JLabel("PAY DATE");
	Classcode.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Classcode.setBounds(406, 298, 70, 26);
	add(Classcode);
		
		
	label = new JLabel("");
	label.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icons/payment.png")));
	label.setBounds(425, 15, 239, 272);
	add(label);
		
	JLabel Cardno = new JLabel("CARD NUMBER");
	Cardno.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Cardno.setBounds(544, 298, 101, 26);
	add(Cardno);
		
	JLabel Phoneno = new JLabel("PHONE NUMBER");
	Phoneno.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Phoneno.setBounds(698, 298, 120, 26);
	add(Phoneno);
	
        setVisible(true);
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                try {
                    String code  = textField.getText();
                    
                    Connector c = new Connector();
                    String str = "select pnr_no,paid_amt,pay_date,card_no,ph_no from payment where pnr_no = '"+code+"'";
					
                    ResultSet rs = c.s.executeQuery(str);
		
                    table.setModel(DbUtils.resultSetToTableModel(rs));
					
		}catch(SQLException e) {
                    e.printStackTrace();
                }
            }
	});
		
	setSize(960,590);
        setLocation(400,200);
	setVisible(true);

    }
}

