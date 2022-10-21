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
public class AvisArticle {
    private int idAvis;
    private int rate;
    private String comment;
    private ArticleArtiste article;

    public AvisArticle() {
    }

    public AvisArticle(int idAvis, int idAA, int rate, String comment, ArticleArtiste article) {
        this.idAvis = idAvis;

        this.rate = rate;
        this.comment = comment;
        this.article = article;
    }

    public AvisArticle(int rate, String comment, ArticleArtiste article) {
     
        this.rate = rate;
        this.comment = comment;
        this.article = article;
    }

    public int getIdAvis() {
        return idAvis;
    }

    

    public int getRate() {
        return rate;
    }

    public String getComment() {
        return comment;
    }

    public ArticleArtiste getArticle() {
        return article;
    }

    public void setIdAvis(int idAvis) {
        this.idAvis = idAvis;
    }



    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setArticle(ArticleArtiste article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "AvisArticle{" + "idAvis=" + idAvis +  ", rate=" + rate + ", comment=" + comment + ", article=" + article + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.idAvis;
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
        final AvisArticle other = (AvisArticle) obj;
        if (this.idAvis != other.idAvis) {
            return false;
        }
        return true;
    }

  


}
