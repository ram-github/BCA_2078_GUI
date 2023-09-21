
package bca_2078;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MdiClass implements ActionListener{
    JFrame frm;
    JInternalFrame iframe1;
    JButton btn1;
    public static void main(String a[]){
        new MdiClass();
    }
    
    MdiClass(){
        frm=new JFrame();
        frm.setTitle("MDI in JAVA");
        frm.setLayout(null);
        frm.setBounds(0,0,1300,600);
        
        btn1=new JButton("Blank");
        btn1.setBounds(40,40,100,30);
        btn1.addActionListener(this);
        frm.add(btn1);
        
        iframe1=new JInternalFrame("Blank File",false,false,false,true);
        iframe1.setBounds(100,100,400,400);
        iframe1.setLayout(new FlowLayout());
        iframe1.getContentPane().setBackground(Color.red);        
        JButton btn=new JButton("IFrame");
        btn.setSize(100,30);
        iframe1.getContentPane().add(btn);
        iframe1.pack();
        iframe1.setVisible(false);
        frm.add(iframe1);
        
        frm.setVisible(true);
    }
    public void openBlankFile(){
        iframe1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==btn1){
            openBlankFile();
        }
    }
}
