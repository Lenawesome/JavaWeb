/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.NovelDao.getConnection;

/**
 *
 * @author MyPC
 */
public class AdminFunction {
    public static void listBy(String type,String typeValue){
        String query = "Insert Into genre (name,description) values (N?,?)";
        Connection connection =getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, typeValue);
            stmt.setString(2, "abc");
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NovelDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
            connection.close();
            stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(NovelDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
