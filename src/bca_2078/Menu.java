
package bca_2078;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Menu implements ActionListener {
    JTextArea ta;
    JMenuBar mb;

    JMenu file,edit,view,newFile;
    JMenuItem save,cut,copy,paste,blankFile,templateFile;
    public static void main(String a[]){
        new Menu();
    }
    Menu(){
        JFrame frm=new JFrame();
        frm.setTitle("Menu in JAVA");
        frm.setLayout(null);
        frm.setBounds(0, 0,1300,600);
        mb=new JMenuBar();
        mb.setBounds(0,0,1300,30);
        frm.add(mb);
        file=new JMenu("File");
        edit=new JMenu("Edit");
        view=new JMenu("View");
        newFile=new JMenu("New File");
        mb.add(file);
        mb.add(edit);
        mb.add(view);
        save=new JMenuItem("Save");
        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        blankFile=new JMenuItem("Blank File");
        templateFile=new JMenuItem("Template File");
        file.add(newFile);
        file.add(save);
        newFile.add(blankFile);
        newFile.add(templateFile);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        ta=new JTextArea();
        ta.setBounds(0,30,1300,600);
        frm.add(ta);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        blankFile.addActionListener(this);
        frm.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cut){
            ta.cut();
        }
        if(e.getSource()==copy){
            ta.copy();
        }
        if(e.getSource()==paste){
            ta.paste();
        }
    }
    

    
}
