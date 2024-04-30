/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import mvc.interfaceKontak;

import Model.kontak;
import View.KontakView;
import View.kontakDetail;
import View.kontakEdit;
import mvc.mvcKontak;

/**
 *
 * @author riand
 */
public class controlDetail {

    kontakDetail frame;
    interfaceKontak infcKontak;

    public controlDetail(kontakDetail frame) {
        this.frame = frame;
        infcKontak = new mvcKontak();
    }
    
    public void tampilKontak(kontak kontak1){
        frame.setOutNama(kontak1.getNama());
        frame.setOutNomor(kontak1.getNomor());
    }
    
    public void hapus(int id){
        infcKontak.delete(id);
        kembali();
    }
    
    public void halaman_edit(kontak kontak1){
        frame.dispose();
        new kontakEdit(kontak1).setVisible(true);
    }
    
    public void kembali(){
        frame.dispose();
        new KontakView().setVisible(true);
    }
}
