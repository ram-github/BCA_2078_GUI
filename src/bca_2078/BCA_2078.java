package bca_2078;

import java.awt.FlowLayout;
import javax.swing.*;

public class BCA_2078 {
    public static void main(String[] args) {
        JFrame frm=new JFrame();
        frm.setTitle("First Java Application");
        frm.setSize(300,500);
        frm.setLayout(new FlowLayout());
        
        JButton btn1=new JButton("Button 1");
        btn1.setSize(130, 30);
        frm.add(btn1);
        
        JButton btn2=new JButton("Button 2");
        btn2.setSize(130, 30);
        frm.add(btn2);
        
        JButton btn3=new JButton("Button 3");
        btn3.setSize(130, 30);
        frm.add(btn3);
        
        frm.setVisible(true);
    }
    
}
