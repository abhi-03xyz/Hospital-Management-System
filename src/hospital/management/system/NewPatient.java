package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import org.json.JSONObject;



public class NewPatient extends JFrame  implements ActionListener {


    JComboBox comboBox;
    JTextField textFieldNumber,textName,textFieldDisease,textFieldDeposite;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton b1,b2;

    JCheckBox cbFever,cbCough,cbHeadache,cbFatigue,cbChestPain;
    JTextField textFieldDepartment;

    JButton btnPredict;
    NewPatient()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,1080,800);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource(("icon/patient.png")));
        Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel labelName=new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add((labelName));

        JLabel labelID=new JLabel("ID :");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,14));
        labelID.setForeground(Color.white);
        panel.add((labelID));

        comboBox=new JComboBox(new String[] {"Aadhar Card","Voter Id","Driving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(30,45,48));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);

        JLabel labelNumber =new JLabel("Number :");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelNumber.setForeground(Color.white);
        panel.add((labelNumber));

        textFieldNumber=new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);



        JLabel labelPatientName =new JLabel("Name :");
        labelPatientName.setBounds(35,151,200,14);
        labelPatientName.setFont(new Font("Tahoma",Font.BOLD,14));
        labelPatientName.setForeground(Color.white);
        panel.add((labelPatientName));

        textName=new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);




        JLabel labelGender =new JLabel("Gender :");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelGender.setForeground(Color.white);
        panel.add((labelGender));

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(271,191,88,15);
        panel.add(r1);


        r2=new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(360,191,88,15);
        panel.add(r2);


        JLabel labelDisease =new JLabel("Disease :");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDisease.setForeground(Color.white);
        panel.add((labelDisease));

        textFieldDisease=new JTextField();
        textFieldDisease.setBounds(271,231,150,20);
        panel.add(textFieldDisease);


        JLabel labelRoom =new JLabel("Room :");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoom.setForeground(Color.white);
        panel.add((labelRoom));

        //Room list//
        c1=new Choice();
        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from room");
            while(resultSet.next())
            {
                c1.add(resultSet.getString("room_number"));
            }
        }catch (Exception e){
        e.printStackTrace();
        }

        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setBackground(new Color(30,45,48));
        c1.setForeground(Color.white);
        panel.add(c1);

        JLabel labelDate =new JLabel("Time :");
        labelDate.setBounds(35,316,200,14);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDate.setForeground(Color.white);
        panel.add((labelDate));

        Date date1=new Date();
        date=new JLabel(""+date1);
        date.setBounds(271,316,250,14);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);


        JLabel labelDeposite =new JLabel("Deposite :");
        labelDeposite.setBounds(35,359,200,14);
        labelDeposite.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDeposite.setForeground(Color.white);
        panel.add((labelDeposite));

        textFieldDeposite=new JTextField();
        textFieldDeposite.setBounds(271,359,150,20);
        panel.add(textFieldDeposite);


        JLabel lableDept=new JLabel("Department:");
        lableDept.setBounds(35,395,200,20);
        lableDept.setFont(new Font("Tahoma",Font.BOLD,14));
        lableDept.setForeground(Color.white);
        panel.add(lableDept);

        textFieldDepartment=new JTextField();
        textFieldDepartment.setBounds(271,395,150,20);
        textFieldDepartment.setBackground(new Color(90,156,163));
        textFieldDepartment.setEditable(false);
        panel.add(textFieldDepartment);


        cbFever=new JCheckBox("Fever");
        cbCough = new JCheckBox("Cough");
        cbHeadache = new JCheckBox("Headache");
        cbFatigue = new JCheckBox("Fatigue");
        cbChestPain = new JCheckBox("Chest Pain");

        cbFever.setBounds(271, 490, 100, 20);
        cbCough.setBounds(370, 490, 100, 20);
        cbHeadache.setBounds(271, 520, 100, 20);
        cbFatigue.setBounds(370, 520, 100, 20);
        cbChestPain.setBounds(271, 560, 100, 20);

        panel.add(cbFever);
        panel.add(cbCough);
        panel.add(cbHeadache);
        panel.add(cbFatigue);
        panel.add(cbChestPain);

        btnPredict=new JButton("Predict Disease");
        btnPredict.setBounds(500,520,150,25);
        btnPredict.setBackground(Color.green);
        btnPredict.setForeground(Color.BLACK);
        btnPredict.addActionListener(this);
        panel.add(btnPredict);



        b1=new JButton("ADD");
        b1.setBounds(100,610,120,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(260,610,120,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        panel.add(b2);


        setUndecorated(true);
        setSize(1090,810);
        setLayout(null);
       // setLocation(300,250);
        setVisible(true);
    }

    public static void main(String[] args) {

        new NewPatient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnPredict){

            try{

                int fever=cbFever.isSelected()?1:0;
                int cough=cbCough.isSelected()?1:0;
                int headache=cbHeadache.isSelected()?1:0;
                int fatigue=cbFatigue.isSelected()?1:0;
                int chestPain=cbChestPain.isSelected()?1:0;

                // Create JSON string
                String jsonInput = String.format(
                        "{\"fever\":%d,\"cough\":%d,\"headache\":%d,\"fatigue\":%d,\"chest_pain\":%d}",
                        fever, cough, headache, fatigue, chestPain
                );

                //connection with flask server
                java.net.URL url=new java.net.URL("http://localhost:5000/predict");
                java.net.HttpURLConnection conn=(java.net.HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type","application/json");

                //send request
                java.io.OutputStream os=conn.getOutputStream();
                os.write(jsonInput.getBytes());
                os.flush();

                //read our response
                java.io.BufferedReader br=new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream()));
                StringBuilder sb=new StringBuilder();
                String line;
                while((line=br.readLine()) != null)
                {
                    sb.append(line);
                }

                conn.disconnect();

                //parsing json response
                org.json.JSONObject responseJson=new org.json.JSONObject(sb.toString());
                String disease=responseJson.getString("predicted_disease");
                String department=responseJson.getString("recommended_department");

                //update
                textFieldDisease.setText(disease);
                textFieldDepartment.setText(department);
                JOptionPane.showMessageDialog(null,"Disease predicted successfully!");


            }catch (Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Prediction failed. Is Flask running?");
            }
        }



        if(e.getSource()==b1)
        {
            Conn c=new Conn();
            String radioBTN=null;
            if(r1.isSelected())
            {
                radioBTN="Male";
            } else if (r2.isSelected()) {
                radioBTN="Female";
            }

            String s1=(String)comboBox.getSelectedItem();
            String s2=textFieldNumber.getText();
            String s3=textName.getText();
            String s4=radioBTN;
            String s5=textFieldDisease.getText();
            String s6=c1.getSelectedItem();
            String s7=date.getText();
            String s8=textFieldDeposite.getText();



            try {

                String query1="insert into patient_info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String query2="update room set availability= 'Occupied' where room_number= "+s6;
                c.statement.executeUpdate(query1);
                c.statement.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }


        }else if(e.getSource()==b2){
            setVisible(false);
        }



    }
}
