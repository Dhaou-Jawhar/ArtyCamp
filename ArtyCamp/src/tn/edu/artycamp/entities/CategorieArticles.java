/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.entities;

/**
 *
 * @author msi
 */
public class CategorieArticles {
    
    private int idC;
    private String nomC;
    private String logo;

    public int getIdC() {
        return idC;
    }

    public CategorieArticles(String nomC, String logo) {
        this.nomC = nomC;
        this.logo = logo;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public CategorieArticles() {
    }

    public CategorieArticles(String nomC) {
        this.nomC = nomC;
    }

    public CategorieArticles(int idC, String nomC) {
        this.idC = idC;
        this.nomC = nomC;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "CategorieArticle{" + "idC=" + idC + ", nomC=" + nomC +", logo=" + logo + '}';
    }

    public void setNomc(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    }
