/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    
    public static List<Novel> listNovel(){
        Novel novel = null;
        List<Novel> novels = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String query = "Select * from novel";
            ResultSet rs = stmt.executeQuery(query);
            makeQuery(novel, rs, novels);
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
        return novels;
    }
    
    public static List<Novel> listBy(String type,String typeValue){
        String query = "Select * from novel where "+type+"= ?";
        Novel novel = null;
        List<Novel> novels = new ArrayList<>();
        Connection connection =ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, typeValue);
            ResultSet rs = stmt.executeQuery();
            makeQuery(novel, rs, novels);
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
        return novels;
    }
    
    public static List<Novel> listNovelByGenreId(String genreId){
        String query = "Select * from novel,novel_genre where"
                + " novel.id = novel_genre.novel_id and novel_genre.genre_id=?";
        Novel novel = null;
        List<Novel> novels = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, genreId);
            ResultSet rs = stmt.executeQuery();
            makeQuery(novel, rs, novels);
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
        return novels;
    }
    
    public static List<Novel> listNovelBySearching(String type,String typeValue){
        String query = "Select * from novel where "+type+" like ?";
//        String query = "Select * from novel where match("+type+") against (N?)";
        List<Novel> novels = new ArrayList<>();
        Novel novel = null;
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, "%"+typeValue+"%");
            ResultSet rs = stmt.executeQuery();
            makeQuery( novel, rs, novels);
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
        return novels;
    }
    public static List<Novel> listNovelHot(){
        Novel novel = null;
        List<Novel> novels = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String query = "SELECT * FROM novel ORDER BY rating DESC LIMIT 6";
            ResultSet rs = stmt.executeQuery(query);
            makeQuery(novel, rs, novels);
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
        return novels;
    }
    
    public static void makeQuery(Novel novel, ResultSet rs,List<Novel> novels) {
        try {
            while(rs.next()){
                novel = new Novel();
                novel.setId(rs.getInt("id"));
                novel.setImgLink(rs.getString("image").trim());
                novel.setName(rs.getString("name").trim());
                if(rs.getString("description").isEmpty()){
                    novel.setDescription("Chưa có mô tả truyện cho truyện này");
                }else{
                    novel.setDescription(rs.getString("description").trim());
                }
                novel.setAuthor(rs.getString("author").trim());
                novel.setStatus(rs.getString("status").trim());
                novel.setRating(rs.getFloat("rating"));
                novels.add(novel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
}
