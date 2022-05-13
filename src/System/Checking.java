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

public class Checking extends JFrame{ 

    static void addActionListener(ActionListener actionListener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//Fifth

    JTextField textField;
    JTable table;
    JLabel Sector;
    JLabel FlightCode,Name,Phone,src, dst,JNY_date,JNY_time;

    public static void main(String[] args) {
        new Checking();
    }

    public Checking(){
	initialize();
    }

    private void initialize(){
        setTitle("CHECK");
	getContentPane().setBackground(Color.WHITE);
	setSize(860,486);
	setLayout(null);
		
	JLabel Fcode = new JLabel("PNR CODE");
	Fcode.setFont(new Font("Montserrat", Font.PLAIN, 17));
	Fcode.setBounds(60, 100, 150, 26);
	add(Fcode);
		
	textField = new JTextField();
	textField.setBounds(180, 100, 150, 26);
	add(textField);
	
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(45, 175, 770, 100);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(45, 185, 790, 100);
        pane.setBackground(Color.WHITE);
        add(pane);
       	
	JButton Show = new JButton("SHOW");
	Show.setFont(new Font("Montserrat", Font.PLAIN, 17));
        Show.setBackground(Color.BLACK);
        Show.setForeground(Color.WHITE);
	Show.setBounds(350, 100, 150, 26);
	add(Show);
		
	Sector = new JLabel("CHECK CONFIRMED PASSENGERS");
	Sector.setForeground(Color.BLACK);
	Sector.setFont(new Font("Montserrat", Font.PLAIN, 31));
	Sector.setBounds(51, 17, 800, 39);
	add(Sector);
		
	FlightCode = new JLabel("FLIGHT CODE");
	FlightCode.setFont(new Font("Montserrat", Font.PLAIN, 13));
	FlightCode.setBounds(58, 160, 108, 26);
	add(FlightCode);
		
	Name = new JLabel("NAME");
	Name.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Name.setBounds(197, 160, 100, 26);
	add(Name);
		
	Phone = new JLabel("PHONE");
	Phone.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Phone.setBounds(305, 160, 70, 26);
	add(Phone);
		
		
	JLabel src = new JLabel("FROM");
	src.setFont(new Font("Montserrat", Font.PLAIN, 13));
	src.setBounds(420, 160, 101, 26);
	add(src);
		
	JLabel dst = new JLabel("TO");
	dst.setFont(new Font("Montserrat", Font.PLAIN, 13));
	dst.setBounds(545, 160, 120, 26);
	add(dst);
        
        JLabel JNY_date = new JLabel("DATE");
	JNY_date.setFont(new Font("Montserrat", Font.PLAIN, 13));
	JNY_date.setBounds(650, 160, 120, 26);
	add(JNY_date);
        
        JLabel JNY_time = new JLabel("TIME");
	JNY_time.setFont(new Font("Montserrat", Font.PLAIN, 13));
	JNY_time.setBounds(760, 160, 120, 26);
	add(JNY_time);
	
        setVisible(true);
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                try {
                    String code  = textField.getText();
                    
                    Connector c = new Connector();
                    String str = "select distinct fl_code,name,ph_no,src,dst,jny_date,jny_time from passenger,reservation where passenger.pnr_no = '"+code+"' and passenger.pnr_no =reservation.pnr_no";
					
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

