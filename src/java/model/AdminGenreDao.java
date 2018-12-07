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
import static model.ChapDao.makeQuerry;
/**
 *
 * @author MyPC
 */
public class AdminGenreDao {
    public static void addGenre(String name, String description){
        String query = "Insert Into genre (name,description) values (?,?)";
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, description);
            ;
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GenreDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
            connection.close();
            stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(GenreDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     public static boolean genreNameCheck(String genreName){
        String query = "Select * from genre where lower(name) = ?";
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, genreName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenreDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
            connection.close();
            stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(GenreDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
     
     public static void updateGenre(String name, String description,String id){
        String query = "Update genre set name=?,description=?"
                + "where id = ?";
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setString(3, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GenreDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
            connection.close();
            stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(GenreDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     public static void deleteGenre(String id){
        String query = "Delete from genre where id = ?";
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(GenreDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
            connection.close();
            stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(GenreDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
}
