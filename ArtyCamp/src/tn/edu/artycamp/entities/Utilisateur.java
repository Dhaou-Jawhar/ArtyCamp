/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.entities;



/**
 *
 * @author user
 */
public class Utilisateur {
     private int idU;
    private String nom;
    private String Prenom;

    public Utilisateur() {
    }

    public Utilisateur(int idU, String nom, String Prenom) {
        this.idU = idU;
        this.nom = nom;
        this.Prenom = Prenom;
    }

    public Utilisateur(int idU, String nom) {
        this.idU = idU;
        this.nom = nom;
    }

    public Utilisateur(String nom, String Prenom) {
        this.nom = nom;
        this.Prenom = Prenom;
    }

    public int getIdu() {
        return idU;
    }

    public void setIdu(int idU) {
        this.idU = idU;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idU;
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
        final Utilisateur other = (Utilisateur) obj;
        if (this.idU != other.idU) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idU=" + idU + ", nom=" + nom + ", Prenom=" + Prenom + '}';
    }
    
}
