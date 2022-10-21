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
import pidev.entities.moderateur;
import pidev.tools.DataSource;

/**
 *
 * @author Islem
 */
public class ServiceModerateur implements Imoderateur<moderateur>{
    Connection cnx;
    public ServiceModerateur() {
        this.cnx = DataSource.getInstance().getConnection();
    
}
@Override
    public void ajouter(moderateur m) {
       try {
            String req = "INSERT INTO `moderateur`(id, nom,prenom,username,pw) VALUES ('" + m.getId()+"','"+ m.getNom() + "','" + m.getPrenom()  + "','"+m.getUsername()+"','"+m.getPw()+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Moderateur ajouté avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(moderateur m) {
        try {
            String req="update moderateur SET nom=?,prenom=?,username=?,pw=? where id =?" ;
            PreparedStatement st = cnx.prepareStatement(req);
            //Mouch mohem tartib les instruction numero ya3ty indication 3al blasetha fel requete
           st.setString(1,m.getNom());
            st.setString(2,m.getPrenom());
            st.setString(3,m.getUsername());
	   st.setString(4,m.getPw());
	   st.setInt(5,m.getId());
            
            st.executeUpdate();
            System.out.println("moderateur Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


    public void supprimer(int id) {
         try {
            String req = "DELETE FROM moderateur WHERE id=" +id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("moderateur supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public moderateur getOne(  int id) {
      moderateur c =new moderateur();
        try {
            PreparedStatement statement = this.cnx.prepareStatement(
    "SELECT * FROM moderateur WHERE id=?");
            
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                
                 c. setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setUsername(rs.getString("username"));
		c.setPw(rs.getString("pw"));

                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        
    return c;
       
    
    }

    
    @Override
    public List<moderateur> getAll() {
         String rep = "SELECT * FROM moderateur";
        ArrayList<moderateur> c= new ArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                moderateur m = new moderateur (); 
                m.setId(rs.getInt("id"));
                m.setNom(rs.getString("nom"));
                m.setPrenom(rs.getString("prenom"));
                m.setUsername(rs.getString("username"));
		m.setPw(rs.getString("pw"));
                

                c.add(m);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return c; 
    }
    
}
