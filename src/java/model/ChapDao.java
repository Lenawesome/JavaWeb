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
/**
 *
 * @author MyPC
 */
public class ChapDao {
    
    
    public List<Chap> listChap() throws SQLException, ClassNotFoundException{
        Chap chap = new Chap();
        List<Chap> chaps = new ArrayList<>();
        Connection connection =null;
        String query = "Select * from chap";
        ResultSet rs = connect(query,connection);
        if(rs!=null){
            readResulset(rs,chap,chaps);
        }
    return chaps;

    }
    
    public void makeQuery(String type,String typeValue,Connection connection,List<Chap> chaps,Chap chap) throws ClassNotFoundException, SQLException{
        String query = "Select * from chap where "+type+"='"+typeValue+"'";
        ResultSet rs = connect(query,connection);
        readResulset(rs,chap,chaps);
    }
    public void readResulset(ResultSet rs,Chap chap,List<Chap> chaps) throws SQLException{
        while(rs.next()){
                chap = new Chap();
                chap.setId(rs.getInt("id"));
                chap.setId_novel(rs.getInt("novel_id"));
                chap.setName(rs.getString("name"));
                if(rs.getString("content").isEmpty()){
                    chap.setContent("Chưa có nội dung cho chap này");
                }else{
                    chap.setContent(rs.getString("content"));
                }
                chaps.add(chap);
            }
    }
    public ResultSet connect(String query,Connection connection) throws ClassNotFoundException, SQLException{
            Statement stmt = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/readbookwebappdb","lenawesome", "ngocanh123");
            stmt = (Statement) connection.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
    }
}
