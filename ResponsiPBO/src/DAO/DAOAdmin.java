/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Interface.InterfaceAdmin;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelAdmin;
import connection.Koneksi;
import java.sql.PreparedStatement;
import java.sql.Statement;

   

/**
 *
 * @author Lab Informatika
 */
public class DAOAdmin implements  InterfaceAdmin{
    Connection connect;
    
    public DAOAdmin(){
        connect = Koneksi.getConnection();
        
    
    }

    @Override
    public List<ModelAdmin> getAll() {
        List<ModelAdmin> listAdmin = null;
        try {
            listAdmin = new ArrayList<ModelAdmin>();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM renter");
            while (rs.next()) {
               ModelAdmin a = new ModelAdmin();
               a.setName(rs.getString("name"));
               a.setId(rs.getString("id"));
               a.setContact(rs.getString("contact"));
               a.setDuration(rs.getInt("duration"));
               a.setBill(rs.getInt("bill"));
               a.setStatus(rs.getString("status"));
               a.setRoom(rs.getString("room"));
               listAdmin.add(a);
               
                
            }
        } catch (Exception e) {
            System.out.println("Eror" +e.getMessage());
        }
        return listAdmin;
    }

    @Override
    public void insert(ModelAdmin admin) {
        PreparedStatement statement = null;
        
        try {
            statement = connect.prepareStatement("INSERT INTO renter (name,contact,duration,bill,status,room) VALUES (?,?,?,?,?,?);");
            statement.setString(1,admin.getName());
            statement.setString(2,admin.getContact());
            statement.setInt(3,admin.getDuration());
            statement.setInt(4,admin.getBill());
            statement.setString(5,admin.getStatus());
            statement.setString(6,admin.getRoom());
                
            
        } catch (Exception e) {
            System.out.println("input gagal");
        }finally {
            try {
                statement.close();
            } catch (SQLException exc) {
                System.out.println("Update gagal");
            }
        
        }
    }

 
@Override
public void update(ModelAdmin admin){
        PreparedStatement statement = null;
        try {
            statement = connect.prepareStatement("UPDATE renter set name =?, contact =?, duration =?, bill=?, status =?, room =? where id=?;");
            statement.setString(1,admin.getName());
            statement.setString(2,admin.getContact());
            statement.setInt(3,admin.getDuration());
            statement.setInt(4,admin.getBill());
            statement.setString(5,admin.getStatus());
            statement.setString(6,admin.getRoom());
            statement.setString(7,admin.getId());
            
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Update Gagal(" + e.getMessage() + ")");
        } finally {
            try {
                statement.close();
            } catch (SQLException exc) {
                System.out.println("Update gagal");
            }
        
        }
}
    @Override
        public void delete(int id) {
        PreparedStatement statement = null;

        try {
            statement = connect.prepareStatement("DELETE FROM renter WHERE id=?;");
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Delete Gagal (" + e.getMessage() + ")");
        } finally {
            try {
                statement.close();
            } catch (SQLException exc) {
                System.out.println("Delete Gagal");
            }
        }

}
}

    

    
    
    
    
        
    
  
            
    

