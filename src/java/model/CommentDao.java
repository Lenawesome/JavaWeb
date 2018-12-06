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
import static model.NovelDao.makeQuery;

/**
 *
 * @author MyPC
 */
public class CommentDao {
    public static void addComment(String userName, String content, String date,int idNovel){
       
        String query = "Insert Into comments (novel_id,content,time,username) values (?,?,?,?)";
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, idNovel);
            stmt.setString(2, content);
            stmt.setString(3, date);
            stmt.setString(4, userName);
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
    
    public static List<Comment> listCommentNovel(String id,int limit){
        String query = "Select * from comments where novel_id = ? ORDER BY id DESC limit ?";
        Comment comment = null;
        List<Comment> comments = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setInt(2, limit);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setIdNovel(rs.getInt("novel_id"));
                comment.setContent(rs.getString("content"));
                comment.setTime(rs.getString("time"));
                comment.setUserName(rs.getString("username"));
                comments.add(comment);
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
        return comments;
    }
}

