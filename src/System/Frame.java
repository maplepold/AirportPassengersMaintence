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
import javax.swing.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Frame extends JFrame{

    public static void main(String[] args) {
        new Frame().setVisible(true);
    }
    
    public Frame() {
        super("AIRPORT PASSENGERS MAINTENANCE SYSTEM");
        initialize();
    }

    
    private void initialize() {
	
        setForeground(Color.CYAN);
        setLayout(null); 

        JLabel NewLabel = new JLabel("");
	NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icons/remain1.png")));
	NewLabel.setBounds(55, 0, 2100, 670); 
	add(NewLabel); 
        
        JLabel AirlineManagementSystem = new JLabel("VIETNAM AIRLINE - REACH FURTHER");
	AirlineManagementSystem.setForeground(Color.YELLOW);
        AirlineManagementSystem.setFont(new Font("Montserrat", Font.PLAIN, 45));
	AirlineManagementSystem.setBounds(400, 35, 1000, 55);
	NewLabel.add(AirlineManagementSystem);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu AirlineSystem = new JMenu("AIRLINE SYSTEM");
        AirlineSystem.setForeground(Color.BLUE);
	menuBar.add(AirlineSystem);
		
        JMenuItem FlightDetails = new JMenuItem("FLIGHT INFORMATION");
	AirlineSystem.add(FlightDetails);
		
	JMenuItem ReservationDetails = new JMenuItem("CUSTOMER DETAILS");
	AirlineSystem.add(ReservationDetails);
		
	JMenuItem Schedule = new JMenuItem("SCHEDULE");
	AirlineSystem.add(Schedule);
		
	JMenuItem SectorDetails_1 = new JMenuItem("PAYMENT DETAILS");
	AirlineSystem.add(SectorDetails_1);
		
	JMenuItem Cancellation = new JMenuItem("CANCELLATION");
	AirlineSystem.add(Cancellation);
		
	JMenuItem Checking = new JMenuItem("CHECK");
	AirlineSystem.add(Checking);	 
		
	FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Flight_Info();
            }
	});
        
	ReservationDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Customer();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
		
        Schedule.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Schedule();
                } catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        SectorDetails_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Payment();
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        Cancellation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Cancel();
            }
	});
	
        Checking.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Checking();
            }
	});
        
        setSize(1920,1090);
	setVisible(true);
    }
}

