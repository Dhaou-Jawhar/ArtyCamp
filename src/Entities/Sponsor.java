/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Ben Nasr
 */
public class Sponsor {
    private int id_sponsor;
    private int phone_societe;
    private int montant;
    private String nom_societe;
    private String email_societe; 
    //private Event event;
 
    public Sponsor() {
    }
    

    public Sponsor(int phone_societe, int montant, String nom_societe, String email_societe) {
        this.phone_societe = phone_societe;
        this.montant = montant;
        this.nom_societe = nom_societe;
        this.email_societe = email_societe;
        
    }
    
    public Sponsor(int id_sponsor, int phone_societe, int montant, String nom_societe, String email_societe) {
        this.id_sponsor = id_sponsor;
        this.phone_societe = phone_societe;
        this.montant = montant;
        this.nom_societe = nom_societe;
        this.email_societe = email_societe;
    }

    public Sponsor(int id_sponsor) {
        this.id_sponsor = id_sponsor; 
    }

    public int getId_sponsor() {
        return id_sponsor;
    }

    public void setId_sponsor(int id_sponsor) {
        this.id_sponsor = id_sponsor;
    }

    public int getPhone_societe() {
        return phone_societe;
    }

    public void setPhone_societe(int phone_societe) {
        this.phone_societe = phone_societe;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getNom_societe() {
        return nom_societe;
    }

    public void setNom_societe(String nom_societe) {
        this.nom_societe = nom_societe;
    }

    public String getEmail_societe() {
        return email_societe;
    }

    public void setEmail_societe(String email_societe) {
        this.email_societe = email_societe;
    }

   /* public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    */

    @Override
    public String toString() {
        return "Sponsor{" + "phone_societe=" + phone_societe + ", montant=" + montant + ", nom_societe=" + nom_societe + ", email_societe=" + email_societe + '}'+"\n";
    }
    


        
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
