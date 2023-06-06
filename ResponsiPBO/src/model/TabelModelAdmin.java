/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lab Informatika
 */
public class TabelModelAdmin extends AbstractTableModel{
    List<ModelAdmin>listAdmin;
    public TabelModelAdmin(List<ModelAdmin>listAdmin){
        this.listAdmin = listAdmin;
    }
    @Override
    public int getRowCount() {
        return this.listAdmin.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0 : return "name";
            case 1 : return "id";
            case 2 : return "contact";
            case 3 : return "duration";
            case 4 : return "bill";
            case 5 : return "status";
            case 6 : return "room";
            default: return null;
            
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return listAdmin.get(rowIndex).getName();
            case 1 : return listAdmin.get(rowIndex).getId();
            case 2 : return listAdmin.get(rowIndex).getContact();
            case 3 : return listAdmin.get(rowIndex).getDuration();
            case 4 : return listAdmin.get(rowIndex).getBill();
            case 5 : return listAdmin.get(rowIndex).getStatus();
            case 6 : return listAdmin.get(rowIndex).getRoom();
            default: return null;
            
        }
        
    }
    
    
}
