
package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame{
    
    public FlightInfo(){
        
        setTitle("Flight Details");
        setSize(400,300);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table=new JTable();
        
        try{
            ConnectionClass con= new ConnectionClass();
            
            ResultSet rs= con.stm.executeQuery("select * from flights");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,0,800,500);
        add(jsp);
        
        
        setSize(800,400);
        setLocation(275,200);
        setVisible(true);
        
    }
    
    public static void main(String args[]){
        new FlightInfo();
    }
    
}
