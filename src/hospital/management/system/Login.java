package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField passwordField;

    JButton b1,b2;
    Login()
    {
        super();
        JLabel namelable=new JLabel("Username");
        namelable.setBounds(40,20,100,30);
        namelable.setFont(new Font("Tahoma",Font.BOLD,15));
        namelable.setForeground(Color.BLACK);
        add(namelable);

        JLabel password=new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,15));
        password.setForeground(Color.BLACK);
        add(password);

        textField=new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tamoha",Font.PLAIN,15));
        textField.setBackground(new Color(220,20,60));
        add(textField);

        passwordField=new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        passwordField.setFont(new Font("Tamoha",Font.PLAIN,15));
        passwordField.setBackground(new Color(220,20,60));
        add(passwordField);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1=imageIcon.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(320,-30,400,300);
        add(label);


        b1=new JButton("LOGIN");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        add(b1);



        b2=new JButton("CANCEL");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        add(b2);



        getContentPane().setBackground(new Color(231,236,168));
        setSize(750,300);
        setLocation(750/2,270);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {

        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
         try{

             Conn c=new Conn();
             String user=textField.getText();
             String pass=passwordField.getText();

             String query="select * from login where ID='"+user+"'  and password= '"+pass+"'";

             ResultSet resultSet=c.statement.executeQuery(query);
             if(resultSet.next())
             {
                    new Reception();
                    setVisible(false);
             }else{
                 JOptionPane.showMessageDialog(null,"Invalid");
             }

         }catch(Exception E)
         {
             E.printStackTrace();
         }
        }else{
                System.exit(10);
        }
    }
}
