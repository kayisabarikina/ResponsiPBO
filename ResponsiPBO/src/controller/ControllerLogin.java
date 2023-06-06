/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import connection.Koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
import view.ViewRenter;
import view.ViewLogin;
import view.ViewAdmin;

/**
 *
 * @author Bella Febriany
 */
public class ControllerLogin {

    ViewLogin viewlogin;
    Connection connection;

    public ControllerLogin(ViewLogin viewlogin) {
        this.viewlogin = viewlogin;
        connection = Koneksi.getConnection();
    }

    public void login() {
        String username = viewlogin.getUsername().getText();
        String password = viewlogin.getPassword().getText();

        String checkUser = null;
        String checkPass = null;
        String role = null;

        try {
            Statement st = connection.createStatement();
            String query = "SELECT * FROM accounts WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                checkUser = result.getString("username");
                checkPass = result.getString("password");
                role = result.getString("role");

            }
            result.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Login Gagal!");
        }
        if (checkUser == null && checkPass == null) {
            JOptionPane.showMessageDialog(null, "Username atau Password salah");
            viewlogin.setUsername(null);
            viewlogin.setPassword(null);
        } else {
            switch (role) {
                case "admin":
                    JOptionPane.showMessageDialog(null, "Login Berhasil [Admin]");
                    ViewAdmin Admin = new ViewAdmin();
                    Admin.setVisible(true);
                    Admin.setLocationRelativeTo(null);
                    viewlogin.dispose();
                    break;
                    
                case "renter":
                    JOptionPane.showMessageDialog(null, "Login Berhasil [Renter]");
                    ViewRenter renter  = new ViewRenter();
                    renter.setVisible(true);
                    renter.setLocationRelativeTo(null);
                    viewlogin.dispose();
                    break;
            }
        }

    }
}
