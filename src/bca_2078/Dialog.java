package bca_2078;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
public class Dialog extends WindowAdapter implements ActionListener {
    JFrame frm;
    JButton btnShowMessageDialog;
    String name;
    Dialog() {
        frm = new JFrame("Dialog box in java");
        frm.setSize(500, 500);
        frm.setLayout(null);
        frm.addWindowListener(this);

        btnShowMessageDialog = new JButton("Show Message Dialog Box");
        btnShowMessageDialog.setBounds(20, 20, 200, 30);
        frm.add(btnShowMessageDialog);
        btnShowMessageDialog.addActionListener(this);

        frm.setVisible(true);
    }

    public static void main(String ar[]) {
        new Dialog();
    }
    
     public void windowClosing(WindowEvent e) {
        int a = JOptionPane.showConfirmDialog(frm, "Are you sure?");
        if (a == JOptionPane.YES_OPTION) {
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else if(a== JOptionPane.NO_OPTION)
            frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnShowMessageDialog){
            showCustomDialog();
        }
    }
    
    public void showMessage(){
        JOptionPane.showMessageDialog(frm, "Alert Message", "Error M",JOptionPane.QUESTION_MESSAGE);
    }
    
    public void showCustomDialog(){
        name=JOptionPane.showInputDialog(frm,"Enter your name");
        System.out.println(name);
    }

}
