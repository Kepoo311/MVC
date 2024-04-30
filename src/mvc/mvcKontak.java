/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc;

import Controller.koneksi;
import Model.kontak;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author riand
 */
public class mvcKontak implements interfaceKontak{
    Connection connection;
    final String insert = "INSERT INTO kontak (nama,nomor) VALUES (?, ?);";
    final String update = "UPDATE kontak SET nama=?, nomor=? WHERE id=? ;";
    final String delete = "DELETE FROM kontak WHERE id=? ;";
    final String select = "SELECT * FROM kontak ORDER BY nama ASC;";
    final String search = "SELECT * FROM kontak WHERE nama LIKE ? ORDER BY nama ASC;";
    
    public mvcKontak() {
        try {
            connection = koneksi.koneksiDB();
        } catch (SQLException ex) {
            Logger.getLogger(mvcKontak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(kontak kontak1) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, kontak1.getNama());
            statement.setString(2, kontak1.getNomor());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(kontak kontak1) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, kontak1.getNama());
            statement.setString(2, kontak1.getNomor());
            statement.setInt(3, kontak1.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<kontak> getData() {
        List<kontak> listKontak = null;
        try {
            listKontak = new ArrayList<kontak>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                kontak kontak1 = new kontak();
                kontak1.setId(rs.getInt("id"));
                kontak1.setNama(rs.getString("nama"));
                kontak1.setNomor(rs.getString("nomor"));
                listKontak.add(kontak1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mvcKontak.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listKontak;
    }

    @Override
    public List<kontak> getSearch(String nama) {
         List<kontak> listKontak = null;
        try {
            listKontak = new ArrayList<kontak>();
            PreparedStatement st = connection.prepareStatement(search);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                kontak kontak1 = new kontak();
                kontak1.setId(rs.getInt("id"));
                kontak1.setNama(rs.getString("nama"));
                kontak1.setNomor(rs.getString("nomor"));
                listKontak.add(kontak1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mvcKontak.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listKontak;
    }
    
    
}
