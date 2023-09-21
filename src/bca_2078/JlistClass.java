/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bca_2078;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JlistClass {
    JList li;
    JlistClass()
    {
        JFrame frm=new JFrame("JList Usage");
        frm.setSize(400, 400);
        frm.setLayout(null);
        
        String week[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        li=new JList(week);
        li.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        li.setSelectedIndex(3);
        li.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JOptionPane.showMessageDialog(null, "You have selected: "+li.getSelectedValuesList());
            }
        });
        JScrollPane scroll=new JScrollPane(li);
        scroll.setBounds(50,50,100,70);
        frm.add(scroll);
        
        frm.setVisible(true);
    }
    
    public static void main(String a[]){
        new JlistClass();
    }
}
