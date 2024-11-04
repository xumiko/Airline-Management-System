
package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{
    
    JTable table;
    JTextField pnr;
    JButton show;
    
    public JourneyDetails(){
        
        setTitle("Journey Details");
        setSize(400,300);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/f2.jpg"));
        JLabel image=new JLabel(img);
        image.setBounds(0,0,1800,400);
        add(image);
        
        JLabel lblpnr=new JLabel("PNR Details");
        lblpnr.setFont(new Font("Arial",Font.BOLD,16));
        lblpnr.setBounds(50,50,100,25);
        image.add(lblpnr);
        
        pnr=new JTextField();
        pnr.setBounds(160,50,120,25);
        image.add(pnr);
        
        show=new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290,50,120,25);
        show.addActionListener(this);
        image.add(show);
        
        table=new JTable();
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,800,150);
        jsp.setBackground(Color.WHITE);
        image.add(jsp);
        
        
        setSize(800,400);
        setLocation(275,175);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            ConnectionClass con= new ConnectionClass();
            
            ResultSet rs= con.stm.executeQuery("select * from reservation where PNR= '"+pnr.getText()+"'");
            
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new JourneyDetails();
    }
    
}

