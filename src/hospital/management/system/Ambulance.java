package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {

    Ambulance(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(20,50,800,400);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);
        try{
            Conn c=new Conn();
            String query="select * from ambulance";
            ResultSet resultSet=c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1=new JLabel("Name");
        label1.setBounds(20,11,100,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label1);

        JLabel label2 =new JLabel("Gender");
        label2.setBounds(190,11,100,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

        JLabel label3 =new JLabel("Car Name");
        label3.setBounds(350,11,100,15);
        label3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label3);

        JLabel label4 =new JLabel("Availability");
        label4.setBounds(520,11,100,15);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label4);

        JLabel label5 =new JLabel("Location");
        label5.setBounds(700,11,100,15);
        label5.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label5);



        JButton button=new JButton("BACK");
        button.setBounds(550,480,120,30);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
         setLocation(300,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ambulance();
    }
}
