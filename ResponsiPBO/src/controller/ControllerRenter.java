/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAO.DAORenter;
import Interface.InterfaceRenter;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelRenter;
import model.TabelModelRenter;
import view.ViewRenter;


/**
 *
 * @author HP
 */
public class ControllerRenter {
  ViewRenter viewRenter;
 InterfaceRenter iRenter;
 List<ModelRenter>listRenter;
  public ControllerRenter(ViewRenter viewRenter){
      this.viewRenter = viewRenter;
      iRenter = new DAORenter();
  }
    public void readData(){
      listRenter = iRenter.getAll();
      TabelModelRenter tabelRenter=  new TabelModelRenter(listRenter);
      viewRenter.getjTable1().setModel(tabelRenter);
}
}
