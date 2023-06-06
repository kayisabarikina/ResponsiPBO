/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo;

import connection.Koneksi;
import view.ViewLogin;

/**
 *
 * @author Lab Informatika
 */
public class ResponsiPBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Koneksi.getConnection();
        
     ViewLogin ViewLogin = new ViewLogin();
     ViewLogin.setVisible(true);
     ViewLogin.setLocationRelativeTo(null);
    }
        // TODO code application logic here
    }
    

