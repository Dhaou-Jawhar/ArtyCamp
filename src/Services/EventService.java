/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entities.Event;
import Entities.Sponsor;

import Tools.BD;
import static java.nio.file.Files.list;
import static java.util.Collections.list;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Ben Nasr
 */
public class EventService implements IService<Event> {

    Connection cnx;

    public EventService() {
        this.cnx = BD.getInstance().getCnx();
    }

    @Override
    public void ajouter(Event s) {
        try {
            String req = "INSERT INTO event(nomEv,description,dateDeb,dateFin) VALUES ('" + s.getNomEv() + "','" + s.getDescription() + "','" + s.getDateDeb() + "','" + s.getDateFin() + "')";

            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("evenement ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifier(Event s) {
        try {
            String req = "update event SET nomEv='" + s.getNomEv() + "',description='" + s.getDescription() + "',dateDeb='" + s.getDateDeb() + "',dateFin='" + s.getDateFin() + "' where id='" + s.getId() + "'";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("evenement Modifier avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void supprimer(Event s) {
        try {
            String req = "DELETE FROM event WHERE id=" + s.getId() + "";

            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("evenement supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public Event getOne(int id) {

        String req = "SELECT * FROM event WHERE id="+id;
        Event e = new Event();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
             //   System.out.println("ghhhhhhhhhhhhh");
                
                e.setId(rs.getInt(1));
                e.setNomEv(rs.getString(2));
                e.setDescription(rs.getString(3));
                e.setDateDeb(rs.getString(4));
                e.setDateFin(rs.getString(5));
                //   System.out.println(e);
                return e;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public ObservableList<Event> getAll() {

        ObservableList<Event> listEvenement = FXCollections.observableArrayList();
        try {
            String req = "select * from event";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nomEv");
                String desc = rs.getString("description");
                String dd = rs.getString("DateDeb");
                String df = rs.getString("DateFin");

                listEvenement.add(new Event(id, nom, desc, dd, df));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listEvenement;
    }

    public int Total() {
        int n = 0;
        try {
            String req = "SELECT * from event";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                n = n + 1;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return n;
    }
    
    

    public Event GetEventById(int id) {

        String req = "SELECT * FROM event WHERE id="+id;
        Event e = new Event();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
            //    System.out.println("ghhhhhhhhhhhhh");
                
                e.setId(rs.getInt("id"));
                e.setNomEv(rs.getString("nomEv"));
                e.setDescription(rs.getString("description"));
                e.setDateDeb(rs.getString("DateDeb"));
                e.setDateFin(rs.getString("DateFin"));
              //  System.out.println(e);
                return e;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public Sponsor GetSponsorById(int id) {
        
        
               Sponsor s= new Sponsor();
       String req ="SELECT * FROM sponsor WHERE id_sponsor="+id;
        try {
            Statement st = cnx.createStatement(); 
            
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                s.setId_sponsor(rs.getInt("id_sponsor"));
                s.setPhone_societe(rs.getInt("phone_societe"));
                s.setMontant(rs.getInt("montant"));
                s.setNom_societe(rs.getString("nom_societe"));
                s.setEmail_societe(rs.getString("email_societe"));
                
             //   System.out.println(s);
                return s;
            }
                
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
     return null;   
    }
    
        public ObservableList<Sponsor> GetEventSponsorById(int id)  {
            ObservableList<Sponsor> ls=FXCollections.observableArrayList();
            
            String req="SELECT * FROM eventsponsor WHERE id="+id;
            if(GetEventById(id)!=null){
             System.out.println(GetEventById(id));   
            }else{
                System.out.println("Evenment introuvable");
            }
            Statement stm;
            try{
                stm=this.cnx.createStatement();
                ResultSet rs = stm.executeQuery(req);
                while(rs.next()){
                    Sponsor s=new Sponsor();
                    s=GetSponsorById(rs.getInt(2));
                    ls.add(s);
                    
                }
                System.out.println(ls);
                
                
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            
            
            
            return ls;
            
        }
    

}