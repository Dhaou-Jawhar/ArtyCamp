/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtyCamp;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import tn.edu.artycamp.entities.Messagerie;
import tn.edu.artycamp.entities.Reclamation;
//import tn.edu.artycamp.entities.Reclamation;
import tn.edu.artycamp.services.ServiceReclamationadmin;
import tn.edu.artycamp.services.ServiceMessagerie;
import tn.edu.artycamp.tools.DataSource;

/**
 *
 * @author user
 */
public class ArtyCamp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        DataSource.getInstance();
      LocalDate date=LocalDate.now();
     
      /////////// TEST RECLAMATION /////////////////////////
      
      
     /* ServiceReclamationadmin recad= new ServiceReclamationadmin();
      Reclamation rec1= new Reclamation(38,"hahzn","dfy",12) ;
      System.out.println(""+date); 
     //rec1.setIdU(38);
     //recad.ajouter(rec1);
    // recad.supprimer(11);
  // System.out.print(recad.getAll()+"\n");
   System.out.print(recad.getOne(12)+"\n");*/
   //recad.modifier(rec1);
      
 
   
   /////////// TEST MESSAGERIE /////////////////////////
   
  ServiceMessagerie recvis= new ServiceMessagerie();
  Messagerie messa = new Messagerie();

 messa.setMsg("dfg5hk");
 messa.setVu(false);
  messa.setIdU(25);
 messa.setIdex(11);
 messa.setIdrec(15);
 messa.setNomex("hhah");
 messa.setNomrec("hanen");
// recvis.ajouter(messa);
  //recvis.modifier(messa);
  recvis.supprimer(47);
    System.out.print(recvis.getAll()+"\n");
 System.out.print(recvis.getOne(27)+"\n");
    }
    
}
