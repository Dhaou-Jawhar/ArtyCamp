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
public class ArticleArtiste {

    
    /**
     * @param args the command line arguments
     */
    private int idArticle;
    //private Artist artist;
    private int idCategorie;
    private String nomA;
    private String discriptionA;
    private int views;
   // private CategorieArticles categorie;
    private String imageh;

    public ArticleArtiste() {
    }

    public ArticleArtiste(int idArticle, int idCategorie, String nomA, String discriptionA, int views, String imageh) {
        this.idArticle = idArticle;
        this.idCategorie = idCategorie;
        this.nomA = nomA;
        this.discriptionA = discriptionA;
        this.views = views;
        this.imageh = imageh;
    }

    public ArticleArtiste(int idCategorie, String nomA, String discriptionA, int views, String imageh) {
        this.idCategorie= idCategorie;
        this.nomA = nomA;
        this.discriptionA = discriptionA;
        this.views = views;
        //this.categorie = categorie;
        this.imageh = imageh;
    }

    public ArticleArtiste(int idCategorie, String nomA, String discriptionA, String imageh) {
        this.idCategorie = idCategorie;
        this.nomA = nomA;
        this.discriptionA = discriptionA;
        this.imageh = imageh;
    }

 
  
    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

 

    public int getIdArticle() {
        return idArticle;
    }

    public String getNomA() {
        return nomA;
    }

    public String getDiscriptionA() {
        return discriptionA;
    }

    public int getViews() {
        return views;
    }

  /*  public CategorieArticles getCategorie() {
        return categorie;
    }*/

    public String getImageh() {
        return imageh;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public void setNomA(String nomA) {
        this.nomA = nomA;
    }

    public void setDiscriptionA(String discriptionA) {
        this.discriptionA = discriptionA;
    }

    public void setViews(int views) {
        this.views = views;
    }

  /*  public void setCategorie(CategorieArticles categorie) {
        this.categorie = categorie;
    }*/

    public void setImageh(String image) {
        this.imageh = image;
    }

    @Override
    public String toString() {
        return "ArticleArtiste{"+ "idCategorie=" + idCategorie+ "idArticle=" + idArticle + ", nomA=" + nomA + ", discriptionA=" + discriptionA + ", views=" + views + ", image=" + imageh + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idArticle;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArticleArtiste other = (ArticleArtiste) obj;
        return this.idArticle == other.idArticle;
    }

}
