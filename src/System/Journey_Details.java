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

public class Journey_Details extends JFrame{  //Forth

    JTable table;
    JLabel ReservationDetails,Pnrno,Ticketid,Fcode,Jnydate,Jnytime,From,To,label,label1;
    JButton Show;

    public static void main(String[] args){
        new Journey_Details();
    }
    
    public Journey_Details(){
        
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
	ReservationDetails.setForeground(Color.BLUE);
	ReservationDetails.setFont(new Font("Montserrat", Font.PLAIN, 31));
	ReservationDetails.setBounds(280, 27, 359, 31);
	add(ReservationDetails);
		
	Pnrno = new JLabel("PNR CODE");
	Pnrno.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Pnrno.setBounds(50, 185, 90, 20);
	add(Pnrno);
		
	Ticketid = new JLabel("TICKET NO");
	Ticketid.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Ticketid.setBounds(160, 185, 90, 20);
	add(Ticketid);
		
	Fcode = new JLabel("FLIGHT NO");
	Fcode.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Fcode.setBounds(265, 185, 110, 20);
	add(Fcode);
		
	Jnydate = new JLabel("DEPARTURE DATE");
	Jnydate.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Jnydate.setBounds(370, 185, 130, 20);
	add(Jnydate);
		
	Jnytime = new JLabel("JOURNEY TIME");
	Jnytime.setFont(new Font("Montserrat", Font.PLAIN, 13));
	Jnytime.setBounds(525, 185, 130, 20);
	add(Jnytime);
		
	From = new JLabel("FROM");
	From.setFont(new Font("Montserrat", Font.PLAIN, 13));
	From.setBounds(665, 185, 80, 20);
	add(From);
		
	To = new JLabel("TO");
	To.setFont(new Font("Montserrat", Font.PLAIN, 13));
	To.setBounds(750, 185, 80, 20);
	add(To);
     
        
	String[] items1 =  {"HANOI","DA NANG","PHU QUOC","NHA TRANG","BUON MA THUOT","CA MAU","CAN THO","CHU LAI","CON DAO","DALAT","DIEN BIEN","DONG HOI","HAI PHONG","HUE","PLEIKU","QUY NHON","RACH GIA","THANH HOA","TUY HOA","VAN DON","VINH"};
	JComboBox comboBox = new JComboBox(items1);
	comboBox.setBounds(150, 100, 150, 27);
	add(comboBox);
		
		
	String[] items2 =  {"HANOI","DA NANG","PHU QUOC","NHA TRANG","BUON MA THUOT","CA MAU","CAN THO","CHU LAI","CON DAO","DALAT","DIEN BIEN","DONG HOI","HAI PHONG","HUE","PLEIKU","QUY NHON","RACH GIA","THANH HOA","TUY HOA","VAN DON","VINH"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	add(comboBox_1);
        
        table = new JTable();
	table.setBounds(38, 310, 770, 130);
	add(table);
	
		
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                    
                    Connector c = new Connector();
                    
                    String str = "select pnr_no,ticket_id,f_code,jny_date,jny_time,src,dst from reservation where src = '"+src+"' and dst = '"+dst+"'";
                    ResultSet rs=c.s.executeQuery(str);
                    
                    if(rs.next()){
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }else{
                        JOptionPane.showMessageDialog(null,"No Flights from FROM to TO ");
                        
                    }					
                    
					
		}catch(Exception e){}
            }
	});
		
	setSize(860,600);
        setLocation(400,200);
	setVisible(true);
		
    }
}
