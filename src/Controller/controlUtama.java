/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import mvc.interfaceKontak;

import Model.kontak;
import Model.tabelKontakList;

import View.KontakView;
import View.kontakDetail;
import View.kontakEdit;
import View.kontakTambah;
import java.util.List;
import mvc.mvcKontak;

/**
 *
 * @author riand
 */
public class controlUtama {
    KontakView frame;
    interfaceKontak infcKontak;
    List<kontak> list_kontak;
    
    public controlUtama(KontakView frame){
        this.frame = frame;
        infcKontak = new mvcKontak();
        list_kontak = infcKontak.getData();
    }
    
    public void load_table(){
        tabelKontakList tkl = new tabelKontakList(list_kontak);
        frame.getKontakTable().setModel(tkl);
    }
    
    public void halaman_tambah(){
        frame.dispose();
        new kontakTambah().setVisible(true);
    }
    
    public void hapus_data(int id){
        infcKontak.delete(id);
    }
    
    public void halaman_edit(kontak kontak1){
        frame.dispose();
        new kontakEdit(kontak1).setVisible(true);
    }
    
    
    public void halaman_detail(int row){
        kontak kontak1 = list_kontak.get(row);
        frame.dispose();
        new kontakDetail(kontak1).setVisible(true);
    }
    
    public void search(String nama){
        list_kontak = infcKontak.getSearch(nama);
         tabelKontakList tkl = new tabelKontakList(list_kontak);
          frame.getKontakTable().setModel(tkl);
    }
}
