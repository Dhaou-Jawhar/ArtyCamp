/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.u;

import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pidev.entities.User;
import pidev.entities.moderateur;
import pidev.services.ServiceModerateur;
import pidev.services.ServiceUser;
import pidev.tools.DataSource;

/**
 *
 * @author Islem
 */
public class PidevU extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection cnx =DataSource.getInstance().getConnection();
       
      // User u=new User (12,"Ismm","m","dgt","hjk","hh");
        //  User u3 = new User ("bbbbbbbbb","Ism","m","dggtrft","jlm") ;
      // User u1= new    User (1);
       //  ServiceUser su = new ServiceUser ();
      //   su.ajouteru(u);
         //su.ajouteru(u3);
        // su.modifieru(u, 4);
         //su.supprimeru(15);
        // User u2= su.getOneu(2);
         //System.out.println(u3.getId()+","+u3.getNom()+","+u3.getPrenom()+","+u3.getUsername()+","+u3.getPw());
        //System.out.println(su.getAllu());
        //moderateur m1=new moderateur (4,"h","ll","s","hhrhueh");
       //ServiceModerateur mo = new ServiceModerateur();
        //mo.ajouter(m1);
        //mo.modifier(m1);
       //mo.supprimer(4);
       // System.out.println(m1.getId()+","+m1.getNom()+","+m1.getPrenom()+","+m1.getUsername()+","+m1.getPw());
       
        launch(args);
        

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("/FXGUI/FXMLU.fxml"));
         
         Scene scene = new Scene(root);
         
         primaryStage.setScene(scene);
         primaryStage.show();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
