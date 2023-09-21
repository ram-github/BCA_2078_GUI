package bca_2078;

import java.sql.*;

public class BasicInsertOperation {

    Connection con;
    Statement stmt;

    BasicInsertOperation() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");         //1. Register jdbc driver for mysql
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", ""); //2. Set Connection String
            stmt = (Statement) con.createStatement();         //3. Create statement  
        } catch (Exception ex) {
            System.out.println("Exception Handled");
        }
        String uname = "Astha";
        String pass = "Mahato";
        String inQ = "INSERT INTO login (username, password) VALUES ('" + uname + "','" + pass + "')";
        try {
            int chk = stmt.executeUpdate(inQ);
            if (chk == 1) {
                System.out.println("Successfully Inserted");
            } else {
                System.out.println("Failed to Insert");
            }
        } catch (SQLException ex) {
        }
    }

    public static void main(String a[]) {
        BasicInsertOperation obj=new BasicInsertOperation();
    }

}
