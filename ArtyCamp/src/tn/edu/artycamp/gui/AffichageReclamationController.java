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
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.edu.artycamp.entities.Reclamation;
import tn.edu.artycamp.services.ServiceReclamationadmin;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AffichageReclamationController implements Initializable {
    @FXML
    private TableView<Reclamation> TableafficheRec;
    @FXML
    private TableColumn<Reclamation, Date> id_Date;
    @FXML
    private TableColumn<Reclamation, String> id_Msg;
    @FXML
    private TableColumn<Reclamation, String> id_Object;
    @FXML
    private TableColumn<Reclamation, Integer> id_IdU;
    @FXML
    private TextField textidreclamation;
    @FXML
    private TextField iduserreclamation;
    @FXML
    private Button suprimerreclam;
    @FXML
    private Button enregistrerreclam;
    @FXML
    private TextArea textcontenureclamation;
    @FXML
    private Button modifierrecla;
    @FXML
    private Button retourajoutereclam;
    @FXML
    private Button actualiser;
    @FXML
    private Button resetid;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewreclamation();
    }    
public void viewreclamation(){
    ServiceReclamationadmin ServiceReclamation =new ServiceReclamationadmin();
    //ArrayList list = (ArrayList) ServiceReclamation.rechercheReclamationParUser(17);
    ArrayList list = (ArrayList) ServiceReclamation.getAll();
    id_Date. setCellValueFactory(new PropertyValueFactory<>("date"));
    id_Msg. setCellValueFactory(new PropertyValueFactory<>("msg"));
    id_Object. setCellValueFactory(new PropertyValueFactory<>("object"));
    id_IdU. setCellValueFactory(new PropertyValueFactory<>("idU"));
}
    @FXML
    private void cliksuprimerrecla(ActionEvent event) {
     Reclamation u = TableafficheRec.getSelectionModel().getSelectedItem();
        Reclamation c=TableafficheRec.getSelectionModel().getSelectedItem();
        ServiceReclamationadmin servi = new ServiceReclamationadmin();
        servi.supprimer(u.getId());
        viewreclamation();
    }

    @FXML
    private void clikenregistrerrecla(ActionEvent event) {
     ServiceReclamationadmin sr = new ServiceReclamationadmin();
      int idrec = Integer.parseInt(textidreclamation.getText());
    int iduserec = Integer.parseInt(iduserreclamation.getText());
        Reclamation rec = new Reclamation(idrec,iduserec,textcontenureclamation.getText()); 
        sr.modifier(rec);
   viewreclamation();
    }

    @FXML
    private void clickmodifierrecla(ActionEvent event) {
   Reclamation r = (Reclamation) TableafficheRec.getSelectionModel().getSelectedItem();
    String idrec=Integer.toString(r.getId());
    textidreclamation.setText(idrec);
    String iduserrec=Integer.toString(r.getIdU());
    iduserreclamation.setText(iduserrec);
    textcontenureclamation.setText(r.getObject());
    }

    @FXML
    private void clikretourreclamation(ActionEvent event) throws IOException {
    
    Parent root = FXMLLoader.load(getClass().getResource("../gui/FXML1.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                stage.show();}

    @FXML
    private void actualiserclik(ActionEvent event) {
        ServiceReclamationadmin ServiceReclamation =new ServiceReclamationadmin();
    //ArrayList list = (ArrayList) ServiceReclamation.rechercheReclamationParUser(17);
     ArrayList list = (ArrayList) ServiceReclamation.getAll();
    ObservableList observablelist = FXCollections.observableArrayList(list);
   
    TableafficheRec.setItems(observablelist);
    id_Date. setCellValueFactory(new PropertyValueFactory<>("date"));
    id_Msg. setCellValueFactory(new PropertyValueFactory<>("msg"));
    id_Object. setCellValueFactory(new PropertyValueFactory<>("object"));
    id_IdU. setCellValueFactory(new PropertyValueFactory<>("idU"));
    }

    @FXML
    private void clickannuler(ActionEvent event) {
        textidreclamation.setText("");
        iduserreclamation.setText("");
        textcontenureclamation.setText("");
        //dp_endDate.setValue(null);
    }
    
    
}
