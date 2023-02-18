/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arty.entities;

/**
 *
 * @author Dhaou Jawher
 */
public class ArtCategory {
    private int cat_id;
    private String Cat;
    private String logo;

    public ArtCategory(String Cat, String logo) {
        this.Cat = Cat;
        this.logo = logo;
    }
    
public ArtCategory(){}

    public ArtCategory(int cat_id, String Cat) {
        this.cat_id = cat_id;
        this.Cat = Cat;
    }

    public ArtCategory(String Cat) {
        this.Cat = Cat;
    }

    public int getCat_id() {
        return cat_id;
    }

    public String getCat() {
        return Cat;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public void setCat(String Cat) {
        this.Cat = Cat;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "ArtCategory{" + "cat_id=" + cat_id + ", Cat=" + Cat + '}';
    }

}