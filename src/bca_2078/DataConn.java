
package bca_2078;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.table.DefaultTableModel;



public class DataConn extends JFrame implements ActionListener {
    JTextField txtUname;
    JPasswordField txtpass;
    JButton btn1,btn2,btn3,btn5,btn6,btn7,btn8;
    JTable tbl;
    Connection con;
    PreparedStatement ppstm;
    Statement stmt;
    JLabel label1 ,label2;
    DefaultTableModel model;
    
    public static void main(String a[])
    {
        new DataConn();
    }
    
    DataConn()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");         //1. Register jdbc driver for mysql
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root",""); //2. Set Connection String
            stmt=(Statement) con.createStatement();         //3. Create statement
            
        } catch (Exception ex) {
            System.out.println("Exception Handled1");
        }
        
        setLayout(null);
        setSize(500,500);
        
        label1=new JLabel();
        label1.setText("Username");
        label1.setBounds(20,10,100,30);
        add(label1);
        
        label2=new JLabel("");
        label2.setText("Password");
        label2.setBounds(20,42,90,30);
        add(label2);
            
        txtUname=new JTextField();
        txtUname.setBounds(115,10,130,30);
        add(txtUname);
          
        txtpass=new JPasswordField();
        txtpass.setBounds(115,42,130,30);
        add(txtpass);
            
        btn1=new JButton("Register");
        add(btn1);
        btn1.setBounds(20, 74, 100, 30);
        btn1.addActionListener(this);
            
        btn2=new JButton("Login");
        btn2.setBounds(125, 74, 100, 30);
        add(btn2);
        btn2.addActionListener(this);
            
        btn3=new JButton("View");
        btn3.setBounds(230, 74, 100, 30);
        add(btn3);
        btn3.addActionListener(this);
        

        btn5=new JButton("Delete");
        btn5.setBounds(20, 120, 100, 30);
        add(btn5);
        btn5.addActionListener(this);
        
        btn6=new JButton("Search");
        btn6.setBounds(125, 120, 100, 30);
        add(btn6);
        btn6.addActionListener(this);
        
        btn7=new JButton("Change Password");
        btn7.setBounds(230, 120, 100, 30);
        add(btn7);
        btn7.addActionListener(this);
        
        btn8=new JButton("Prepared Stmt");
        btn8.setBounds(335, 120, 100, 30);
        add(btn8);
        btn8.addActionListener(this);
        
        model=new DefaultTableModel();
        tbl=new JTable(model);
        JScrollPane scro=new JScrollPane(tbl);
        scro.setBounds(20,170,200,100);
       
        add(scro);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String uname=txtUname.getText();
        String pass=txtpass.getText();
        if(e.getSource()==btn1)         //Register or Insert
        {
            if(uname.equals("")||pass.equals(""))
                System.out.println("Fields can not be blank");
            else
            {
                String inQ="INSERT INTO login (username, password) VALUES ('"+uname+"','"+pass+"')";
                try {
                    int chk=stmt.executeUpdate(inQ);
                    if(chk==1)
                    {
                        System.out.println("Successfully Registered");
                        txtUname.setText("");
                        txtpass.setText("");
                    }
                    else
                       System.out.println("Failed to Register"); 
                } catch (SQLException ex) {
                    Logger.getLogger(DataConn.class.getName()).log(Level.SEVERE, null, ex);
                }
               updateTable();
            }
        }
        //Login using callablestatment
        if(e.getSource()==btn2)
        {
            int flag=1;
            String sqlQuery="call getRe()";
            if(uname.equals("")||pass.equals(""))
                System.out.println("Fields can not be blank");
            else
            {
                CallableStatement cstmt=null;
                try {
                    cstmt=con.prepareCall(sqlQuery);
                } catch (SQLException ex) {
                }
                try {
                    ResultSet rs=cstmt.executeQuery();
                    while(rs.next())
                    {
                        if(rs.getString(1).equals(uname) && rs.getString(2).equals(pass))
                        {
                            flag=0;
                            break;
                        }
                    }
                    if(flag==0)
                        System.out.println("Login Success");
                    else
                        System.out.println("Login Failed");
                    
                    } catch (SQLException ex) {
                    Logger.getLogger(DataConn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //View
        if(e.getSource()==btn3)
        {
               updateTable();
        }
        //Search
         if(e.getSource()==btn6)
        {
            int flag=1;
            if(uname.equals(""))
                System.out.println("User Name can not be blank");
            else
            {
                String selQ="select * from login where username='"+uname+"'";
                try {
                    ResultSet rs=stmt.executeQuery(selQ);
                     model.setRowCount(0);
                     model.setColumnCount(0);
                     model.addColumn("Username");
                     model.addColumn("Password");
                    while(rs.next())
                    {
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
                        flag=0;
                    }
                    if(flag==1)
                        System.out.println("User Name Not Found!");
                    
                    } catch (SQLException ex) {
                    Logger.getLogger(DataConn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
         //Update
        if(e.getSource()==btn7)
        {
            int flag=1;
            if(uname.equals("") ||pass.equals(""))
                System.out.println("Fields can not be blank");
            else
            {
                String upQ="UPDATE `login` SET `password`='"+pass+"' WHERE username='"+uname+"'";
                try {
                    int n=stmt.executeUpdate(upQ);
                    if(n==0)
                        System.out.println("No User Exist, Password Change Failed!");
                    else
                        System.out.println("Password Changed Successfully");
                    
                    } catch (SQLException ex) {
                    Logger.getLogger(DataConn.class.getName()).log(Level.SEVERE, null, ex);
                }
                updateTable();
            }
        }
        
        if(e.getSource()==btn8)
        {
            //Search Using Prepared Statement
            int flag=1;
            if(uname.equals(""))
                System.out.println("User Name can not be blank");
            else
            {
                String selQ="select * from login where username=?";
                try {
                    ppstm=con.prepareStatement(selQ);
                    ppstm.setString(1, uname);
                    ResultSet rs=ppstm.executeQuery();
                     model.setRowCount(0);
                     model.setColumnCount(0);
                     model.addColumn("Username");
                     model.addColumn("Password");
                    while(rs.next())
                    {
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
                        flag=0;   
                    }
                    if(flag==1)
                        System.out.println("User Name Not Found!");
                    } catch (SQLException ex) {
                    Logger.getLogger(DataConn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Delete
        if(e.getSource()==btn5)
        {
            if(uname.equals(""))
                System.out.println("Fields can not be blank");
            else
            {
                String inQ="delete from login where username='"+uname+"'";
                try {
                    int chk=stmt.executeUpdate(inQ);
                    if(chk==1)
                    {
                        System.out.println("Successfully Deleted");
                        txtUname.setText("");
                        txtpass.setText("");
                    }
                    else
                       System.out.println("Failed to Delete"); 
                } catch (SQLException ex) {
                    Logger.getLogger(DataConn.class.getName()).log(Level.SEVERE, null, ex);
                }
                updateTable();
            }
        }
        
    }
    
    
    public void updateTable()
    {
            String selQ="select * from login";
                try {
                    ResultSet rs=stmt.executeQuery(selQ);
                     model.setRowCount(0);
                     model.setColumnCount(0);
                     model.addColumn("Username");
                     model.addColumn("Password");
                    while(rs.next())
                    {
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
                    }
                    } catch (SQLException ex) {
                    Logger.getLogger(DataConn.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
