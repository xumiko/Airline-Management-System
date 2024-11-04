package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    
    JButton fetchdetails,fetchflights,bookFlight;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l4N;
    JTextField tf1;
    Choice source,dest;
    JDateChooser dcdate;
    
    BookFlight(){
        
        setTitle("Book Flight");
        setSize(400,300);
        
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/ph8.jpg"));
        JLabel image=new JLabel(img);
        image.setBounds(0,0,650,1150);
        add(image);
        
        JLabel heading=new JLabel("Book Flight");
        heading.setBounds(220,30,250,40);
        heading.setFont(new Font("Arial",Font.BOLD,32));
        image.add(heading);
        
        l1=new JLabel("Aadhar no.");
        l1.setBounds(90,110,150,30);
        l1.setFont(new Font("Arial", Font.BOLD,20));
        l1.setForeground(Color.BLACK);
        image.add(l1);
        
        tf1=new JTextField();
        tf1.setBounds(240,110,150,25);
        image.add(tf1);
        
        fetchdetails=new JButton("Fetch Details");
        fetchdetails.setBounds(400,110,110,25);
        fetchdetails.setBackground(Color.BLACK);
        fetchdetails.setForeground(Color.WHITE);
        fetchdetails.addActionListener(this);
        image.add(fetchdetails);
        
        l2=new JLabel("Name");
        l2.setBounds(90,150,150,30);
        l2.setFont(new Font("Arial", Font.BOLD,20));
        l2.setForeground(Color.BLACK);
        image.add(l2);
        
        l3=new JLabel();
        l3.setBounds(240,150,150,30);
        image.add(l3);
        
        l4=new JLabel("Nationality");
        l4.setBounds(90,190,150,30);
        l4.setFont(new Font("Arial", Font.BOLD,20));
        l4.setForeground(Color.BLACK);
        image.add(l4);
        
        l4N=new JLabel();
        l4N.setBounds(240,190,150,30);
        image.add(l4N);
        
        l5=new JLabel("Address");
        l5.setBounds(90,230,150,30);
        l5.setFont(new Font("Arial", Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        image.add(l5);
        
        l6=new JLabel();
        l6.setBounds(240,230,250,30);
        image.add(l6);
        
        l7=new JLabel("Gender");
        l7.setBounds(90,270,150,30);
        l7.setFont(new Font("Arial", Font.BOLD,20));
        l7.setForeground(Color.BLACK);
        image.add(l7);
        
        l8=new JLabel();
        l8.setBounds(240,270,150,30);
        image.add(l8);
        
        l9=new JLabel("Source");
        l9.setBounds(90,310,150,30);
        l9.setFont(new Font("Arial", Font.BOLD,20));
        l9.setForeground(Color.BLACK);
        image.add(l9);
        
        source=new Choice();
        source.setBounds(240,315,150,30); 
        image.add(source);
        
  
        l9=new JLabel("Destination");
        l9.setBounds(90,350,150,30);
        l9.setFont(new Font("Arial", Font.BOLD,20));
        l9.setForeground(Color.BLACK);
        image.add(l9);
        
        dest=new Choice();
        dest.setBounds(240,355,150,30); 
        image.add(dest);
        
        try{
            ConnectionClass c=new ConnectionClass();
            String query="select * from flights";
            ResultSet rs= c.stm.executeQuery(query);
            
            while(rs.next()){
                source.add(rs.getString("source"));
                dest.add(rs.getString("destination"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        fetchflights=new JButton("Fetch Flights");
        fetchflights.setBounds(400,353,110,25);
        fetchflights.setBackground(Color.BLACK);
        fetchflights.setForeground(Color.WHITE);
        fetchflights.addActionListener(this);
        image.add(fetchflights);
        
        l10=new JLabel("Flight Name");
        l10.setBounds(90,390,150,30);
        l10.setFont(new Font("Arial", Font.BOLD,20));
        l10.setForeground(Color.BLACK);
        image.add(l10);
        
        l11=new JLabel();
        l11.setBounds(240,390,150,30);
        image.add(l11);
        
        l12=new JLabel("Flight Code");
        l12.setBounds(90,430,150,30);
        l12.setFont(new Font("Arial", Font.BOLD,20));
        l12.setForeground(Color.BLACK);
        image.add(l12);
        
        l13=new JLabel();
        l13.setBounds(240,430,150,30);
        image.add(l13);
        
        l14=new JLabel("Date of Travel");
        l14.setBounds(90,470,150,30);
        l14.setFont(new Font("Arial", Font.BOLD,20));
        l14.setForeground(Color.BLACK);
        image.add(l14);
        
        dcdate=new JDateChooser();
        dcdate.setBounds(240,470,150,25);
        image.add(dcdate);
      
        bookFlight=new JButton("Book Flight");
        bookFlight.setBounds(420,500,150,35);
        bookFlight.setBackground(Color.BLACK);
        bookFlight.setForeground(Color.WHITE);
        bookFlight.addActionListener(this);
        image.add(bookFlight);
  
        setSize(650,670);
        setLocation(250,40);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchdetails){
            String aadhar= tf1.getText();
            
            try{
                ConnectionClass con=new ConnectionClass();
                
                String query="select * from passenger where aadhar='"+aadhar+"'";
                ResultSet rs=con.stm.executeQuery(query);
                
                if(rs.next()){
                    l3.setText(rs.getString("name"));
                    l4N.setText(rs.getString("nationality"));
                    l6.setText(rs.getString("address"));
                    l8.setText(rs.getString("gender"));

                }else{
                    JOptionPane.showMessageDialog(null, "User does not exist");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else  if(ae.getSource()==fetchflights){
            String src= source.getSelectedItem();
            String des=dest.getSelectedItem();
            
            try{
                ConnectionClass con=new ConnectionClass();
                
                String query="select * from flights where source='"+src+"'and destination='"+des+"'";
                ResultSet rs=con.stm.executeQuery(query);
                
                if(rs.next()){
                    l11.setText(rs.getString("f_name"));
                    l13.setText(rs.getString("f_code"));

                }else{
                    JOptionPane.showMessageDialog(null, "No Flights Found");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            
            Random random=new Random();
            
            String aadhar=tf1.getText();
            String name=l3.getText();
            String nationality=l4N.getText();
            String flightname=l11.getText();
            String flightcode=l13.getText();
            String src=source.getSelectedItem();
            String des=dest.getSelectedItem();
            String ddate=((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            
            
            try{
                ConnectionClass con=new ConnectionClass();
                
                String query="insert into reservation values( 'PNR-"+random.nextInt(1000000)+"','Tic-"+random.nextInt(10000)+"','"+aadhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+des+"','"+ddate+"')";
                
                con.stm.executeUpdate(query);

               JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
               
               setVisible(false);
               
                }
            catch(Exception e){
                e.printStackTrace();
            }
       }
    }

    public static void main(String args[]){
        new BookFlight();
    }
}

