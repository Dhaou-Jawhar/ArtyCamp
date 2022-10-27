/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artycampp;

//import java.sql.Connection;
import Entities.Event;
import Entities.Sponsor;
import Services.EventService;
import Services.SponsorService;






/**
 *
 * @author Ben Nasr
 */
public class ArtyCampp  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       EventService es = new EventService();
       //es.getAllEvMont();
       //es.getAllEvTitle();
        //Event e1 = new Event("design","logo","11/10/2022","11/11/2022");
        
        //Event e = new Event("compétition","design","13/07","20/07");
        //Event e1 = new Event("event2","NFT","09/10/2022","11/10/2022");
      //  es.ajouter(e1);
        //es.modifier(e1,1);
        //es.supprimer(2);
        //SponsorService ss = new SponsorService();
        //Sponsor s1 = new Sponsor (22,1000,"IBN","aaa@bb.com");
        //Sponsor s3 = new Sponsor (12345,600,"AZ","AZ@esprit.com");
        //ss.supprimer(1);
        //ss.modifier(2);
       // es.getAll();
      //  es.GetEventById(4);
     //   ss.getOne(1);
     es.GetEventSponsorById(1);
        es.GetSponsorById(1);
        //ss.ajouter(s1);
        
     //   System.out.println(es.getOne(1));
        
        //launch(args);
        
        
    }

    
    
}
