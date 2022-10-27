/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Event;
import Tools.BD;
import Entities.Sponsor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Ben Nasr
 */
public class SponsorService implements IService<Sponsor> {
    Connection cnx; 
    public SponsorService()
    {
        this.cnx = BD.getInstance().getCnx();
    }

    /********************************************************/
    @Override
    public void ajouter(Sponsor s) {
       try {
            String req = "INSERT INTO sponsor (phone_societe, montant, nom_societe, email_societe) VALUES ('"+s.getPhone_societe()+"','"+s.getMontant()+"','"+s.getNom_societe()+"','"+ s.getEmail_societe() +"')";
            
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Sponsor ajouté avec succés");
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /********************************************************/
    @Override
    public void modifier(Sponsor s) {
        try {
            String req = "UPDATE sponsor SET phone_societe = '"+s.getPhone_societe()+"' , montant ='"+s.getMontant()+"'  ,nom_societe = '"+s.getNom_societe()+"', email_societe ='"+s.getEmail_societe()+"'  where id_sponsor =" +s.getId_sponsor() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Sponsor modifié avec succés"); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
    }
    
    /********************************************************/
    @Override
    public void supprimer(Sponsor s) {
         try {
            String req = "DELETE FROM sponsor WHERE id_sponsor ="+s.getId_sponsor()+"";
            
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("sponsor supprimé avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /********************************************************/
   @Override
    public Sponsor getOne(int id_sponsor) {
       Sponsor s= new Sponsor();
       String req ="SELECT * FROM sponsor WHERE id_sponsor="+id_sponsor;
        try {
            Statement st = cnx.createStatement(); 
            
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                s.setId_sponsor(rs.getInt("id_sponsor"));
                s.setPhone_societe(rs.getInt("phone_societe"));
                s.setMontant(rs.getInt("montant"));
                s.setNom_societe(rs.getString("nom_societe"));
                s.setEmail_societe(rs.getString("email_societe"));
                
                System.out.println(s);
            }
                
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
     return s;    
    }
    

    /********************************************************/
    @Override
    public ObservableList<Sponsor> getAll() {
         
        ObservableList<Sponsor> listsponsor = FXCollections.observableArrayList();
        
        
        try {
            String rep = "SELECT * FROM sponsor";
            Statement st = cnx.createStatement(); 
            
            ResultSet rs = st.executeQuery(rep);

            while (rs.next()) {
                int id=rs.getInt("id_sponsor");
                int tel=rs.getInt("phone_societe");
                int montant=rs.getInt("montant");
                String nom=rs.getString("nom_societe");
                String mail=rs.getString("email_societe");
                listsponsor.add(new Sponsor(id,tel,montant,nom,mail) );
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listsponsor;
    }

  /* public int nbreOfSponsors(String pk){
   
       
       return 0;
   }*/
    ///bech n3abiu combobox group by zedneha 5ater ynajem nom yet3aued
     public ObservableList<String> getAllSponsorname() {
        List<Sponsor> listSponsor = new ArrayList();
        ObservableList<String> listSpon =  FXCollections.observableArrayList();
        try {
            String req="SELECT nom_societe FROM sponsor GROUP BY nom_societe" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            while(rs.next()) {
                String NomSp=rs.getString("nom_societe");
                listSponsor.add(new Sponsor(NomSp));
                }
            
            for (int i = 0; i < listSponsor.size(); i++) {
               listSpon.add(listSponsor.get(i).getNom_societe());
            } 
            System.out.println(listSpon);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return listSpon;  
    }
   
//fonction de conversion te5o string ay attribut te5taro w traja3 int

    public int getMdp(String a){
        int id = 0 ;
        try {
            String req="SELECT id_sponsor FROM sponsor WHERE nom_societe = '"+a+"'" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                 id=rs.getInt("id_sponsor");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;  
    }

    

    
    





















































































    
}
