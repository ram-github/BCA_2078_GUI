package bca_2078;
import java.awt.*;
import javax.swing.*;
public class JFrameVsPanel extends JFrame{
    public static void main(String ar[]){
        new JFrameVsPanel();
    }
    
    public JFrameVsPanel(){
        setTitle("JFrameVsPanel");
        setSize(300,500);
        setLayout(new FlowLayout());
        
        JButton btn1=new JButton("Button 1");
        btn1.setSize(130, 30);
     
        JButton btn2=new JButton("Button 2");
        btn2.setSize(130, 30);
        
        JButton btn3=new JButton("Button 3");
        btn3.setSize(130, 30);
        
        JPanel panel1=new JPanel();
        panel1.setBackground(Color.green);
        add(panel1);
        
        JPanel panel2=new JPanel();
        panel2.setBackground(Color.red);
        add(panel2);

        panel1.add(btn1);
        panel1.add(btn2);
        panel2.add(btn3);
        
        setVisible(true);
    }
}
