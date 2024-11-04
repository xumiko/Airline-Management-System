package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener{
    
    JButton fetchdetails,cancel;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l4N;
    JTextField tf1;

    Cancel(){
        
        setTitle("Cancellation");
        setSize(400,300);
        
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        Random random=new Random();
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/f1.jpg"));
        JLabel image=new JLabel(img);
        image.setBounds(0,0,700,400);
        add(image);
        
        JLabel heading=new JLabel("CANCELLATION");
        heading.setBounds(210,30,250,40);
        heading.setFont(new Font("Arial",Font.BOLD,32));
        image.add(heading);
        
        l1=new JLabel("PNR Number");
        l1.setBounds(90,110,150,30);
        l1.setFont(new Font("Arial", Font.BOLD,20));
        l1.setForeground(Color.BLACK);
        image.add(l1);
        
        tf1=new JTextField();
        tf1.setBounds(240,110,150,25);
        image.add(tf1);
        
        fetchdetails=new JButton("Show Details");
        fetchdetails.setBounds(400,110,110,25);
        fetchdetails.setBackground(Color.BLACK);
        fetchdetails.setForeground(Color.WHITE);
        fetchdetails.addActionListener(this);
        image.add(fetchdetails);
        
        l2=new JLabel("Name");
        l2.setBounds(90,150,170,30);
        l2.setFont(new Font("Arial", Font.BOLD,20));
        l2.setForeground(Color.BLACK);
        image.add(l2);
        
        l3=new JLabel();
        l3.setBounds(270,150,170,30);
        image.add(l3);
        
        l4=new JLabel("Cancellation No.");
        l4.setBounds(90,190,170,30);
        l4.setFont(new Font("Arial", Font.BOLD,20));
        l4.setForeground(Color.BLACK);
        image.add(l4);
        
        l4N=new JLabel(""+random.nextInt(1000000));
        l4N.setBounds(270,190,170,30);
        image.add(l4N);
        
        l5=new JLabel("Flight Code");
        l5.setBounds(90,230,170,30);
        l5.setFont(new Font("Arial", Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        image.add(l5);
        
        l6=new JLabel();
        l6.setBounds(270,230,170,30);
        image.add(l6);
        
        l7=new JLabel("Date");
        l7.setBounds(90,270,170,30);
        l7.setFont(new Font("Arial", Font.BOLD,20));
        l7.setForeground(Color.BLACK);
        image.add(l7);
        
        l8=new JLabel();
        l8.setBounds(270,270,170,30);
        image.add(l8);
        
       cancel=new JButton("Cancel");
        cancel.setBounds(290,305,110,35);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        image.add(cancel);

        setSize(700,400);
        setLocation(350,150);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchdetails){
            String pnr= tf1.getText();
            
            try{
                ConnectionClass con=new ConnectionClass();
                
                String query="select * from reservation where PNR='"+pnr+"'";
                ResultSet rs=con.stm.executeQuery(query);
                
                if(rs.next()){
                    l3.setText(rs.getString("name"));
                    l6.setText(rs.getString("flightcode"));
                    l8.setText(rs.getString("ddate"));

                }else{
                    JOptionPane.showMessageDialog(null, "Please Enter Correct PNR");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else  if(ae.getSource()==cancel){
            String name= l3.getText();
            String pnr=tf1.getText();
            String cancelNo= l4N.getText();
            String fcode=l6.getText();
            String date=l8.getText();
            
            try{
                ConnectionClass con=new ConnectionClass();
                
                String query="insert into cancellation values ('"+pnr+"','"+name+"','"+cancelNo+"','"+fcode+"','"+date+"')";
                
                con.stm.executeUpdate(query);
                con.stm.executeUpdate("delete from reservation where PNR='"+pnr+"'");
                
                
                JOptionPane.showMessageDialog(null, "Ticket Cancel");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        new Cancel();
    }
}
