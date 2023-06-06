/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Interface.InterfaceRenter;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelRenter;
import connection.Koneksi;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class DAORenter implements InterfaceRenter{
    Connection connect;
    
    public DAORenter(){
        connect = Koneksi.getConnection();
        
    
    }

    @Override
    public List<ModelRenter> getAll() {
        List<ModelRenter> listRenter = null;
        try {
            listRenter = new ArrayList<ModelRenter>();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM rooms");
            while (rs.next()) {
               ModelRenter r = new ModelRenter();
               r.setSize(rs.getString("size"));
               r.setPrice(rs.getInt("price"));
               r.setStatus(rs.getString("status"));
              
               listRenter.add(r);
               
                
            }
        } catch (Exception e) {
            System.out.println("Eror" +e.getMessage());
        }
        return listRenter;
    }
    
}
