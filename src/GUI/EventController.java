/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;
import Services.EventService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class EventController implements Initializable {

    @FXML
    private TextField chnom;
    @FXML
    private TextArea chdesc;
    @FXML
    private Label warning;
    @FXML
    private DatePicker chdd1;
    @FXML
    private DatePicker chdf1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ajoutEv(ActionEvent event) throws IOException {
        if(chnom.getText().isEmpty() || chdesc.getText().isEmpty()|| chdd1.getValue().toString().isEmpty()|| chdf1.getValue().toString().isEmpty())
    {warning.setText("Remplissez tous les champs !!");
    }else{
         EventService s = new EventService();

                s.ajouter(new Event(chnom.getText(),chdesc.getText(),chdd1.getValue().toString(),chdf1.getValue().toString()));
                //JOptionPane.showMessageDialog(null,"Event ajouté avec succés");
                TrayNotification tray = new TrayNotification();
              AnimationType type = AnimationType.POPUP;
              tray.setAnimationType(type);
              tray.setTitle("Confirmation");
              tray.setMessage("Evenement ajouté avec succés");
              tray.setNotificationType(NotificationType.SUCCESS);
              tray.showAndDismiss(Duration.millis(3000));

            Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListEvent.fxml")) ;
            Scene rcScene= new Scene(root);
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
        }
        
    }

    @FXML
    private void Exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListEvent.fxml")) ;
            Scene rcScene= new Scene(root);
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
    }
    
    

}
