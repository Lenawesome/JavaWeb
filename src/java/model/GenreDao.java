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
public class GenreDao {
    
    public static List<Genre> listAllGenres() {
        List<Genre> genres = new ArrayList<>();
        Connection connection =null;
        Statement stmt = null;
        try {
            Genre genre = new Genre();
            ResultSet rs = null;
            String query = "Select * from genre";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/readbookwebappdb","lenawesome", "ngocanh123");
            stmt = (Statement) connection.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                genre = new Genre();
                genre.setId(rs.getInt("id"));
                genre.setName(rs.getString("name"));
                genre.setDescription(rs.getString("description"));
                genres.add(genre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
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
        return genres;
    }
     public static List<Genre> listGenreByIdNovel(String typeValue){
        List<Genre> genres = new ArrayList<>();
        Connection connection =null;
        Statement stmt = null;
        try {
            Genre genre = new Genre();
            ResultSet rs = null;
            String query = "Select * from genre,novel_genre where"
                    + " genre.id = novel_genre.genre_id and novel_genre.novel_id='"+typeValue+"'";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/readbookwebappdb","lenawesome", "ngocanh123");
            stmt = (Statement) connection.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                genre = new Genre();
                genre.setId(rs.getInt("id"));
                genre.setName(rs.getString("name"));
                genre.setDescription(rs.getString("description"));
                genres.add(genre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
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
        return genres;
    }
      public static List<Genre> listGenreByIdGenre(String typeValue){
        List<Genre> genres = new ArrayList<>();
        Connection connection =null;
        Statement stmt = null;
        try {
            Genre genre = new Genre();
            ResultSet rs = null;
            String query = "Select * from genre where id ='"+typeValue+"'";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/readbookwebappdb","lenawesome", "ngocanh123");
            stmt = (Statement) connection.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                genre = new Genre();
                genre.setId(rs.getInt("id"));
                genre.setName(rs.getString("name"));
                genre.setDescription(rs.getString("description"));
                genres.add(genre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChapDao.class.getName()).log(Level.SEVERE, null, ex);
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
        return genres;
    }
}
