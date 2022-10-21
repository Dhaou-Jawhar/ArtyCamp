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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ben Nasr
 */
public class ListSponsorController implements Initializable {

    @FXML
    private TableView<Sponsor> Tsponsor;
    @FXML
    private TableColumn<Sponsor, Integer> ctel;
    @FXML
    private TableColumn<Sponsor, Integer> cmont;
    @FXML
    private TableColumn<Sponsor, String> cnom;
    @FXML
    private TableColumn<Sponsor, String> cmail;
    @FXML
    private Button aj;
    @FXML
    private Button mod;
    @FXML
    private Button sup;
    @FXML
    private Button ex;
    @FXML
    private Label warning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SponsorService es = new SponsorService();
        
        ctel.setCellValueFactory(new PropertyValueFactory<Sponsor, Integer>("phone_societe"));
        cmont.setCellValueFactory(new PropertyValueFactory<Sponsor, Integer>("montant"));
        cnom.setCellValueFactory(new PropertyValueFactory<Sponsor, String>("nom_societe"));
        cmail.setCellValueFactory(new PropertyValueFactory<Sponsor, String>("email_societe"));
        
        
        ObservableList<Sponsor> list = es.getAll();
        
        Tsponsor.setItems(list);
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjSponsor.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
        }catch(Exception ex) {
	
	}   
    }

    @FXML
    private void modifier(ActionEvent event) {
        try {
        
        Sponsor S = Tsponsor.getSelectionModel().getSelectedItem();
        //change scene 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/ModSponsor.fxml"));
        Parent root =loader.load();
        //constructeur interface modifier
       ModSponsorController dpc = loader.getController();
         //B3atht el objet selectionné
        dpc.init(S);
        
    	//Arja3 lel main eli heya liste
        Scene rcScene= new Scene(root);
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
        }catch(Exception ex) {
	 warning.setText("Selectionnez un Sponsor");
	}
    }

    @FXML
    private void supp(ActionEvent event) {
        try {
            Sponsor E = Tsponsor.getSelectionModel().getSelectedItem();
            SponsorService es = new SponsorService();
            
            es.supprimer(new Sponsor(E.getId_sponsor()));
            JOptionPane.showMessageDialog(null,"Êtes-vous sûr de vouloir supprimer?");

            Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListSponsor.fxml")) ;
            Scene rcScene= new Scene(root);
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
            JOptionPane.showMessageDialog(null,"Sponsor supprimé avec succés");
            
        }catch(Exception ex) {
         warning.setText("Selectionnez un Sponsor");
        }  
    }

    @FXML
    private void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListEvent.fxml")) ;
            Scene rcScene= new Scene(root);
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
        
    }
    
}
