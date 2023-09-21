
package bca_2078;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class EventHandling implements ActionListener, MouseListener, MouseMotionListener{
    JFrame frm;
    public static void main(String a[]){
        new EventHandling();
    }
    EventHandling(){
        frm=new JFrame();
        frm.setTitle("Event in JAVA");
        frm.setLayout(null);
        frm.setBounds(0,0,1300,600);
        
        JButton btn1=new JButton("Event");
        btn1.setBounds(40,40,100,30);
        frm.add(btn1);
        
        btn1.addActionListener(this);
        btn1.addMouseListener(this);
        btn1.addMouseMotionListener(this);
        
        frm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("X: "+e.getX()+" Y: "+e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Graphics g= frm.getGraphics();
        g.drawOval(e.getX()+100, e.getY()+100, 20, 20);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
