package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdatePatientDetails  extends JFrame {

    UpdatePatientDetails()
    {

        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);


        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(550,60,200,200);
        panel.add(label);


        JLabel label1=new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 =new JLabel("Name:");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(248,85,140,25);
        panel.add(choice);

        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 =new JLabel("Room Number:");
        label3.setBounds(25,129,100,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldR =new JTextField();
        textFieldR.setBounds(248,129,140,20);
        panel.add(textFieldR);

        JLabel label4 =new JLabel("In-Time:");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldInTime =new JTextField();
        textFieldInTime.setBounds(248,174,140,20);
        panel.add(textFieldInTime);

        JLabel label5 =new JLabel("Amount Paid:");
        label5.setBounds(25,216,100,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldAmount =new JTextField();
        textFieldAmount.setBounds(248,216,140,20);
        panel.add(textFieldAmount);


        JLabel label6 =new JLabel("Pending Amount:");
        label6.setBounds(25,261,140,15);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldPendingAmount =new JTextField();
        textFieldPendingAmount.setBounds(248,261,140,20);
        panel.add(textFieldPendingAmount);


        JButton check=new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String q="select * from patient_info where name = '"+id+"'";
                try{

                    Conn c=new Conn();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    while(resultSet.next())
                    {
                        textFieldR.setText(resultSet.getString("room_number"));
                        textFieldInTime.setText(resultSet.getString("time"));
                        textFieldAmount.setText(resultSet.getString("deposite"));
                    }

                    ResultSet resultSet1=c.statement.executeQuery("select * from room where room_number='"+textFieldR.getText()+"'");
                    while(resultSet1.next())
                    {
                        String price=resultSet1.getString("price");
                        int amountPaid=Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPendingAmount.setText(""+amountPaid);
                    }


                }catch(Exception ex){

                }
            }
        });

        JButton update =new JButton("UPDATE");
        update.setBounds(181,378,89,23);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Conn c=new Conn();
                    String q=choice.getSelectedItem();
                    String room=textFieldR.getText();
                    String time=textFieldInTime.getText();
                    String amount=textFieldAmount.getText();
                    c.statement.executeUpdate("update patient_info set room_number = '"+room+"', time='"+time+"', deposite='"+amount+"' where name='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                }catch(Exception ex){

                }
            }
        });

        JButton back =new JButton("BACK");
        back.setBounds(81,378,89,23);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);


    }

    public static void main(String[] args) {
        new UpdatePatientDetails();
    }
}
