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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ben Nasr
 */
public class ModSponsorController implements Initializable {

    @FXML
    private TextField chnom;
    @FXML
    private TextField chemail;
    @FXML
    private TextField chtel;
    @FXML
    private TextField chmont;
    private int ID;
    @FXML
    private Label warning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    void init(Sponsor S) {
        ID = S.getId_sponsor();
        chtel.setText(Integer.toString(S.getPhone_societe()));
        chmont.setText(Integer.toString(S.getMontant()));
        chnom.setText(S.getNom_societe());
        chemail.setText(S.getEmail_societe());
    }

    @FXML
    private void modifier(ActionEvent event) {
             try {
            System.out.println(Integer.parseInt(chmont.getText()));
            try {
            System.out.println(Integer.parseInt(chtel.getText()));
            SponsorService s = new SponsorService();
            s.modifier(new Sponsor(ID,Integer.parseInt(chtel.getText()),Integer.parseInt(chmont.getText()),chnom.getText(),chemail.getText()));
            JOptionPane.showMessageDialog(null,"Sponsor modifié avec succés");
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListSponsor.fxml")) ;
            Scene rcScene= new Scene(root);
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
            }catch(Exception e){
                 warning.setText("Doit etre de type entier");
                }
            }catch(Exception e){
         warning.setText("Doit etre de type entier");
            }
    }

    @FXML
    private void exit(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListSponsor.fxml")) ;
            Scene rcScene= new Scene(root);
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
    }  
    
}