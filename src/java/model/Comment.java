/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MyPC
 */
public class Comment {
    private int id;
    private int idNovel;
    private String content;
    private String time;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Comment() {
    }

    public Comment(int id, int idNovel, String content, String time, String userName) {
        this.id = id;
        this.idNovel = idNovel;
        this.content = content;
        this.time = time;
        this.userName = userName;
    }

    

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNovel() {
        return idNovel;
    }

    public void setIdNovel(int idNovel) {
        this.idNovel = idNovel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
