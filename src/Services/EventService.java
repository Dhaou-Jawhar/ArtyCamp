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

import Tools.BD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Ben Nasr
 */
public class EventService implements IService<Event> {
    Connection cnx; 
    public EventService()
    {
        this.cnx = BD.getInstance().getCnx();
    }

    @Override
    public void ajouter(Event s) {       
       try {
            String req = "INSERT INTO event(nomEv,description,dateDeb,dateFin) VALUES ('"+s.getNomEv()+"','"+s.getDescription()+"','"+s.getDateDeb()+"','"+s.getDateFin()+"')";

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
            String req="update event SET nomEv='"+s.getNomEv()+"',description='"+s.getDescription()+"',dateDeb='"+s.getDateDeb()+"',dateFin='"+s.getDateFin()+"' where id='"+s.getId()+"'" ;
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
            String req = "DELETE FROM event WHERE id="+s.getId()+"";
                    
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("evenement supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
    }

   /* @Override
    public Event getOne(int id) {
        Event e= new Event();
        try {
            PreparedStatement d = this.cnx.prepareStatement("SELECT * FROM event WHERE id=?");
            d.setInt (1,id);
            ResultSet rs= d.executeQuery();
            while (rs.next()) {
                e.setId(rs.getInt("id"));
                e.setNomEv(rs.getString("nomEv"));
                e.setDescription(rs.getString("description"));
                e.setDateDeb(rs.getString("DateDeb"));
                e.setDateFin(rs.getString("DateFin"));
            }
                
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
     return e;   
    }*/

    @Override
    public ObservableList<Event> getAll() {
        ObservableList<Event> listEvenement = FXCollections.observableArrayList();
        try {
            String req="select * from event" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                int id=rs.getInt("id");
                String nom=rs.getString("nomEv");
                String desc=rs.getString("description");
                String dd=rs.getString("DateDeb");
                String df=rs.getString("DateFin");
                
               
                listEvenement.add(new Event(id,nom,desc,dd,df));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listEvenement ;  
    }

 }
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


