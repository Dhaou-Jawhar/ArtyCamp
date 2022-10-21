/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import tn.edu.artycamp.tools.DataSource;
import tn.edu.artycamp.entities.CategorieArticles;
/**
 *
 * @author msi
 */
public class ServiceCategorieArticles implements IService<CategorieArticles> {
    
    Connection cnx;

    public ServiceCategorieArticles() {
        this.cnx = DataSource.getInstance().getConnection();
    }

    /*   private int idAvis;
    private int rate;
    private String comment; */
    /**
     * ******** Ajouter CategorieArticles
     *
     * @param p *******
     */
    @Override
    public void ajouter(CategorieArticles p) {
        try {
            String req = "INSERT INTO `CategorieArticles`(`nomc`, `logo`)"
                    + "VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNomC());
            ps.setString(2, p.getLogo());
            ps.executeUpdate();
            System.out.println("CategorieArticles created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * ******** Supprimer CategorieArticles
     *
     * @param id *******
     */
    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `CategorieArticles` WHERE idC = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("CategorieArticles deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * ******** Modifier CategorieArticles
     *
     * @param p
     * @param id ******
     */
    public void modifier(CategorieArticles p, int id) {
        try {
            String req = "UPDATE CategorieArticles SET nomc=?, logo = ?  WHERE idC =" + id;
            PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.setString(1, p.getNomC());
            ps.setString(2, p.getLogo());
            ps.executeUpdate();
            System.out.println("CategorieArticles updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * *** methode getAll() CategorieArticles
     *
     * @return  **
     */
    public List<CategorieArticles> AfficherCategorie() {
        String req = "SELECT * FROM `CategorieArticles`";
        ArrayList<CategorieArticles> CategorieArticles = new ArrayList<>();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
           
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                CategorieArticles p = new CategorieArticles();
                p.setIdC(rs.getInt(1));
                p.setNomC(rs.getString(2));
                p.setLogo(rs.getString(3));
                CategorieArticles.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return CategorieArticles;
    }
    /******************************* SearchById CategorieArticles
     * @param id
     * @return
     * @throws java.sql.SQLException  *********************************************/
     public CategorieArticles SearchById(long id) throws SQLException{
       
        CategorieArticles CategorieArticles = new CategorieArticles();
        try{
        String query = "select * from CategorieArticles where idC="+id;
        Statement stm = cnx.createStatement();
        ResultSet rs= stm.executeQuery(query);
        while (rs.next()){
        CategorieArticles.setIdC(rs.getInt("idC"));
        CategorieArticles.setNomC(rs.getString("nomc"));
        CategorieArticles.setLogo(rs.getString("logo"));
       
       }
        }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         return CategorieArticles;
     }
     /*
          AvisArticle AvisArticle = new AvisArticle();
        try{
        String query = "select * from AvisArticle where idAvis="+id;
        Statement stm = cnx.createStatement();
        ResultSet rs= stm.executeQuery(query);
        while (rs.next()){
        AvisArticle.setIdAvis(rs.getInt("idAvis"));
        AvisArticle.setRate(rs.getInt("rate"));
        AvisArticle.setComment(rs.getString("comment"));
       
        }
        }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         return AvisArticle;
     }
*/

    @Override
    public void modifier(CategorieArticles t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategorieArticles getOne(CategorieArticles t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CategorieArticles> getAll(CategorieArticles t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    /**
     *
     * @param p
     */
    