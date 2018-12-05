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

/**
 *
 * @author MyPC
 */
public class UserDao {
    public static void addUser(String userName,String password){
        String query = "Insert Into user (name,password) values (?,?)";
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, userName);
            stmt.setString(2, password);
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
    
    public static boolean loginCheck(String userName, String password){
        String query = "Select * from user where name = ? and password = ?";
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, userName);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                return true;
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
        return false;
    }
    public static boolean registerCheck(String userName){
        String query = "Select * from user where name = ?";
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                return false;
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
        return true;
    }
    
}
