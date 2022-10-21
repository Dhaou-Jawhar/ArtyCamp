/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.edu.artycamp.entities.Reclamation;
import tn.edu.artycamp.services.ServiceReclamationadmin;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXML1Controller implements Initializable {

     @FXML
    private TableView<Reclamation> tablereclamation;
    @FXML
    private TableColumn<Reclamation, Integer> columnidrec;
    @FXML
    private TableColumn<Reclamation, Date> Date;
    @FXML
    private TableColumn<Reclamation, String> msg;
    @FXML
    private TableColumn<Reclamation, String> object;
    @FXML
    private TableColumn<Reclamation, Integer> idU;
    @FXML
    private Button accepterrecla;
    @FXML
    private Button supprimerrecla;
    @FXML
    private Button afficherrecla;
    @FXML
    private Button retouracceuil;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickaccepterrecla(ActionEvent event) {
    }

    @FXML
    private void clicksupprimerrecla(ActionEvent event) {
    Reclamation u = (Reclamation) tablereclamation.getSelectionModel().getSelectedItem();
        ServiceReclamationadmin servi = new ServiceReclamationadmin();
        servi.supprimer(u.getId());
    
    }

    @FXML
    private void clickafficherrecla(ActionEvent event) {
      ServiceReclamationadmin ServiceReclamation =new ServiceReclamationadmin();
       
      ArrayList list = (ArrayList) ServiceReclamation.getAll();
      columnidrec.setCellValueFactory(new PropertyValueFactory<>("idreclamation"));
      Date.setCellValueFactory(new PropertyValueFactory<>("iduser"));
      msg.setCellValueFactory(new PropertyValueFactory<>("idcategory"));
      object.setCellValueFactory(new PropertyValueFactory<>("datereclamation"));
      idU.setCellValueFactory(new PropertyValueFactory<>("contenu"));
    
    }

    @FXML
    private void clickretour(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("../gui/FXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                stage.show(); 
        
    }
    
}
