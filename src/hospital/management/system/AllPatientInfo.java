package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AllPatientInfo extends JFrame {

    AllPatientInfo()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,1490,690);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(20,40,1450,550);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);
        try{
            Conn c=new Conn();
            String query="select * from patient_info";
            ResultSet resultSet=c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1=new JLabel("ID");
        label1.setBounds(31,11,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label1);

        JLabel label2 =new JLabel("ID Number");
        label2.setBounds(220,11,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

        JLabel label3 =new JLabel("Name");
        label3.setBounds(390,11,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label3);

        JLabel label4 =new JLabel("Gender");
        label4.setBounds(570,11,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label4);

        JLabel label5 =new JLabel("Disease");
        label5.setBounds(750,11,100,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label5);

        JLabel label6 =new JLabel("Room no.");
        label6.setBounds(940,11,100,14);
        label6.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label6);

        JLabel label7 =new JLabel("Date & Time");
        label7.setBounds(1110,11,100,14);
        label7.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label7);

        JLabel label8 =new JLabel("Deposite");
        label8.setBounds(1300,11,100,14);
        label8.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label8);

        JButton button=new JButton("BACK");
        button.setBounds(550,600,120,30);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        //setUndecorated(true);
        setSize(1500,700);
        setLayout(null);
       // setLocation(350,200);
        setVisible(true);

    }
    public static void main(String[] args) {
        new AllPatientInfo();
    }
}
