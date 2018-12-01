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
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MyPC
 */
public class ChapDao {
    
    
    public static List<Chap> listChap(String type,String typeValue){
        List<Chap> chaps = new ArrayList<>();
        Connection connection =null;
        Statement stmt = null;
        Chap chap = null;
        ResultSet rs = null;
        String query = "Select * from chap where "+type+"='"+typeValue+"'";
        makeQuerry(connection, stmt, rs, query, chap, chaps);
        return chaps;
    }
    public static void makeQuerry(Connection connection, Statement stmt, ResultSet rs, String query, Chap chap,List<Chap> chaps){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/readbookwebappdb","lenawesome", "ngocanh123");
            stmt = (Statement) connection.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                chap = new Chap();
                chap.setId(rs.getInt("id"));
                chap.setId_novel(rs.getInt("novel_id"));
                chap.setName(rs.getString("name"));
                chap.setChap_numb(rs.getInt("numb_chap"));
                if(rs.getString("content").isEmpty()){
                    chap.setContent("Chưa có nội dung cho chap này");
                }else{
                    chap.setContent(rs.getString("content"));
                }
                chaps.add(chap);
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
    }
}
