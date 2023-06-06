/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class TabelModelRenter extends AbstractTableModel{
    List<ModelRenter>listRenter;
    public TabelModelRenter(List<ModelRenter>listRenter){
        this.listRenter = listRenter;
    }
    @Override
    public int getRowCount() {
        return this.listRenter.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0 : return "size";
            case 1 : return "price";
            case 2 : return "status";
            
            default: return null;
            
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return listRenter.get(rowIndex).getSize();
            case 1 : return listRenter.get(rowIndex).getPrice();
            case 2 : return listRenter.get(rowIndex).getStatus();
           
            default: return null;
            
        }
        
    }
    
}
