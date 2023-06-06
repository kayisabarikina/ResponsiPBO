/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Lab Informatika
 */
public class Koneksi {
     static Connection connect;

    
    public static Connection getConnection(){
        if(connect == null){
            MysqlDataSource db = new MysqlDataSource();
            db.setDatabaseName("penginapan");
            db.setUser("root");
            db.setPassword("");
            
            try {
                connect =  db.getConnection();
                System.out.println("Connected");
            } catch (Exception e) {
                System.out.println("eror" + e.getMessage());
            }
        }
        return connect;
    }
    
}
