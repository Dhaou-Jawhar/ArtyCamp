/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtyCamp;

import java.sql.Date;
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
    public static void main(String[] args) {
        // TODO code application logic here
        DataSource.getInstance();
      LocalDate date=LocalDate.now();
      
      ServiceReclamationadmin recad= new ServiceReclamationadmin();
      Reclamation rec1= new Reclamation("d8jk","dfy") ;
       System.out.println(""+date); 
     rec1.setIdU(18);
    rec1.setDate(new Date(122,10,14));
     //recad.ajouter(rec1);
       recad.supprimer(18);
   //System.out.print(recad.getAll()+"\n");
    //System.out.print(recad.getOne(16,17)+"\n");
  // ServiceMessagerie recvis= new ServiceMessagerie();
  // Messagerie messa = new Messagerie("hsdksk");
   //messa.setVu(true);
 //  messa.setIdU(12);
  // messa.setIdex(14);
  // messa.setIdrec(13);
  //recvis.ajouter(messa);
  //recad.modifier(messa,18);
    //recvis.supprimer(5);
    //System.out.print(recvis.getAll()+"\n");
  // System.out.print(recvis.getOne(3)+"\n");
    }
    
}
