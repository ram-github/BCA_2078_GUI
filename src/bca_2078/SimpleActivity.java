package bca_2078;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class SimpleActivity extends JFrame implements ActionListener{
    JButton btn1,btn2;
    JLabel label3;
    JTextField txt1,txt2;
    public static void main(String r[]){
        new SimpleActivity();
    }
    public void actionPerformed(ActionEvent e){
        int n1=Integer.parseInt(txt1.getText());
        int n2=Integer.parseInt(txt2.getText());
        if(e.getSource()==btn1){
            label3.setText("Result is: "+(n1+n2));
        } 
         if(e.getSource()==btn2){
            label3.setText("Result is: "+(n1-n2));
        }
    }
    public SimpleActivity(){
        setTitle("Simple Calc Activity");
        setSize(400,400);
        setLayout(null);  
        label3=new JLabel("Result is: ");
        label3.setBounds(150,220,150,30);
        add(label3);
        JLabel label1=new JLabel("First No.");
        label1.setBounds(20,20,100,30);
        add(label1);
        JLabel label2=new JLabel("Second No.");
        label2.setBounds(20,80,100,30);
        add(label2);  
        txt1=new JTextField();
        txt1.setBounds(150,20,150,30);
        add(txt1);
        txt2=new JTextField();
        txt2.setBounds(150,80,150,30);
        add(txt2);
        btn1=new JButton("+");
        btn1.setBounds(150,140,50,50);
        btn1.addActionListener(this);
        add(btn1);
        btn2=new JButton("-");
        btn2.setBounds(210,140,50,50);
        btn2.addActionListener(this);
        add(btn2);
        setVisible(true);
    }
}
