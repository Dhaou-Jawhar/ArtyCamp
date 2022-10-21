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
import tn.edu.artycamp.entities.Utilisateur;
import tn.edu.artycamp.tools.DataSource;
import java.sql.Date;
/**
 *
 * @author user
 */
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
  public void ajouter(Reclamation ra){
       
       PreparedStatement stu = null;
        try{
            
        String req= "INSERT INTO reclamationadmin (idU,Date,msg,object)" + "VALUES(?,?,?,?)";
        stu = new DataSource().getConnection().prepareStatement(req);
       LocalDate Date=LocalDate.now();
       // stu.setInt(1, ra.getId());
        stu.setInt(1,ra.getIdU());
        stu.setDate(2,ra.getDate());
        stu.setString(3, ra.getMsg());
        stu.setString(4, ra.getObject());
        stu.executeUpdate();
        System.out.println("reclamation ajoutée");
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
            
    }
    /*************Supprimer***********/
      public void supprimer(int id) {
          PreparedStatement stu = null;
try {
            String req = "DELETE FROM `reclamationadmin` WHERE id = " + id;
           stu = new DataSource().getConnection().prepareStatement(req);
            stu.executeUpdate(req);
            System.out.println("reclamation supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }
      
      /*************getAll***********/
      public List<Reclamation> getAll (){
        List<Reclamation> myList = new ArrayList();
        
        try {
            String requete1 = "SELECT * FROM reclamationadmin";
           Statement st = new DataSource().getConnection().createStatement();
            ResultSet rs = st.executeQuery(requete1);
            
            while(rs.next()){
               // Reclamation reclamation = new Reclamation();
                    
                   /* reclamation.setId(rs.getInt("id"));                
                    reclamation.setDate(rs.getDate("Date"));
                    reclamation.setMsg(rs.getString("msg"));
                    reclamation.setObject(rs.getString("object"));
                    reclamation.setIdU(rs.getInt("idu"));
                    //reclamation.setUser(rs.getU);*/
              int idr=rs.getInt("id");
                Date recda=rs.getDate("date");
                String msgrec=rs.getString("msg");
                String objrec=rs.getString("object");
                int idurec=rs.getInt("idu");
                Reclamation recl= new Reclamation(idr,recda, msgrec,objrec,idurec);
              
                
                //ajouter dans la liste tous les GET
                myList.add(recl);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
      
      /*************getOne***********/
      public Reclamation getOne (int id, int idU){ 
       Reclamation rec1 = new Reclamation();
        
        try {
            String requete1 = "SELECT * FROM reclamationadmin WHERE (id = " + id + " and idU = " + idU + ")" ;
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
public void modifier(Reclamation rv,int idv){
       try{ 
        String reqv ="UPDATE reclamationadmin SET Date = ?,msg = ? ,object = ?, idU=? where id = "+idv;
        PreparedStatement stu1 = new DataSource().getConnection().prepareStatement(reqv);
        stu1.setInt(4,rv.getIdU());
        stu1.setDate(1,rv.getDate());
        stu1.setString(2, rv.getMsg());
        stu1.setString(3, rv.getObject());
        stu1.executeUpdate();
        System.out.println("reclamation modifiée avec succés");
       }catch (SQLException ex) {
          System.out.println(ex.getMessage());  
        }
       }
///////////////Rechercher///////////////
public List<Reclamation> rechercheReclamationParUser(int idu) {
    
            List<Reclamation> reclamation = new ArrayList<>();
try{
        String req="SELECT * FROM `reclamationadmin` where `idU`="+idu+"";
        
            PreparedStatement stu1 = new DataSource().getConnection().prepareStatement(req);
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                   
                  rs.getInt("id");                
                   rs.getDate("Date");
                   rs.getString("msg");
                    rs.getString("object");
                    rs.getInt("idU");
                
            }
    }catch (SQLException ex) {
          System.out.println(ex.getMessage());  
        }
            return reclamation;
    }
    @Override
    public void modifier(Reclamation ra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reclamation getOne(Reclamation id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   }