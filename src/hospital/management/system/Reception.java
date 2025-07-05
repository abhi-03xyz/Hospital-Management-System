package hospital.management.system;

import javax.swing.*;
import java.awt.*;

public class Reception extends JFrame {

    Reception()
    {
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,670);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(image);
        JLabel label=new JLabel(i2);
        label.setBounds(1300,0,250,250);
        panel1.add(label);


        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1=i11.getImage().getScaledInstance(300,100,Image.SCALE_DEFAULT);
        ImageIcon i22=new ImageIcon(image1);
        JLabel label1=new JLabel(i22);
        label1.setBounds(1000,50,300,100);
        panel1.add(label1);





        setSize(1950,1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
