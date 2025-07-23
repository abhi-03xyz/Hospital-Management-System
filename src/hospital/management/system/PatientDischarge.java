package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class PatientDischarge extends JFrame {

    PatientDischarge()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);


        JLabel label=new JLabel("Check-Out");
        label.setBounds(100,20,200,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label2 =new JLabel("Patient ID");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);


        Choice choice=new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{

            Conn c=new Conn();
            String q="select * from patient_info";
            ResultSet resultSet=c.statement.executeQuery(q);
            while(resultSet.next())
            {
//                String id=resultSet.getString("id");
//                choice.add(resultSet.getString("number").concat(" "+id));
                choice.add(resultSet.getString("number"));

            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }







        JLabel label3 =new JLabel("Room Number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);


        JLabel rno =new JLabel();
        rno.setBounds(300,130,150,20);
        rno.setFont(new Font("Tahoma",Font.BOLD,14));
        rno.setForeground(Color.white);
        panel.add(rno);

        JLabel label4 =new JLabel("In time");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel inTime =new JLabel();
        inTime.setBounds(200,180,250,20);
        inTime.setFont(new Font("Tahoma",Font.BOLD,14));
        inTime.setForeground(Color.white);
        panel.add(inTime);


        JLabel label5 =new JLabel("Out time");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);



        Date date=new Date();


        JLabel outTime =new JLabel(""+date);
        outTime.setBounds(200,230,250,20);
        outTime.setFont(new Font("Tahoma",Font.BOLD,14));
        outTime.setForeground(Color.white);
        panel.add(outTime);


        JButton discharge=new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);

        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Conn c=new Conn();
                String q="delete from patient_info where number= '"+choice.getSelectedItem()+"'";

                try {
                    c.statement.executeUpdate(q);
                    c.statement.executeUpdate("update Room set availability = 'Available' where room_number = '"+rno.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);

                }catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });





        JButton check=new JButton("Check");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.black);
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c=new Conn();
                try{
                    String q="select * from patient_info where number='"+choice.getSelectedItem()+"'";
                    ResultSet resultSet=c.statement.executeQuery(q);

                    while(resultSet.next())
                    {
                        rno.setText(resultSet.getString("room_number"));
                        inTime.setText(resultSet.getString("time"));
                    }

                }catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        JButton back =new JButton("Back");
        back.setBounds(300,300,120,30);
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
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }

    public static void main(String[] args) {
            new PatientDischarge();
    }

}
