/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arty.services;

import Arty.entities.ArtCategory;
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
public class GestionCategory {
    
    Connection c ; 
    public GestionCategory ()
    {
        c = MyConnection.getInstance().getCnx();
    }
    
    /*--------------------------------------[ADD NFT]----------------------------------------------------*/
    public void ajouter(ArtCategory c) {
        PreparedStatement pst = null;
        try {
            String requete = "INSERT INTO ArtCategory (cat , logo)"
                    + "VALUES (?,?)";
            pst = new MyConnection().getCnx().prepareStatement(requete);
        
            pst.setString(1, c.getCat());
            pst.setString(2, c.getLogo());
            
            pst.executeUpdate();
            System.out.println("Category added");
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        }
    
            /*--------------------------------------[DELETE NFT]----------------------------------------------------*/
    public void supprimer(int cat_id) {
        try {
            String req = "DELETE FROM ArtCategory WHERE cat_id = ?" ;
            PreparedStatement p = c.prepareStatement(req);
            p.setInt(1, cat_id);
            p.executeUpdate();
            
            System.out.println("Category DELETED");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
            /*--------------------------------------[UPDATE NFT]----------------------------------------------------*/
    
   public void modifier(ArtCategory cat, int cat_id) {
        
        try {
            String req = "UPDATE Category SET cat_Type = ? where avis_id = "+ cat_id ;
            PreparedStatement p = c.prepareStatement(req);
            p.setString(1, cat.getCat());
            
            p.executeUpdate();
            System.out.println("Category UPDATED");
              
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }
   
         /*--------------------------------------[Afficher ALL]----------------------------------------------------*/
   
   public List<ArtCategory> afficher (){
        List<ArtCategory> myList = new ArrayList();
        
        try {
            String requete1 = "SELECT * FROM ArtCategory";
           Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete1);
            
            while(rs.next()){
                ArtCategory c = new ArtCategory();
                
                c.setCat_id(rs.getInt(1));
                c.setCat(rs.getString("Cat"));
                
                //ajouter dans la liste tous les GET
                myList.add(c);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
   
   
}
