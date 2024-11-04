package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    JButton fetchdetails;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l10,l11,l12,l13,l14,l4N,l15;
    JTextField tf1;

    
    BoardingPass(){
        
        setTitle("Boarding Pass");
        setSize(400,300);
        
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/br5.jpg"));
        JLabel image=new JLabel(img);
        image.setBounds(0,0,980,360);
        add(image);
        
        JLabel heading=new JLabel("AERIOUS AIRLINES");
        heading.setBounds(35,10,450,35);
        heading.setFont(new Font("Arial",Font.BOLD,28));
        image.add(heading);
        
        JLabel subheading=new JLabel("Boarding Pass");
        subheading.setBounds(80,45,300,30);
        subheading.setFont(new Font("Arial",Font.PLAIN,24));
        image.add(subheading);
        
        l1=new JLabel("PNR Details");
        l1.setBounds(230,100,150,30);
        l1.setFont(new Font("Arial", Font.BOLD,14));
        l1.setForeground(Color.BLACK);
        image.add(l1);
        
        tf1=new JTextField();
        tf1.setBounds(350,100,150,25);
        image.add(tf1);
        
        fetchdetails=new JButton("Enter");
        fetchdetails.setBounds(520,100,110,25);
        fetchdetails.setBackground(Color.BLACK);
        fetchdetails.setForeground(Color.WHITE);
        fetchdetails.addActionListener(this);
        image.add(fetchdetails);
        
        l2=new JLabel("NAME");
        l2.setBounds(230,130,150,30);
        l2.setFont(new Font("Arial", Font.BOLD,14));
        l2.setForeground(Color.BLACK);
        image.add(l2);
        
        l3=new JLabel();
        l3.setBounds(350,130,150,30);
        image.add(l3);
        
        l4=new JLabel("NATIONALITY");
        l4.setBounds(230,160,150,30);
        l4.setFont(new Font("Arial", Font.BOLD,14));
        l4.setForeground(Color.BLACK);
        image.add(l4);
        
        l4N=new JLabel();
        l4N.setBounds(350,160,150,30);
        image.add(l4N);
        
        l5=new JLabel("SRC");
        l5.setBounds(230,190,150,30);
        l5.setFont(new Font("Arial", Font.BOLD,14));
        l5.setForeground(Color.BLACK);
        image.add(l5);
        
        l6=new JLabel();
        l6.setBounds(350,190,150,30);
        image.add(l6);
        
        l7=new JLabel("DEST");
        l7.setBounds(460,190,150,30);
        l7.setFont(new Font("Arial", Font.BOLD,14));
        l7.setForeground(Color.BLACK);
        image.add(l7);
        
        l8=new JLabel();
        l8.setBounds(580,190,150,30);
        image.add(l8);
        
        
        l10=new JLabel("Flight Name");
        l10.setBounds(230,220,150,30);
        l10.setFont(new Font("Arial", Font.BOLD,14));
        l10.setForeground(Color.BLACK);
        image.add(l10);
        
        l11=new JLabel();
        l11.setBounds(350,220,150,30);
        image.add(l11);
        
        l12=new JLabel("Flight Code");
        l12.setBounds(460,220,150,30);
        l12.setFont(new Font("Arial", Font.BOLD,14));
        l12.setForeground(Color.BLACK);
        image.add(l12);
        
        l13=new JLabel();
        l13.setBounds(580,220,150,30);
        image.add(l13);
        
        l14=new JLabel("Date");
        l14.setBounds(230,250,150,30);
        l14.setFont(new Font("Arial", Font.BOLD,14));
        l14.setForeground(Color.BLACK);
        image.add(l14);
        
       l15=new JLabel();
        l15.setBounds(350,250,150,25);
        image.add(l15);
      
  
        setSize(1000,400);
        setLocation(200,150);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
            String pnr= tf1.getText();
            
            try{
                ConnectionClass con=new ConnectionClass();
                
                String query="select * from reservation where PNR='"+pnr+"'";
                ResultSet rs=con.stm.executeQuery(query);
                
                if(rs.next()){
                    l3.setText(rs.getString("name"));
                    l4N.setText(rs.getString("nationality"));
                    l6.setText(rs.getString("src"));
                    l8.setText(rs.getString("des"));
                    l11.setText(rs.getString("flightname"));
                    l13.setText(rs.getString("flightcode"));
                    l15.setText(rs.getString("ddate"));

                }else{
                    JOptionPane.showMessageDialog(null, "Please Enter Correct PNR");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    public static void main(String args[]){
        new BoardingPass();
    }
}