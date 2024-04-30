/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mvc;

import Model.kontak;
import java.util.List;

/**
 *
 * @author riand
 */
public interface interfaceKontak {
    public void insert(kontak kontak1);

    public void update(kontak kontak1);

    public void delete(int id);

    public List<kontak> getData();
    public List<kontak> getSearch(String nama);
}
