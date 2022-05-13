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

public class Schedule extends JFrame{  //Forth

    JTable table;
    JLabel ReservationDetails,Fcode,Fname,Jnydate,Jnytime,From,To,label,label1;
    JButton Show;

    public static void main(String[] args){
        new Schedule();
    }
    
    public Schedule(){
        
        setTitle("JOURNEY DETAILS");
	getContentPane().setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setLayout(null);
		
	From = new JLabel("FROM");
	From.setFont(new Font("Montserrat", Font.PLAIN, 19));
	From.setBounds(60, 100, 150, 27);
	add(From);
	
        To = new JLabel("TO");
	To.setFont(new Font("Montserrat", Font.PLAIN, 19));
	To.setBounds(450, 100, 150, 27);
	add(To);
			
	Show = new JButton("SHOW");
	Show.setBounds(680, 100, 100, 30);
	add(Show);
        	
	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	ReservationDetails = new JLabel("JOURNEY DETAILS");
	ReservationDetails.setForeground(Color.BLACK);
	ReservationDetails.setFont(new Font("Montserrat", Font.PLAIN, 31));
	ReservationDetails.setBounds(280, 27, 359, 31);
	add(ReservationDetails);
						
	Fcode = new JLabel("FLIGHT CODE");
	Fcode.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Fcode.setBounds(43, 185, 110, 20);
	add(Fcode);
		
        Fname = new JLabel("FLIGHT NAME");
	Fname.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Fname.setBounds(170, 185, 150, 20);
	add(Fname);
        
	Jnydate = new JLabel("DATE");
	Jnydate.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Jnydate.setBounds(300, 185, 104, 20);
	add(Jnydate);
		
	Jnytime = new JLabel("TIME");
	Jnytime.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Jnytime.setBounds(429, 185, 130, 20);
	add(Jnytime);
		
	From = new JLabel("FROM");
	From.setFont(new Font("Montserrat", Font.PLAIN, 13));
	From.setBounds(558, 185, 80, 20);
	add(From);
		
	To = new JLabel("TO");
	To.setFont(new Font("Montserrat", Font.PLAIN, 13));
	To.setBounds(683, 185, 80, 20);
	add(To);
     
        
	String[] items1 =  {"HO CHI MINH","HA NOI","DA NANG","PHU QUOC","NHA TRANG","BUON MA THUOT","CA MAU","CAN THO","CHU LAI","CON DAO","DALAT","DIEN BIEN","DONG HOI","HAI PHONG","HUE","PLEIKU","QUY NHON","RACH GIA","THANH HOA","TUY HOA","VAN DON","VINH"};
	JComboBox comboBox = new JComboBox(items1);
	comboBox.setBounds(150, 100, 150, 27);
	add(comboBox);
		
		
	String[] items2 =  {"HO CHI MINH","HA NOI","DA NANG","PHU QUOC","NHA TRANG","BUON MA THUOT","CA MAU","CAN THO","CHU LAI","CON DAO","DALAT","DIEN BIEN","DONG HOI","HAI PHONG","HUE","PLEIKU","QUY NHON","RACH GIA","THANH HOA","TUY HOA","VAN DON","VINH"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	add(comboBox_1);
        
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(38, 210, 770, 190);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(38, 210, 790, 190);
        pane.setBackground(Color.WHITE);
        add(pane);
	
		
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                    
                    Connector c = new Connector();
               
                    String str = "select f_code,f_name,jny_date,jny_time,src,dst from flight where src = '"+src+"' and dst = '"+dst+"'";
                    
                    ResultSet rs= c.s.executeQuery(str);
                    
                    if(rs.next()){
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }else{
                        JOptionPane.showMessageDialog(null,"No Flights from Source to Destination ");
                        
                    }					
                    
					
		}catch(Exception e){}
            }
	});
		
	setSize(860,600);
        setLocation(400,200);
	setVisible(true);
		
    }
}
