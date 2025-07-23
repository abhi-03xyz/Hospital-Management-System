package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {


    Choice choice;
    JTable table;
    SearchRoom(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel For =new JLabel("Search For Room");
        For.setBounds(250,11,186,31);
        For.setForeground(Color.WHITE);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(For);

        JLabel status =new JLabel("Status :");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(status);

        choice=new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table=new JTable();
        table.setBounds(25,187,700,210);
        table.setForeground(Color.white);
        table.setBackground(new Color(90,156,163));
        panel.add(table);

        try{

            Conn c=new Conn();
            String q="select * from room";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel roomNo =new JLabel("Room Number");
        roomNo.setBounds(23,162,150,20);
        roomNo.setForeground(Color.WHITE);
        roomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(roomNo);

        JLabel availability =new JLabel("Availability");
        availability.setBounds(200,162,150,20);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(availability);

        JLabel price =new JLabel("Price");
        price.setBounds(380,162,150,20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        JLabel bed =new JLabel("Bed Type");
        bed.setBounds(560,162,150,20);
        bed.setForeground(Color.WHITE);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(bed);

        JButton search=new JButton("Search");
        search.setBounds(200,420,120,25);
        search.setBackground(Color.black);
        search.setForeground(Color.WHITE);
        panel.add(search);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select * from room where Availability= '"+choice.getSelectedItem()+"'";

                try{
                    Conn c=new Conn();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton back =new JButton("Back");
        back.setBounds(350,420,120,25);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });








        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
