/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System;

/**
 *
 * @author Dennis
 */
import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JLabel;

public class Customer extends JFrame{ //Third Frame

    
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;

        public Customer(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD CUSTOMER DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Flightcode = new JLabel("FLIGHT CODE");
            Flightcode.setFont(new Font("Montserrat", Font.PLAIN, 17));
            Flightcode.setBounds(60, 30, 150, 27);
            add(Flightcode);

            textField = new JTextField();
            textField.setBounds(200, 30, 150, 27);
            add(textField);
            
            JLabel Name = new JLabel("NAME");
            Name.setFont(new Font("Montserrat", Font.PLAIN, 17));
            Name.setBounds(60, 75, 150, 27);
            add(Name);
	
            textField_1 = new JTextField();
            textField_1.setBounds(200, 75, 150, 27);
            add(textField_1);
            
            JLabel Passportno = new JLabel("PASSPORT NO");
            Passportno.setFont(new Font("Montserrat", Font.PLAIN, 17));
            Passportno.setBounds(60, 120, 150, 27);
            add(Passportno);
            
            textField_2 = new JTextField();
            textField_2.setBounds(200, 120, 150, 27);
            add(textField_2);
			
            JLabel Pnrno = new JLabel("PNR NO");
            Pnrno.setFont(new Font("Montserrat", Font.PLAIN, 17));
            Pnrno.setBounds(60, 165, 150, 27);
            add(Pnrno);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 165, 150, 27);
            add(textField_3);
            
            JLabel Address = new JLabel("ADDRESS");
            Address.setFont(new Font("Montserrat", Font.PLAIN, 17));
            Address.setBounds(60, 210, 150, 27);
            add(Address);
			
            textField_4 = new JTextField();
            textField_4.setBounds(200, 210, 150, 27);
            add(textField_4);
            		
            JLabel Nationality = new JLabel("NATIONALITY");
            Nationality.setFont(new Font("Montserrat", Font.PLAIN, 17));
            Nationality.setBounds(60, 255, 150, 27);
            add(Nationality);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 255, 150, 27);
            add(textField_5);
	
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Montserrat", Font.PLAIN, 17));
            Gender.setBounds(60, 300, 150, 27);
            add(Gender);
		
            JRadioButton NewRadioButton = new JRadioButton("MALE");
            NewRadioButton.setBackground(Color.WHITE);
            NewRadioButton.setBounds(200, 300, 70, 27);
            add(NewRadioButton);
	
            JRadioButton Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(280, 300, 70, 27);
            add(Female);
            
            JLabel Phno = new JLabel("PH NO");
            Phno.setFont(new Font("Montserrat", Font.PLAIN, 17));
            Phno.setBounds(60, 345, 150, 27);
            add(Phno);
			
            textField_6 = new JTextField();
            textField_6.setBounds(200, 345, 150, 27);
            add(textField_6);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD CUSTOMER DETAILS");
            AddPassengers.setForeground(Color.BLACK);
            AddPassengers.setFont(new Font("Montserrat", Font.PLAIN, 31));
            AddPassengers.setBounds(420, 24, 442, 35);
            add(AddPassengers);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 400, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Cus2.png"));
            JLabel image = new JLabel(i1);
            image.setBounds(450,80,280,410);
            add(image);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String f_code = textField.getText();
                    String name = textField_1.getText();
                    String passport_No = textField_2.getText();
                    String pnr_no = textField_3.getText();
                    String address =  textField_4.getText();
                    String nationality = textField_5.getText();
                    
                   
                   
                    String gender = null;
                    String ph_no = textField_6.getText();
                    
                    if(NewRadioButton.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }
                    
                    try {
                        Connector c = new Connector();
                        String str = "INSERT INTO passenger values( '"+pnr_no+"', '"+address+"', '"+nationality+"','"+name+"', '"+gender+"', '"+ph_no+"','"+passport_No+"', '"+f_code+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Customer Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });
			
            setSize(900,600);
            setVisible(true);
            setLocation(400,200);
			
	}
        
    public static void main(String[] args){
        new Customer();
    }   
}
    

