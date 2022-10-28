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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.artycamp.entities.Reclamation;
import tn.edu.artycamp.entities.User;
import tn.edu.artycamp.tools.DataSource;
import java.sql.Date;
/**
 *
 * @author user
 */
//bib stream  
 public class ServiceReclamationadmin implements IService<Reclamation> {
   private Connection cnx;
   private Statement ste;
    public ServiceReclamationadmin() {
        cnx = DataSource.getInstance().getConnection();
    }
  
    /*************Ajoute
     * @param ra
     * @param rar*
     * @throws java.sql.SQLException**********/
  public void ajouter(Reclamation ra) throws SQLException{
       
          ste= cnx.createStatement(); 
       LocalDate daterec=LocalDate.now();
           String req = "INSERT INTO artycamp.`reclamationadmin`( `idU`,`Date`, `msg`, `object`) VALUES ('"+ra.getIdU()+"','"+daterec+"','"+ra.getMsg()+"','"+ra.getObject()+"')";
      ste.executeUpdate(req);
      System.out.println("reclamation ajouter avec success");       
    }
   
  
  /*************Supprimer***********/
      public void supprimer(int id) {
          PreparedStatement stu = null; 
try {
            String req = "DELETE FROM `reclamationadmin` WHERE idU = " + id;
           stu = new DataSource().getConnection().prepareStatement(req);
            stu.executeUpdate(req);
            System.out.println("reclamation supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }
      
      
      /*************getAll***********/
      public List<Reclamation> getAll (){
        List<Reclamation> myList = new ArrayList<>();
        
        try {
            String requete1 = "SELECT * FROM reclamationadmin";
           Statement st = new DataSource().getConnection().createStatement();
            ResultSet rs = st.executeQuery(requete1);
            
            while(rs.next()){
                Date recda=rs.getDate("date");
                String msgrec=rs.getString("msg");
                String objrec=rs.getString("object");
                int idurec=rs.getInt("idu");
                Reclamation recl= new Reclamation(recda, msgrec,objrec,idurec);
                //ajouter dans la liste tous les GET
                myList.add(recl);
            } 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
      
      /*************getOne***********/
      public Reclamation getOne (int idu){ 
       Reclamation rec1 = new Reclamation();
        
        try {
            String requete1 = "SELECT * FROM reclamationadmin WHERE (idU = " + idu  + ")" ;
           Statement st = new DataSource().getConnection().createStatement();
            ResultSet rs = st.executeQuery(requete1);
            
            while(rs.next()){
                    
                    rec1.setId(rs.getInt("id"));                
                    rec1.setDate(rs.getDate("Date"));
                    rec1.setMsg(rs.getString("msg"));
                    rec1.setObject(rs.getString("object"));
                    rec1.setIdU(rs.getInt("idU"));
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return rec1;
      }
      
      /**********************modifier*******************************/
public void modifier(Reclamation rv) throws SQLException{
    LocalDate daterec= LocalDate.now();
     String req ="UPDATE artycamp.`reclamationadmin` SET `Date`='"+daterec+"',`msg`='"+rv.getMsg()+"',`object`='"+rv.getObject()+"',`idU`='"+rv.getIdU()+"'WHERE `artycamp`.`reclamationadmin`.`idU`='"+rv.getIdU()+"'";
     ste = cnx.createStatement();
             ste.executeUpdate(req);
      System.out.println("reclamation Modifié avec succés");
       }

    @Override
    public Reclamation getOne(Reclamation id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public void modifier(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   }