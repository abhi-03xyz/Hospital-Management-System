package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeInfo extends JFrame {
        EmployeeInfo()
        {
            JPanel panel=new JPanel();
            panel.setBounds(5,5,990,590);
            panel.setBackground(new Color(109,164,170));
            panel.setLayout(null);

            add(panel);


            JTable table=new JTable();
            table.setBounds(10,35,980,450);
            table.setBackground(new Color(109,164,170));
            table.setFont(new Font("Tahoma",Font.BOLD,14));
            panel.add(table);

            try{
                Conn c=new Conn();
                String query="select * from employeeInfo";
                ResultSet resultSet=c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch (Exception e){
                e.printStackTrace();
            }
        JLabel label1=new JLabel("Name");
        label1.setBounds(10,10,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label1);

            JLabel label2 =new JLabel("Age");
            label2.setBounds(180,10,70,20);
            label2.setFont(new Font("Tahoma",Font.BOLD,15));
            panel.add(label2);



            JLabel label3 =new JLabel("Phone Number");
            label3.setBounds(340,10,140,20);
            label3.setFont(new Font("Tahoma",Font.BOLD,15));
            panel.add(label3);

            JLabel label4 =new JLabel("Salary");
            label4.setBounds(500,10,140,20);
            label4.setFont(new Font("Tahoma",Font.BOLD,15));
            panel.add(label4);

            JLabel label5 =new JLabel("Gmail");
            label5.setBounds(660,10,140,20);
            label5.setFont(new Font("Tahoma",Font.BOLD,15));
            panel.add(label5);

            JLabel label6 =new JLabel("Addhar Number");
            label6.setBounds(830,10,140,20);
            label6.setFont(new Font("Tahoma",Font.BOLD,15));
            panel.add(label6);



            JButton b1=new JButton("Back");
            b1.setBounds(400,500,120,30);
            panel.add(b1);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });
            //setUndecorated(true);
            setSize(1000,600);
            setLocation(350,230);
            setLayout(null);
            setVisible(true);
        }
    public static void main(String[] args) {
        new EmployeeInfo();
    }
}
