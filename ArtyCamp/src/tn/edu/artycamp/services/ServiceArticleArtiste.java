/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.Services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.artycamp.entities.ArticleArtiste;
import tn.edu.artycamp.tools.DataSource;

/**
 *
 * @author msi
 */


public class ServiceArticleArtiste implements IService<ArticleArtiste>{
     Connection cnx;

    public ServiceArticleArtiste() {
        this.cnx = DataSource.getInstance().getConnection();
    }
    
    
    //      *************************   Ajouter un article    *************************
    
    /*
    private int idArticle;

    private String nomA;
    private String discriptionA;
    private int views;
    private CategorieArticles categorie;
    private String imageh;

*/
public void ajouter(ArticleArtiste t) {
        try {
           
            String req = "INSERT INTO `ArticleArtiste`(idCategorie,nomA,discriptionA,views,imageh)" + "VALUES (?,?,?,0,?)";
            PreparedStatement ps = cnx.prepareStatement(req); 
            
           
            ps.setInt(1, t.getIdCategorie());
            ps.setString(2, t.getNomA());
            ps.setString(3, t.getDiscriptionA());
            //ps.setInt(4, t.getViews());
            ps.setString(4, t.getImageh());
          
            ps.executeUpdate(); 
            System.out.println("Article created !");
      
           //l'execute update: on l'utilise pour mettre à jour notre BD telque les requetes (insertion/supprition/modification) 
           //l'execute query: on l'utilise pour les requetes (select) 
               
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
//      *************************   Modifier un article    *************************
    
     public void modifier(ArticleArtiste Ar,int id){
        try {
            String req ="UPDATE ArticleArtiste SET idCategorie=?, nomA = ?,discriptionA = ?,imageh=? where idArticle = "+id;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Ar.getIdCategorie());
            ps.setString(1, Ar.getNomA());
            ps.setString(2, Ar.getDiscriptionA());
            ps.setString(2, Ar.getImageh());
            ps.executeUpdate();
            System.out.println("ArticleArtiste updated!");
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());  
        }
    }


    
    //      *************************   Supprimer un article    *************************
   
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `ArticleArtiste` WHERE idArticle = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Article deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

//      *************************   Affichier la liste des articles    *************************
    public List<ArticleArtiste> AfficherArticles () {
        String rep = "SELECT * FROM `ArticleArtiste`";
        ArrayList<ArticleArtiste> ArticleArtiste = new ArrayList<>();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                ArticleArtiste p = new ArticleArtiste();
                
                
                p.setNomA(rs.getString(1));
                p.setIdCategorie(rs.getInt(2));
                p.setDiscriptionA(rs.getString(3));
                p.setImageh(rs.getString(4));
                p.setViews(rs.getInt(5));
                

                ArticleArtiste.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ArticleArtiste;
    }
/******************************* SearchById ArticleArtiste
     * @param id
     * @return
     * @throws java.sql.SQLException  *********************************************/

 public ArticleArtiste SearchById(long id) throws SQLException{
        
        ArticleArtiste AA = new ArticleArtiste();
        try{
        String query = "select * from ArticleArtiste where idArticle="+id;
        Statement stm = cnx.createStatement();
        ResultSet rs= stm.executeQuery(query);
        while (rs.next()){
       
        AA.setNomA(rs.getString("nomA"));
        AA.setIdCategorie(rs.getInt("idCategorie"));
        AA.setDiscriptionA(rs.getString("discriptionA"));
        AA.setImageh(rs.getString("imageh"));
        AA.setViews(rs.getInt("views"));
        }
       } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return AA;
}

}
