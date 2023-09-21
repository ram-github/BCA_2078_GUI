/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bca_2078;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class MenuExample implements ActionListener{
    JFrame frm;
    JMenu file,edit,view;
    JMenuItem newProject, newFile,cut,copy,paste,blank,template;
    JMenuBar mb;
    
    public MenuExample()
    {
        frm=new JFrame("Project Demo");
        frm.setSize(1800, 1800);
        frm.setLayout(null);
        
        mb=new JMenuBar();
        mb.setBounds(0,0,1800,30);
        frm.add(mb);
        
        file=new JMenu("File");
        edit=new JMenu("Edit");
        view=new JMenu("View");
        
        mb.add(file);
        mb.add(view);
        mb.add(edit);
        
        newProject=new JMenuItem("New Project");
        newFile=new JMenu("New File");
        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        blank=new JMenuItem("Blank File");
        template=new JMenuItem("Template");
        
        file.add(newProject);
        file.add(newFile);
        
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        
        newFile.add(blank);
        newFile.add(template);
       
        frm.setVisible(true);
        
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        blank.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
        if(e.getSource()==blank){
            JInternalFrame iframe1=new JInternalFrame("Blank",true,true,true,true);
            iframe1.setBounds(200,10,500,750);
            iframe1.setLayout(null);
            iframe1.getContentPane().setBackground(Color.red);
            iframe1.pack();
            iframe1.show();
            iframe1.setVisible(true);
            frm.add(iframe1);
        }
    }
    
    public static void main(String[] args) {
        new MenuExample();
    }
}
