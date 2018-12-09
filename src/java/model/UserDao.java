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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.ChapDao.makeQuerry;

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
   public static void updateUser(String name,String pass,String userName){
        String query = "Update user set name=?,password=?"
                + "where name=?";
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, pass);
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
     public static void deleteUser(String userName){
        String query = "Delete from user where name = ?";
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, userName);
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
     public static List<User> findUser(String userName){
        String query = "Select * from user where name =? ";
        List<User> users = new ArrayList<>();
        User user = null;
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            makeQuerry(rs,user, users);
        } catch (SQLException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
            connection.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(NovelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return users;
    }
    public static List<User> listUsers(){
        String query = "Select * from user";
        List<User> users = new ArrayList<>();
        User user = null;
        Connection connection = ConnectionManagement.getConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            makeQuerry(rs,user, users);
        } catch (SQLException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
            connection.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(NovelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return users;
    }
     public static void makeQuerry(ResultSet rs,User user,List<User> users){
        try {
            while(rs.next()){
                user = new User();
                user.setName(rs.getString("name"));
                user.setPass(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "Select * from user where lower(name) = ?";
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
     public static boolean adminCheck(String userName){
        String query = "Select * from admin where lower(name) = ?";
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
     
      public static List<User> listUserBySearching(String input){
        String query = "Select * from user where name like ?";
        List<User> users = new ArrayList<>();
        User user = null;
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1,"%"+ input+"%");
            ResultSet rs = stmt.executeQuery();
            makeQuerry(rs, user, users);
        } catch (SQLException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
            connection.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(NovelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return users;
    }
    
}
