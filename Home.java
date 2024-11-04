
package AMS;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
    
    Home(){
        
        setTitle("Aerious Airways Home Page");
        setSize(400,300);
        
        setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/f9.jpg"));
        JLabel image=new JLabel(img);
        image.setBounds(0,0,1800,800);
        add(image);
        
        JLabel heading=new JLabel("AERIOUS AIRWAYS WELCOMES YOU");
        heading.setBounds(350,50,1000,60);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma",Font.ITALIC,40));
        image.add(heading);
        
        JMenuBar menubar=new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu passdetails=new JMenu("Passenger Details");
        menubar.add(passdetails);
        
        JMenuItem passengerDetails = new JMenuItem("Add Passenger Details");
        passengerDetails.addActionListener(this);
        passdetails.add(passengerDetails);
        
        JMenuItem viewpassengerDetails = new JMenuItem("View Passenger Details");
        passdetails.add(viewpassengerDetails);
        
        
//        JMenu managedetails=new JMenu("Manage Passenger Details");
//        menubar.add(managedetails);
//        
//        JMenuItem updateDetails = new JMenuItem("Upddate Details");
//        managedetails.add(updateDetails);
        
        
        JMenu flidetails=new JMenu("Flight Details");
        menubar.add(flidetails);
        
        JMenuItem flightDetails = new JMenuItem("Check Flight Details");
        flightDetails.addActionListener(this);
        flidetails.add(flightDetails);
        
        
        JMenu yourflight=new JMenu("Your Flight");
        menubar.add(yourflight);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
         bookFlight.addActionListener(this);
        yourflight.add(bookFlight);
        
         JMenuItem journeyDetails = new JMenuItem("Journey Details");
          journeyDetails.addActionListener(this);
        yourflight.add(journeyDetails);
        
        
          JMenu ticket=new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
         boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
    
         JMenu cancelflight=new JMenu("Cancellation");
        menubar.add(cancelflight);
        
         JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
          ticketCancellation.addActionListener(this);
        cancelflight.add(ticketCancellation);
        
        
        JMenu logout=new JMenu("Logout");
        menubar.add(logout);
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        logout.add(exit);
        

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
       
    }
    public void actionPerformed(ActionEvent e){
       String text=e.getActionCommand();
       
       if(text.equals("Add Passenger Details")){
           new AddPassengerDetails();
       }
       else if(text.equals("Check Flight Details")){
           new FlightInfo();
       }
       else if(text.equals("Book Flight")){
           new BookFlight();
       }
       else if(text.equals("Journey Details")){
           new JourneyDetails();
       }
       else if(text.equals("Cancel Ticket")){
           new Cancel();
       }
       else if(text.equals("Boarding Pass")){
           new BoardingPass();
       }
       else if(text.equals("Exit")){
           setVisible(false);
       }
    }
    public static void main(String args[]){
        new Home();
    }
}