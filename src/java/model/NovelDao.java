/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;






/**
 *
 * @author MyPC
 */
public class NovelDao {
    private static final String USERNAME="lenawesome";
    private static final String PASSWORD="ngocanh123";
    private static final String CONN_STRING=
            "jdbc:mysql://localhost:3306/readbookwebappdb";
    
    public List<Novel> listNovel(){
        List<Novel> novels = new ArrayList<>();
        Connection connection =null;
        Statement stmt = null;
        try {
            Novel novel = new Novel();
            ResultSet rs = null;
            String query = "Select * from novel";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/readbookwebappdb","lenawesome", "ngocanh123");
            stmt = (Statement) connection.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                novel = new Novel();
                novel.setId(rs.getInt("id"));
                novel.setImgLink(rs.getString("image").trim());
                novel.setName(rs.getString("name").trim());
                novel.setCategories(rs.getString("categories").trim());
                if(rs.getString("description").isEmpty()){
                    novel.setDescription("Chưa có mô tả truyện cho truyện này");
                }else{
                    novel.setDescription(rs.getString("description").trim());
                }
                novel.setAuthor(rs.getString("author").trim());
                novel.setStatus(rs.getString("status").trim());
                novels.add(novel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovelDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(connection!=null)
                    connection.close();
                if(stmt!=null)
                     stmt.close();
            }catch (SQLException ex) {
                    Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return novels;
    }
    
    public List<Novel> listBy(String type,String typeValue) throws SQLException{
        List<Novel> novels = new ArrayList<>();
        Connection connection =null;
        Statement stmt = null;
        try {
            Novel novel = new Novel();
            ResultSet rs = null;
            String query = "Select * from novel where "+type+"='"+typeValue+"'";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/readbookwebappdb","lenawesome", "ngocanh123");
            stmt = (Statement) connection.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                novel = new Novel();
                novel.setId(rs.getInt("id"));
                novel.setImgLink(rs.getString("image").trim());
                novel.setName(rs.getString("name").trim());
                novel.setCategories(rs.getString("categories").trim());
                if(rs.getString("description").isEmpty()){
                    novel.setDescription("Chưa có mô tả truyện cho truyện này");
                }else{
                    novel.setDescription(rs.getString("description").trim());
                }
                novel.setAuthor(rs.getString("author").trim());
                novel.setStatus(rs.getString("status").trim());
                novels.add(novel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovelDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(connection!=null)
                    connection.close();
                if(stmt!=null)
                     stmt.close();
            }catch (SQLException ex) {
                    Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return novels;
    }
//        String query = "Select * from novel where status='Full'";
    
    public void makeQuery(String type,String typeValue,Connection connection,List<Novel> novels,Novel novel) throws ClassNotFoundException, SQLException{
        String query = "Select * from novel where "+type+" ='"+typeValue.trim()+"'";
        ResultSet rs = connect(query,connection);
        if(rs!=null){
            readResulset(rs,novel,novels);
        }
    }
    public void readResulset(ResultSet rs,Novel novel,List<Novel> novels){
        try {
            while(rs.next()){
                novel = new Novel();
                novel.setId(rs.getInt("id"));
                novel.setImgLink(rs.getString("image").trim());
                novel.setName(rs.getString("name").trim());
                novel.setCategories(rs.getString("categories").trim());
                if(rs.getString("description").isEmpty()){
                    novel.setDescription("Chưa có mô tả truyện cho truyện này");
                }else{
                    novel.setDescription(rs.getString("description").trim());
                }
                novel.setAuthor(rs.getString("author").trim());
                novel.setStatus(rs.getString("status").trim());
                novels.add(novel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NovelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet connect(String query,Connection connection) throws SQLException {
            Statement stmt = null;
            ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/readbookwebappdb","lenawesome", "ngocanh123");
            stmt = (Statement) connection.createStatement();
            rs = stmt.executeQuery(query);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovelDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NovelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            return rs;
    }
}
