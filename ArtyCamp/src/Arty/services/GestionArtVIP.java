/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arty.services;
import Arty.entities.ArtVIP;
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
public class GestionArtVIP {
    private Statement ste;
    Connection c ; 
    public GestionArtVIP ()
    {
        c = MyConnection.getInstance().getCnx();
    }
    
        /*--------------------------------------[ADD 3D]----------------------------------------------------*/
        public void ajouter(ArtVIP v) {
        PreparedStatement pst = null;
        try {
            String requete = "INSERT INTO ArtVIP (cat_id, art_nom, art_description, reference)"
                    + "VALUES (?,?,?,?)";
            pst = new MyConnection().getCnx().prepareStatement(requete);
        
            pst.setInt(1, v.getIdCategory());
            pst.setString(2, v.getArt_nom());
            pst.setString(3, v.getArt_description());
            pst.setString(4, v.getReference());
            
            
            pst.executeUpdate();
            System.out.println("Art added");
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
        
                 /*--------------------------------------[DELETE NFT]----------------------------------------------------*/
    public void supprimer(int artID) {
        try {
            String req = "DELETE FROM ArtVIP WHERE artID = ?" ;
            PreparedStatement p = c.prepareStatement(req);
            p.setInt(1, artID);
            p.executeUpdate();
            
            System.out.println("3D DELETED");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
            /*--------------------------------------[UPDATE NFT]----------------------------------------------------*/
    
   public void modifier(ArtVIP v, int artID) {
        
        try {
            String req = "UPDATE ArtVIP SET cat_id = ? , art_nom = ? , art_description = ?  ,reference= ?  where artID = "+ artID ;
            PreparedStatement p = c.prepareStatement(req);
            
            p.setInt(1, v.getIdCategory());
            p.setString(2, v.getArt_nom());
            p.setString(3, v.getArt_description());
            p.setString(4, v.getReference());
            
            p.executeUpdate();
            System.out.println("3D UPDATED");
              
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }
    
           /*--------------------------------------[Afficher ALL]----------------------------------------------------*/
   
   public List<ArtVIP> afficher (){
        List<ArtVIP> myList = new ArrayList();
        
        try {
            String requete1 = "SELECT * FROM ArtVIP";
           Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete1);
            
            while(rs.next()){
               ArtVIP v = new ArtVIP();
                
                v.setIdCategory(rs.getInt("idCategory"));
                v.setArt_nom(rs.getString("art_nom"));
                v.setArt_description(rs.getString("art_description"));
                v.setReference(rs.getString("reference"));
                
                //ajouter dans la liste tous les GET
                myList.add(v);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    

/*--------------------------------------[Afficher One]----------------------------------------------------*/


   public ArtVIP getOne (int artID){
            ArtVIP v1 = new ArtVIP();
        
        try {
            String requete1 = "SELECT * FROM ArtVIP WHERE artID = "+artID;
           Statement st1 = new MyConnection().getCnx().createStatement();
           ResultSet rs1 = st1.executeQuery(requete1);
            
            while(rs1.next()){
               
                
                v1.setIdCategory(rs1.getInt("idCategory"));
                v1.setArt_nom(rs1.getString("art_nom"));
                v1.setArt_description(rs1.getString("art_description"));
                v1.setReference(rs1.getString("reference"));
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return v1;
    }
   
   /*------------------------------------------------------------------------------------------------*/
   
    public List<ArtVIP> GetAll() throws SQLException {
            List<ArtVIP> art = new ArrayList<>();
            ste = c.createStatement();
            
            ResultSet rs = ste.executeQuery("SELECT * FROM ArtVIP");
            while(rs.next()){
                int artID=rs.getInt("artID");
                String art_nom=rs.getString("art_nom");
                String art_description=rs.getString("art_description");
                String reference=rs.getString("reference");
                int idCategory=rs.getInt("idCategory");
                
                ArtVIP ar = new ArtVIP(artID,art_nom,reference,art_description,idCategory);
                art.add(ar);
            }
        return art;
    }
}