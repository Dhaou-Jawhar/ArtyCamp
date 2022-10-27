/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Sponsor;
import Services.SponsorService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Ben Nasr
 */
public class AjSponsorController implements Initializable {

    @FXML
    private Label warning;
    @FXML
    private TextField chnom;
    @FXML
    private TextField chemail;
    @FXML
    private TextField chmont;
    @FXML
    private TextField chtel;
    @FXML
    private TextArea chdesc;
    @FXML
    private DatePicker chdd1;
    @FXML
    private DatePicker chdf1;
    @FXML
    private Label warning1;
    @FXML
    private Label warning2;
    @FXML
    private Label warning3;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     
    /********************************************************/
    @FXML
    private void Exit(ActionEvent event) throws IOException {
         
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListSponsor.fxml")) ;
            Scene rcScene= new Scene(root);
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
    }
    
    /********************************************************/
    public boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        //^ : it starts with
        //+ : at least one
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +"[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (pattern.matcher(email).matches()) {
            return true;
        } 
        return false;
    }
    /********************************************************/
    
    
    
    
    

    /********************************************************/
    @FXML
    private void ajoutSp(ActionEvent event) throws IOException {
    {
            try {
            System.out.println(Integer.parseInt(chmont.getText()));
            try {
            System.out.println(Integer.parseInt(chtel.getText()));
            SponsorService s = new SponsorService();
            
            //controle de saisie
            
            boolean isValid = validateEmail(chemail.getText());
            if(!isValid)
            {
            warning2.setText("Email non valide");
            }else {
            s.ajouter(new Sponsor(Integer.parseInt(chtel.getText()),Integer.parseInt(chmont.getText()),chnom.getText(),chemail.getText()));
            TrayNotification tray = new TrayNotification();
              AnimationType type = AnimationType.POPUP;
              tray.setAnimationType(type);
              tray.setTitle("Confirmation");
              tray.setMessage("Sponsor ajouté avec succés");
              tray.setNotificationType(NotificationType.SUCCESS);
              tray.showAndDismiss(Duration.millis(3000));

            Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListSponsor.fxml")) ;
            Scene rcScene= new Scene(root);
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
            }
            }catch(Exception e){
                 warning3.setText("Num° Tél doit etre de type entier");
                }
            }catch(Exception e){
         warning.setText("Montant doit etre de type entier");
            }
    }
  }    
}
    
    
 
    

