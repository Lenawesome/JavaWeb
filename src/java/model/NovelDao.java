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
    
    public static List<Novel> listNovel(){
        List<Novel> novels = new ArrayList<>();
        Connection connection =null;
        Statement stmt = null;
        String query = "Select * from novel";
        Novel novel = null;
        ResultSet rs = null;
        makeQuery(connection, stmt, novel, rs, query, novels);
        return novels;
    }
    
    public static List<Novel> listBy(String type,String typeValue){
        List<Novel> novels = new ArrayList<>();
        Connection connection =null;
        Statement stmt = null;
        Novel novel = null;
        ResultSet rs = null;
        String query = "Select * from novel where "+type+"='"+typeValue+"'";
        makeQuery(connection, stmt, novel, rs, query, novels);
        return novels;
    }
      public static List<Novel> listNovelByGenreId(String genreId){
        List<Novel> novels = new ArrayList<>();
        Connection connection =null;
        Statement stmt = null;
        Novel novel = null;
        ResultSet rs = null;
        String query = "Select * from novel,novel_genre where"
                + " novel.id = novel_genre.novel_id and novel_genre.genre_id='"+genreId+"'";
        makeQuery(connection, stmt, novel, rs, query, novels);
        return novels;
    }

    private static void makeQuery(Connection connection, Statement stmt, Novel novel, ResultSet rs, String query, List<Novel> novels) {
        try {
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

    }
}
