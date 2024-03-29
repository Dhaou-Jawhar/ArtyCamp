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
import tn.edu.artycamp.entities.Reclamation;
import tn.edu.artycamp.entities.Messagerie;
import tn.edu.artycamp.tools.DataSource;

/**
 *
 * @author user
 */

public class ServiceMessagerie implements IService<Messagerie>{
   Connection cnx;

    public ServiceMessagerie() {
        cnx = DataSource.getInstance().getConnection();
    }  
    /*************Ajouter***********/
     public void ajouter(Messagerie ms){
          PreparedStatement stu1 = null;
        try{
        String req = "INSERT INTO `messagerie`(`msg`, `vu`, `idU`, `idex`,`idrec`,`Nomex`,`Nomrec`) VALUES ('"+ms.getMsg()+"','"+ms.isVu()+"','"+ms.getIdU()+"','"+ms.getIdex()+"','"+ms.getIdrec()+"','"+ms.getNomex()+"','"+ms.getNomrec()+"')";
        // String req = "INSERT INTO `messagerie`(`msg`, `vu`, `idU`, `idex`,`idrec`) VALUES ('"+ms.getMsg()+"','"+ms.isVu()+"','"+getUser(+"','"+ms.getIdex()+"','"+ms.getIdrec()+"')";
        stu1 = new DataSource().getConnection().prepareStatement(req);
       stu1.executeUpdate();
         System.out.println("Messagerie ajoutée avec succés");
        
        }catch (SQLException ex){
            
            System.err.println(ex.getMessage());
        }
     }
     /*************Supprimerv***********/
      public void supprimer(int idv) {
          PreparedStatement stu1 = null;
try {
            String reqv = "DELETE FROM `messagerie` WHERE idmsg = " + idv;
           stu1 = new DataSource().getConnection().prepareStatement(reqv);
            stu1.executeUpdate(reqv);
            System.out.println("Messagerie supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }
      
      /*************getAll***********/
       public List<Messagerie> getAll (){
        List<Messagerie> Listv = new ArrayList();
        
        try {
            String requete1 = "SELECT * FROM Messagerie";
           Statement stv = new DataSource().getConnection().createStatement();
            ResultSet rsv = stv.executeQuery(requete1);
            
            while(rsv.next()){
                 Messagerie messg = new Messagerie();
                    messg.setIdmsg(rsv.getInt("idmsg"));                
                    messg.setMsg(rsv.getString("msg"));
                    messg.setVu(rsv.getBoolean("vu"));
                    messg.setIdU(rsv.getInt("idU"));
                    messg.setIdex(rsv.getInt("idex"));
                   messg.setIdrec(rsv.getInt("idrec"));
                   messg.setNomex(rsv.getString("Nomex"));
                   messg.setNomrec(rsv.getString("Nomrec"));
                //ajouter dans la liste tous les GET
                Listv.add(messg);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Listv;
    }
      
      /*************getOne***********/
       public Messagerie getOne (int idv){ 
       Messagerie recv1 = new Messagerie();
        
        try {
            String requete1 = "SELECT * FROM messagerie WHERE idmsg = " + idv ;
           Statement st = new DataSource().getConnection().createStatement();
            ResultSet rs = st.executeQuery(requete1);
            
            while(rs.next()){
                    recv1.setIdmsg(rs.getInt("idmsg"));                
                    recv1.setMsg(rs.getString("msg"));                
                    recv1.setVu(rs.getBoolean("vu"));
                    recv1.setIdU(rs.getInt("idU"));
                    recv1.setIdex(rs.getInt("idex"));
                    recv1.setIdrec(rs.getInt("idrec"));
                    recv1.setNomex(rs.getString("Nomex"));
                    recv1.setNomrec(rs.getString("Nomrec"));
                    
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return recv1;
      }
     /**************Modifier**************/
      public void modifier(Messagerie rv){
       try{ 
        String reqv ="UPDATE messagerie SET msg = ?,vu = ?, idU=?, idex=?, idrec=? ";
        PreparedStatement stu1 = new DataSource().getConnection().prepareStatement(reqv);
        stu1.setString(1,rv.getMsg());
        stu1.setBoolean(2, rv.isVu());
        stu1.setInt(3,rv.getIdU());
        stu1.setInt(4,rv.getIdex());
        stu1.setInt(5,rv.getIdrec());
        stu1.executeUpdate();
        System.out.println("messagerie modifiée avec succés");
       }catch (SQLException ex) {
          System.out.println(ex.getMessage());  
        }
       }

    @Override
    public Messagerie getOne(Messagerie id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String isVu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}