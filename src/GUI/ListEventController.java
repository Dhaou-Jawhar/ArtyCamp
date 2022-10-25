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
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ben Nasr
 */
public class ListEventController implements Initializable {

    @FXML
    private TableView<Event> TEvent;
    @FXML
    private TableColumn<Event, String> cnom;
    @FXML
    private Label warning;
    @FXML
    private TableColumn<Event, String> cdd;
    @FXML
    private TableColumn<Event, String> cff;
    @FXML
    private TableColumn<Event, String> cdesc;
    
    @FXML
    private Button goacc;
    @FXML
    private TextField rechev;
    @FXML
    private Label empty;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EventService es = new EventService();
        
        cnom.setCellValueFactory(new PropertyValueFactory<Event, String>("nomEv"));
        cdesc.setCellValueFactory(new PropertyValueFactory<Event, String>("description"));
        cdd.setCellValueFactory(new PropertyValueFactory<Event, String>("dateDeb"));
        cff.setCellValueFactory(new PropertyValueFactory<Event, String>("dateFin"));
        setLblsomme(Integer.toString(es.Total()));
        
        
        
        ObservableList<Event> list = es.getAll();
        
        TEvent.setItems(list);
        
        
        FilteredList<Event> filteredData = new FilteredList<>(list, b -> true);
        rechev.textProperty().addListener((observable, oldValue, newValue) -> {
          filteredData.setPredicate(cp-> {
              if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
              String lowerCaseFilter = newValue.toLowerCase();
              if (cp.getNomEv().toLowerCase().contains(lowerCaseFilter) ) {
                    return true; // Filter matches first name.
                    
                } else if (cp.getDateDeb().toLowerCase().contains(lowerCaseFilter) ){
                    return true; // Filter matches date deb.
                } else if (cp.getDateFin().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                    } else if (cp.getDescription().toLowerCase().contains(lowerCaseFilter) ){
                             return true;
                    }
                return false;
       });
    });
        SortedList<Event> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(TEvent.comparatorProperty());
        TEvent.setItems(sortedData);
    }    

    @FXML
    private void Modifier(ActionEvent event) {
        try {
         //selectionner
        Event S = TEvent.getSelectionModel().getSelectedItem();
        //change scene 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/modEvent.fxml"));
        Parent root =loader.load();
        //constructeur interface modifier
       ModEventController dpc = loader.getController();
         //B3atht el objet selectionné
        dpc.init(S);
        
    	//Arja3 lel main eli heya liste
        Scene rcScene= new Scene(root);
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
        }catch(Exception ex) {
	 warning.setText("Selectionnez un Evenement");
	}
    }

    @FXML
    private void Delete(ActionEvent event) {
        try {
            Event E = TEvent.getSelectionModel().getSelectedItem();
            EventService es = new EventService();
            
            es.supprimer(new Event(E.getId()));
            JOptionPane.showMessageDialog(null,"Êtes-vous sûr de vouloir supprimer?");

            Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListEvent.fxml")) ;
            Scene rcScene= new Scene(root);
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
            JOptionPane.showMessageDialog(null,"Evenement supprimé avec succés");
            
        }catch(Exception ex) {
         warning.setText("Selectionnez un Evenement");
        }  
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Event.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
        }catch(Exception ex) {
	
	}   
    }

    @FXML
    private void Goback(ActionEvent event) throws IOException {
        goacc.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Acceuil.fxml")) ;
        Scene rcScene= new Scene(root);
        Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
    
    public void setLblsomme(String empty){
      this.empty.setText(empty);
    }

}
