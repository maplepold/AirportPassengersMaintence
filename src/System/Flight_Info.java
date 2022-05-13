/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System;

/**
 *
 * @author Dennis
 */
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Flight_Info extends JFrame{  //Second Frame

    private JTable table;
    private JTextField textField;
    
    public static void main(String[] args){		 
	new Flight_Info().setVisible(true);    
    }
    
    public Flight_Info(){
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Montserrat", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
		
	JLabel Fcode = new JLabel("FLIGHT CODE");
	Fcode.setFont(new Font("Montserrat", Font.PLAIN, 17));
        Fcode.setBounds(50, 100, 200, 30);
	add(Fcode);
	
		
	JLabel FlightDetails = new JLabel("FLIGHT INFORMATION");
	FlightDetails.setFont(new Font("Montserrat", Font.PLAIN, 31));
	FlightDetails.setForeground(new Color(100, 149, 237));
	FlightDetails.setBounds(50, 20, 570, 35);
	add(FlightDetails);
		
	JButton btnShow = new JButton("SHOW");
	btnShow.setFont(new Font("Montserrat", Font.PLAIN, 20));
	
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	
                String code = textField.getText();           
                
                try {
                    Connector c = new Connector();
                    String str = "select f_code,src,dst,capacity,class_name from flight ,airplane_sector where f_code = '"+code+"'and flight.f_name = airplane_sector.f_name" ;
      
                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));	
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });

        btnShow.setBounds(220, 150, 120, 30);
	add(btnShow);
		
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 230, 800, 90);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 240, 800, 90);
        pane.setBackground(Color.WHITE);
        add(pane);
		
	textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
	add(textField);
		
	JLabel FlightCode = new JLabel("FLIGHT CODE");
	FlightCode.setFont(new Font("Montserrat", Font.PLAIN, 13));
        FlightCode.setBounds(65, 220, 126, 20);
	add(FlightCode);
		
	JLabel Source = new JLabel("FROM");
	Source.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Source.setBounds(245, 220, 104, 20);
	add(Source);
		
	JLabel Destination = new JLabel("TO");
	Destination.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Destination.setBounds(410, 220, 104, 20);
	add(Destination);
		
	JLabel Capacity = new JLabel("CAPACITY");
	Capacity.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Capacity.setBounds(545, 220, 111, 20);
	add(Capacity);
        
        JLabel ClassName = new JLabel("CLASS NAME");
	ClassName.setFont(new Font("Montserrat", Font.PLAIN, 13));
	ClassName.setBounds(700, 220, 111, 20);
	add(ClassName);
			
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(400,200);
		
    }
}
