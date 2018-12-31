/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Rating {
    private int point;

   
    private String idusers;
    private int idnovels;

    public int getPoint() {
        return point;
    }
    public Rating() {
    }
    public void setPoint(int point) {
        this.point = point;
    }

    public String getIdusers() {
        return idusers;
    }

    public void setIdusers(String idusers) {
        this.idusers = idusers;
    }

    public int getIdnovels() {
        return idnovels;
    }

    public void setIdnovels(int idnovels) {
        this.idnovels = idnovels;
    }

    public Rating(int point, String idusers, int idnovels) {
        this.point = point;
        this.idusers = idusers;
        this.idnovels = idnovels;
    }
}
