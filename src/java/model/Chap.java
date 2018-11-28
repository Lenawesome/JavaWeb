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
public class Chap {
    private int id;
    private int id_novel;
    private String name;
    private String content;

    public Chap() {
    }

    public Chap(int id, int id_novel, String name, String content) {
        this.id = id;
        this.id_novel = id_novel;
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_novel() {
        return id_novel;
    }

    public void setId_novel(int id_novel) {
        this.id_novel = id_novel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
