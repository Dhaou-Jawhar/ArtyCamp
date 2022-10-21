/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.artycamp.entities.Reclamation;
import tn.edu.artycamp.services.ServiceReclamationadmin;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLController implements Initializable {

    @FXML
    private Button bouton_retourrecla;
    @FXML
    private TextField iduserrecla;
    @FXML
    private TextArea objecterecla;
    @FXML
    private TextArea contenuerecla;
    @FXML
    private Button bouton_envoyerrecla;
    @FXML
    private Button bouton_annulerrecla;
    @FXML
    private Button consulterreclamation;
    @FXML
    private DatePicker agenda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clikretourrecla(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/FXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                stage.show(); 
        
    }

    @FXML
    private void clikenvoyerrecla(ActionEvent event) {
     ServiceReclamationadmin serv= new ServiceReclamationadmin();
        LocalDate daterec=LocalDate.now();
  
   Reclamation r = new Reclamation(0,Integer.parseInt(iduserrecla.getText()),11,contenuerecla.getText()); 
   serv.ajouter(r);
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION );
        alert.setTitle("Ajouter");
        alert.setHeaderText("Information");
        alert.setContentText("reclamation bien Ajouter!");
        alert.show();
            
    }

    @FXML
    private void clikannulerrecla(ActionEvent event) {
        contenuerecla.setText("");  
    iduserrecla.setText("");
   
    }

    @FXML
    private void clikconsulterreclamation(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageReclamationController.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                stage.show();   
    }

    @FXML
    private void agendee(ActionEvent event) {
    }
    
}
