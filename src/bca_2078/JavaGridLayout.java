
package bca_2078;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class JavaGridLayout {
    public static void main(String a[]){
    JFrame frm=new JFrame();
        frm.setTitle("Grid Layout in use");
        frm.setSize(300,500);
        frm.setLayout(new GridLayout(3,2));
        
        JButton btn1=new JButton("Button 1");
        btn1.setSize(130, 30);
        frm.add(btn1);
     
        JButton btn2=new JButton("Button 2");
        btn2.setSize(130, 30);
        frm.add(btn2);
        
        JButton btn3=new JButton("Button 3");
        btn3.setSize(130, 30);
        frm.add(btn3);
        
        JButton btn4=new JButton("Button 4");
        btn3.setSize(130, 30);
        frm.add(btn4);
        
     
        
        frm.setVisible(true);
    }
}
