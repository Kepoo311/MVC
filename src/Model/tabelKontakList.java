/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author riand
 */
public class tabelKontakList extends AbstractTableModel {
    List<kontak> List_kontak;
    
    public tabelKontakList(List<kontak> List_kontak){
        this.List_kontak = List_kontak;
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return List_kontak.size();
    }
    
        @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "nama";
            case 1:
                return "nomor";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
         switch (column) {
            case 0:
                return List_kontak.get(row).getNama();
            case 1:
                return List_kontak.get(row).getNomor();
            default:
                return null;
        }
    }
    
}
