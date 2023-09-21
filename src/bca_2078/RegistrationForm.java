package bca_2078;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegistrationForm extends JFrame implements ActionListener{
    JTextField txtName;
    JComboBox jcbProgram;
    JRadioButton rbMale,rbFemale;
    JTextArea txtAddress;
    JCheckBox cbGossip, cbPlay;
    JButton btnReset, btnSubmit;
    String programList[]={"Choose Program","BBA","BCA","BIM"};
    
    public static void main(String a[]){
        new RegistrationForm();
    }
    
    public RegistrationForm(){
        setTitle("Registration Form");
        setSize(500,500);
        setLayout(null);
        
        JLabel label3=new JLabel("Name: ");
        label3.setBounds(10,10,150,30);
        add(label3);
        JLabel label2=new JLabel("Program: ");
        label2.setBounds(10,60,150,30);
        add(label2);
        JLabel label1=new JLabel("Gender: ");
        label1.setBounds(10,110,150,30);
        add(label1);
        JLabel label4=new JLabel("Address: ");
        label4.setBounds(10,160,150,30);
        add(label4);
        JLabel label5=new JLabel("Skills: ");
        label5.setBounds(10,250,150,30);
        add(label5);
        
        txtName=new JTextField();
        txtName.setBounds(180,10,150,30);
        add(txtName);
        
        jcbProgram=new JComboBox(programList);
        jcbProgram.setBounds(180,60,150,30);
        add(jcbProgram);
        
        rbMale=new JRadioButton("Male");
        rbMale.setBounds(180,110,70,30);
        add(rbMale);
        rbMale.setSelected(true);
        
        rbFemale=new JRadioButton("Female");
        rbFemale.setBounds(250,110,80,30);
        add(rbFemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        
        txtAddress=new JTextArea();
        txtAddress.setBounds(180,160,150,70);
        txtAddress.setLineWrap(true);
        add(txtAddress);

        cbGossip=new JCheckBox("Gossip");
        cbGossip.setBounds(180,250,70,30);
        add(cbGossip);
        
        cbPlay=new JCheckBox("Playing");
        cbPlay.setBounds(250,250,80,30);
        add(cbPlay);
        
        btnReset=new JButton("Reset");
        btnReset.setBounds(180,350,70,30);
        add(btnReset);
        btnReset.addActionListener(this);
        
        btnSubmit=new JButton("Submit");
        btnSubmit.setBounds(270,350,80,30);
        add(btnSubmit);
        btnSubmit.addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnReset)
                reset();
        else if(e.getSource()==btnSubmit)
                submit();
        
    }
    
    public void reset(){
        txtName.setText("");
        jcbProgram.setSelectedIndex(0);
        rbMale.setSelected(true);
        txtAddress.setText("");
        cbGossip.setSelected(false);
        cbPlay.setSelected(false);            
    }
    public void submit(){
        String name=txtName.getText();
        String addr=txtAddress.getText();
        String gender;
        if(rbMale.isSelected()==true)
            gender="male";
        else
            gender="female";
        String program=jcbProgram.getSelectedItem().toString();
        boolean gossip,play;
        if(cbGossip.isSelected()==true)
            gossip=true;
        if(cbPlay.isSelected()==true)
            play=true;          
    }  
}
