/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.entities.User;
import pidev.tools.DataSource;

/**
 *
 * @author Islem
 */
public class ServiceUser implements IService<User> {
    Connection cnx;
    public ServiceUser() {
        this.cnx = DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouteru(User t) {
       try {
            String req = "INSERT INTO `user`(id,nom,prenom,username,role,pw) VALUES ('" + t.getId()+"','"+ t.getNom() + "','" + t.getPrenom()  + "','"+t.getUsername()+"','" + t.getRole()+"','"+ t.getPw()+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("User ajouté avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifieru(User t,int id) {
        try {
            String req="UPDATE user SET nom=?,prenom=?,username=?,role=?,pw=? where id =?"+id ;
            PreparedStatement st = cnx.prepareStatement(req);
            //Mouch mohem tartib les instruction numero ya3ty indication 3al blasetha fel requete
           st.setString(1,t.getNom());
            st.setString(2,t.getPrenom());
            st.setString(3,t.getUsername());
            st.setString(4,t.getRole());
	   st.setString(5,t.getPw());
	     st.setInt(6,t.getId());
            
            st.executeUpdate();
            System.out.println("User Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void supprimeru(int id) {
         try {
            String req = "DELETE FROM user WHERE id="+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("User supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public User login(String userName, String password){
        User u = null;
        
        try {
            PreparedStatement statement = this.cnx.prepareStatement(
    "SELECT * FROM user WHERE username=?");
            
            statement.setString(1,userName);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
              
                if(rs.getString("pw").equals(password)){
                    u = new User();
                    
                    u.setId(rs.getInt("id"));
                    u.setNom(rs.getString("nom"));
                    u.setPrenom(rs.getString("prenom"));
                    u.setUsername(rs.getString("username"));
                    u.setUsername(rs.getString("role"));
                    u.setPw(rs.getString("pw"));
                    
                    
                }
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return u;
    }

    @Override
    public User getOneu(  int id) {
      User c1 =new User();
        try {
            PreparedStatement statement = this.cnx.prepareStatement(
    "SELECT * FROM user WHERE id=?");
            
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                
                 c1. setId(rs.getInt("id"));
                c1.setNom(rs.getString("nom"));
                c1.setPrenom(rs.getString("prenom"));
                c1.setUsername(rs.getString("username"));
                c1.setUsername(rs.getString("role"));
		c1.setPw(rs.getString("pw"));

                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        
    return c1;
       
    
    }

    
    @Override
    public List<User> getAllu() {
         String rep = "SELECT * FROM user";
        ArrayList<User> c1= new ArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                User t = new User (); 
                t.setId(rs.getInt("id"));
                t.setNom(rs.getString("nom"));
                t.setPrenom(rs.getString("prenom"));
                t.setUsername(rs.getString("username"));
                t.setRole(rs.getString("role"));
		t.setPw(rs.getString("pw"));
                

                c1.add(t);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return c1; 
    }
}
