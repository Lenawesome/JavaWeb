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
        String query = "Select * from chap where "+type+"=?";
        List<Chap> chaps = new ArrayList<>();
        Chap chap = null;
        Connection connection = NovelDao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, typeValue);
            ResultSet rs = stmt.executeQuery();
            makeQuerry(rs,chap, chaps);
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
        return chaps;
    }
    public static void makeQuerry(ResultSet rs,Chap chap,List<Chap> chaps){
        try {
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
        }
    }
}
