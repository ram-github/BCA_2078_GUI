package bca_2078;
import java.awt.*;
import javax.swing.*;
public class JavaBorderLayout {
 
        public static void main(String ar[]){
        JFrame frm=new JFrame();
        frm.setTitle("Border Layout");
        frm.setSize(300,500);
        frm.setLayout(new BorderLayout());
        
        JButton btn1=new JButton("Button 1");
        btn1.setSize(130, 30);
        frm.add(btn1,BorderLayout.NORTH);
     
        JButton btn2=new JButton("Button 2");
        btn2.setSize(130, 30);
        frm.add(btn2,BorderLayout.SOUTH);
        
        JButton btn3=new JButton("Button 3");
        btn3.setSize(130, 30);
        frm.add(btn3,BorderLayout.EAST);
        
        JButton btn4=new JButton("Button 4");
        btn3.setSize(130, 30);
        frm.add(btn4,BorderLayout.WEST);
        
        JButton btn5=new JButton("Button 5");
        btn3.setSize(130, 30);
        frm.add(btn5,BorderLayout.CENTER);
        
        frm.setVisible(true);
        }
    }

