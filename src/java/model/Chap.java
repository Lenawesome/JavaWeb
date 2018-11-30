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
    private int chap_numb;

    public Chap(int id, int id_novel, String name, String content, int chap_numb) {
        this.id = id;
        this.id_novel = id_novel;
        this.name = name;
        this.content = content;
        this.chap_numb = chap_numb;
    }
    public Chap() {
    }

    public int getChap_numb() {
        return chap_numb;
    }

    public void setChap_numb(int chap_numb) {
        this.chap_numb = chap_numb;
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
