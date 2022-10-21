/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXGUI;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import pidev.entities.User;
import pidev.services.ServiceUser;
import pidev.tools.DataSource;

/**
 * FXML Controller class
 *
 * @author Islem
 */
public class FXMLUController implements Initializable {
    
    

    @FXML
    private Button sinscrire;
    @FXML
    private TextField inputNom;
    @FXML
    private TextField inputPrenom;
    @FXML
    private TextField inputPassword;
    @FXML
    private ComboBox inputRole;
    @FXML
    private TextField inputUserName;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("Artiste","Visiteur","Moderateur");
        inputRole.setItems(list);
        
    }    

    @FXML
    private void ajout(ActionEvent event) {
        //String id = inputId.getText();
        String nom = inputNom.getText();
        String prenom = inputPrenom.getText();
        String password = inputPassword.getText();
        String role = inputRole.getSelectionModel().getSelectedItem().toString();
        String userName = inputUserName.getText();
        
        
        
        Connection cnx =DataSource.getInstance().getConnection();
      
       User u=new User (nom,prenom,userName,role, password);
         ServiceUser su = new ServiceUser ();
         su.ajouteru(u);
    }

    @FXML
    private void onTextChange(InputMethodEvent event) {
    }

   
    
}
