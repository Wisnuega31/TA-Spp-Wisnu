/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LAB 1 PC 16
 */
public class KoneksiDb {
    Connection con;
    ResultSet rs;
    Statement st;
    public KoneksiDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pembayaran_spp","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public ResultSet ambilData(String sql){
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDb.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public boolean  rubahData(String sql){
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDb.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
