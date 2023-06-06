/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import DAO.DAOAdmin;
import Interface.InterfaceAdmin;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelAdmin;
import model.TabelModelAdmin;
import view.ViewAdmin;


/**
 *
 * @author Lab Informatika
 */
public class ControllerAdmin {
 ViewAdmin viewAdmin;
 InterfaceAdmin iAdmin;
 List<ModelAdmin>listAdmin;
  public ControllerAdmin(ViewAdmin viewAdmin){
      this.viewAdmin = viewAdmin;
      iAdmin = new DAOAdmin();
  }
  
  public void readData(){
      listAdmin = iAdmin.getAll();
      TabelModelAdmin tabelAdmin=  new TabelModelAdmin(listAdmin);
      viewAdmin.getTabel1().setModel(tabelAdmin);
  }
  public void insertData(){
     ModelAdmin admin = new ModelAdmin();
     admin.setName(viewAdmin.getNama().getText());
     admin.setId(viewAdmin.getId().getText());
     admin.setContact(viewAdmin.getKontak().getText());
     admin.setDuration(Integer.parseInt(viewAdmin.getDurasi().getText()));
     admin.setBill(Integer.parseInt(viewAdmin.getBill().getText()));
     admin.setStatus(viewAdmin.getStatus().getText());
     admin.setRoom(viewAdmin.getRoom().getText());
     iAdmin.insert(admin);
   
      
  }
  public void isiField(int row)
    {
    viewAdmin.getNama().setText(listAdmin.get(row).getName());
    viewAdmin.getId().setText(listAdmin.get(row).getId());
    viewAdmin.getKontak().setText(listAdmin.get(row).getContact());
    viewAdmin.getDurasi().setText(listAdmin.get(row).getDuration().toString());
    viewAdmin.getBill().setText(listAdmin.get(row).getBill().toString());
    viewAdmin.getStatus().setText(listAdmin.get(row).getStatus());
    viewAdmin.getRoom().setText(listAdmin.get(row).getRoom());
    
    
    }
  public void reset()
    {
       viewAdmin.getNama().setText("");
       viewAdmin.getId().setText("");
       viewAdmin.getKontak().setText("");
        viewAdmin.getDurasi().setText("");
         viewAdmin.getBill().setText("");
          viewAdmin.getStatus().setText("");
           viewAdmin.getRoom().setText("");
        
       
    }
  public void update()
    {
     ModelAdmin admin = new ModelAdmin();
     admin.setName(viewAdmin.getNama().getText());
     admin.setId(viewAdmin.getId().getText());
     admin.setContact(viewAdmin.getKontak().getText());
     admin.setDuration(Integer.parseInt(viewAdmin.getDurasi().getText()));
     admin.setBill(Integer.parseInt(viewAdmin.getBill().getText()));
     admin.setStatus(viewAdmin.getStatus().getText());
     admin.setRoom(viewAdmin.getRoom().getText());
     iAdmin.update(admin);

}
  public void delete() {
        ModelAdmin admin = new ModelAdmin();
        iAdmin.delete(Integer.parseInt(viewAdmin.getId().getText()));
        JOptionPane.showMessageDialog(null, "Delete Berhasil");
    }
}
