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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class RatingDao {
    public static void addRating(int point, int idNovel, String userName){
       
        String query = "Insert Into rating (point,idnovels,idusers) values (?,?,?)";
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, point);
            stmt.setInt(2, idNovel);
            stmt.setString(3, userName);
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
    public static int ratingCheck(int idNovel, String userName){
        String query = "Select * from rating where idnovels = ? and idusers = ?";
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, idNovel);
            stmt.setString(2, userName);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int point = rs.getInt("point");
                return point;
            }
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
        return 0;
    }
}
