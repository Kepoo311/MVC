/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import mvc.interfaceKontak;

import Model.kontak;
import View.KontakView;
import View.kontakTambah;
import java.util.List;
import javax.swing.JOptionPane;
import mvc.mvcKontak;
/**
 *
 * @author riand
 */
public class controlTambah {
    kontakTambah frame;
    interfaceKontak infcKontak;
    
    public controlTambah(kontakTambah frame){
        this.frame = frame;
        infcKontak = new mvcKontak();
    }
    
    public void tambahData(){
        kontak kontak_baru = new kontak();
        
        kontak_baru.setNama(frame.getTxtNama().getText());
        kontak_baru.setNomor(frame.getTxtNomor().getText());
        
        infcKontak.insert(kontak_baru);
        JOptionPane.showMessageDialog(frame, "Tambah data berhasil");
        kembali();
    }
    
    public void reset(){
        frame.setTxtNama("");
        frame.setTxtNomor("");
    }
    
    public void kembali(){
        frame.dispose();
        new KontakView().setVisible(true);
    }
}
