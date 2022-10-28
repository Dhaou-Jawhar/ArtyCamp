/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arty.services;

import Arty.entities.Avis;
import Arty_DB.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dhaou Jawher
 */
public class GestionAvis implements IService<Avis> {
    
    Connection c ; 
    public GestionAvis ()
    {
        c = MyConnection.getInstance().getCnx();
    }
    
        /*--------------------------------------[ADD NFT]----------------------------------------------------*/
    public void ajouter(Avis a) {
        PreparedStatement pst = null;
        try {
            String requete = "INSERT INTO Avis (Avis_Type)"
                    + "VALUES (?)";
            pst = new MyConnection().getCnx().prepareStatement(requete);
        
            pst.setString(1, a.getAvis_Type());
            
            pst.executeUpdate();
            System.out.println("Avis added");
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        }
    
        /*--------------------------------------[DELETE NFT]----------------------------------------------------*/
    public void supprimer(int Avis_id) {
        try {
            String req = "DELETE FROM Avis WHERE Avis_id = ?" ;
            PreparedStatement p = c.prepareStatement(req);
            p.setInt(1, Avis_id);
            p.executeUpdate();
            
            System.out.println("Avis DELETED");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
        /*--------------------------------------[UPDATE NFT]----------------------------------------------------*/
    
   public void modifier(Avis a, int avis_id) {
        
        try {
            String req = "UPDATE Avis SET Avis_Type = ? where avis_id = "+ avis_id ;
            PreparedStatement p = c.prepareStatement(req);
            p.setString(1, a.getAvis_Type());
            
            p.executeUpdate();
            System.out.println("Avis UPDATED");
              
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }
       
      /*--------------------------------------[Afficher ALL]----------------------------------------------------*/
   
   public List<Avis> afficher (){
        List<Avis> myList = new ArrayList();
        
        try {
            String requete1 = "SELECT * FROM Avis";
           Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete1);
            
            while(rs.next()){
                Avis a = new Avis();
                
                a.setAvis_id(rs.getInt(1));
                a.setAvis_Type(rs.getString("Avis_Type"));
                
                //ajouter dans la liste tous les GET
                myList.add(a);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
   
 /*--------------------------------------[Afficher One]----------------------------------------------------*/


    @Override
   public Avis getOne (int avis_id){
        Avis a1 = new Avis();
        
        try {
            String requete1 = "SELECT * FROM Avis WHERE avis_id = " +avis_id;
           Statement st1 = new MyConnection().getCnx().createStatement();
           ResultSet rs1 = st1.executeQuery(requete1);
            
            while(rs1.next()){
               
                
                
                a1.setAvis_id(rs1.getInt(1));
                a1.setAvis_Type(rs1.getString("Avis_Type"));
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return a1;
    }

    @Override
    public List<Avis> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



