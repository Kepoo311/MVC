/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import mvc.interfaceKontak;

import Model.kontak;
import View.KontakView;
import View.kontakEdit;
import View.kontakTambah;
import java.util.List;
import javax.swing.JOptionPane;
import mvc.mvcKontak;
/**
 *
 * @author riand
 */
public class controlEdit {
    kontakEdit frame;
    interfaceKontak infcKontak;
    
    public controlEdit(kontakEdit frame){
        this.frame = frame;
        infcKontak = new mvcKontak();
    }
    
    public void tampilkan_data(kontak kontak1){
        frame.setTxtNama(kontak1.getNama());
        frame.setTxtNomor(kontak1.getNomor());
    }
    
        public void editData(int id){
        kontak kontak_edit = new kontak();
        
        kontak_edit.setNama(frame.getTxtNama().getText());
        kontak_edit.setNomor(frame.getTxtNomor().getText());
        kontak_edit.setId(id);
        
        infcKontak.update(kontak_edit);
        JOptionPane.showMessageDialog(frame, "Edit data berhasil");
        kembali();
        }
        
    
    public void kembali(){
        frame.dispose();
        new KontakView().setVisible(true);
    }
}
