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
public class ArtVIP {
    
    private int artID;
    private String art_nom;
    private String art_description;
    private String reference;
    private ArtCategory category;
    private int idCategory;

    public ArtVIP() {
    }

    public ArtVIP(int artID, String art_nom, String reference, String art_description, int idCategory) {
        this.artID = artID;
        this.art_nom = art_nom;
        this.reference = reference;
        this.art_description = art_description;
        this.idCategory = idCategory;
    }

    public ArtVIP(int artID, String art_nom, String art_description, String reference) {
        this.artID = artID;
        this.art_nom = art_nom;
        this.art_description = art_description;
        this.reference = reference;
    }

    public ArtVIP(String art_nom, String art_description, String reference, int idCategory) {
        this.art_nom = art_nom;
        this.art_description = art_description;
        this.reference = reference;
        this.idCategory = idCategory;
    }

    public ArtVIP(int artID, String art_nom, String art_description, String reference, ArtCategory category, int idCategory) {
        this.artID = artID;
        this.art_nom = art_nom;
        this.art_description = art_description;
        this.reference = reference;
        this.category = category;
        this.idCategory = idCategory;
    }

    public ArtVIP(String art_nom, String art_description, String reference) {
        this.art_nom = art_nom;
        this.art_description = art_description;
        this.reference = reference;
    }
    
    

    public int getArtID() {
        return artID;
    }

    public String getArt_nom() {
        return art_nom;
    }

    public String getArt_description() {
        return art_description;
    }

    public String getReference() {
        return reference;
    }

    public ArtCategory getCategory() {
        return category;
    }

    public int getIdCategory() {
        return idCategory;
    }


    public void setArtID(int artID) {
        this.artID = artID;
    }

    public void setArt_nom(String art_nom) {
        this.art_nom = art_nom;
    }

    public void setArt_description(String art_description) {
        this.art_description = art_description;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setCategory(ArtCategory category) {
        this.category = category;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.artID;
        return hash;
    }

    @Override
    public String toString() {
        return "ArtVIP{" + "artID=" + artID + ", art_nom=" + art_nom + ", art_description=" + art_description + ", reference=" + reference + ", category=" + category + ", idCategory=" + idCategory + '}';
    }
    
    
    
    
}
