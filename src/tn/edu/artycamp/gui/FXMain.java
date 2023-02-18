/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class FXMain extends Application {
    private Parent root;
    private Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
        
     
            
        try {
            root = FXMLLoader.load(getClass().getResource("AffichageReclamation.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("../gui/Messagerie.fxml"));
        
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Affichage Reclamation");
            primaryStage.setScene(scene);
            primaryStage.show();
            } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
