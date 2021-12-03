/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasapp.dao;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tugasapp.model.databaseconfig;
import tugasapp.model.uangkas;
//import tugasapp.dao.tugasdao;

/**
 *
 * @author wardatumilah
 */
public class tugasdaoperoses implements tugasdao {

    Connection connection = null;
    ResultSet resultset = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    @Override
    public boolean save(uangkas uangkas) {
        boolean flag = false;
        try {
            String sql = "INSERT INTO kas(nim, nama, bulan, bayar)VALUES"
                    + "(?,?,?,?)";
            connection = databaseconfig.openconnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uangkas.getNim());
            preparedStatement.setString(2, uangkas.getNama());
            preparedStatement.setString(3, uangkas.getBulan());
            preparedStatement.setString(4, uangkas.getBayar());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<uangkas> get() {
        List<uangkas> list = null;
        uangkas kas = null;
        try {
            list = new ArrayList<>();
            String sql = "SELECT * FROM kas";
            connection = databaseconfig.openconnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                kas = new uangkas();
                kas.setId(resultset.getInt("id"));
                kas.setNim(resultset.getString("nim"));
                kas.setNama(resultset.getString("nama"));
                kas.setBulan(resultset.getString("bulan"));
                kas.setBayar(resultset.getString("bayar"));
                list.add(kas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public uangkas getSinggle(int id) {
        uangkas kas = null;
        try {
            String sql = "SELECT * from kas where id=?";
            connection = databaseconfig.openconnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                kas = new uangkas();
                kas.setId(resultset.getInt("id"));
                kas.setNim(resultset.getString("nim"));
                kas.setNama(resultset.getString("nama"));
                kas.setBulan(resultset.getString("bulan"));
                kas.setBayar(resultset.getString("bayar"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kas;
    }

    @Override
    public boolean update(uangkas uangkas) {
        boolean flag = false;
        try {
            String sql = "update kas set nim=?, nama=?, bulan=?, bayar=? where id=?";
            connection = databaseconfig.openconnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uangkas.getNim());
            preparedStatement.setString(2, uangkas.getNama());
            preparedStatement.setString(3, uangkas.getBulan());
            preparedStatement.setString(4, uangkas.getBayar());
            preparedStatement.setInt(5, uangkas.getId());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;

    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "delete from kas where id=?";
            connection = databaseconfig.openconnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

}
