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
import tn.edu.artycamp.entities.AvisArticle;
import tn.edu.artycamp.tools.DataSource;

/**
 *
 * @author msi
 */
public class ServiceAvisArticle implements IService<AvisArticle> {

    Connection cnx;

    public ServiceAvisArticle() {
        this.cnx = DataSource.getInstance().getConnection();
    }

    /*   private int idAvis;
    private int rate;
    private String comment; */
    /**
     * ******** Ajouter AvisArticle
     *
     * @param p *******
     */
    @Override
    public void ajouter(AvisArticle p) {
        try {
            String req = "INSERT INTO `AvisArticle`(`rate`, `comment`)"
                    + "VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, p.getRate());
            ps.setString(2, p.getComment());
            ps.executeUpdate();
            System.out.println("AvisArticle created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * ******** Supprimer AvisArticle
     *
     * @param id *******
     */
    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `AvisArticle` WHERE idAvis = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("AvisArticle deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * ******** Modifier AvisArticle
     *
     * @param p
     * @param id ******
     */
    public void modifier(AvisArticle p, int id) {
        try {
            String req = "UPDATE AvisArticle SET rate=?, comment = ?  WHERE idAvis =" + id;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, p.getIdAvis());
            ps.setString(2, p.getComment());
            ps.executeUpdate();
            System.out.println("AvisArticle updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * *** methode getAll() AvisArticle
     *
     * @return  **
     */
    public List<AvisArticle> AfficherAvis() {
        String req = "SELECT * FROM `AvisArticle`";
        ArrayList<AvisArticle> AvisArticle = new ArrayList<>();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
           
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                AvisArticle p = new AvisArticle();
                p.setIdAvis(rs.getInt(1));
                p.setRate(rs.getInt(2));
                p.setComment(rs.getString(3));
                AvisArticle.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return AvisArticle;
    }
    /******************************* SearchById AvisArticle
     * @param id
     * @return
     * @throws java.sql.SQLException  *********************************************/
     public AvisArticle SearchById(long id) throws SQLException{
        
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



    @Override
    public void modifier(AvisArticle t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AvisArticle getOne(AvisArticle t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AvisArticle> getAll(AvisArticle t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


 