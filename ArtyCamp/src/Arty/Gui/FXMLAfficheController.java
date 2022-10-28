/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Arty.Gui;

import Arty.entities.ArtVIP;
import Arty.services.GestionArtVIP;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Dhaou Jawher
 */
public class FXMLAfficheController implements Initializable {

    @FXML
    private TableView<ArtVIP> Affichetable;
    @FXML
    private TableColumn<ArtVIP, Integer> idartCol;
    @FXML
    private TableColumn<ArtVIP, String> nomCol;
    @FXML
    private TableColumn<ArtVIP, String> descCol;
    @FXML
    private TableColumn<ArtVIP, String> refCol;
    @FXML
    private TableColumn<ArtVIP, Integer> idcatCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        public void viewreclamation() {
        GestionArtVIP GestionArtVIP =new GestionArtVIP();
    
            try {
            ArrayList list = (ArrayList) GestionArtVIP.GetAll();
            ObservableList observablelist = FXCollections.observableArrayList(list);
            Affichetable.setItems(observablelist);
            idartCol.setCellValueFactory(new PropertyValueFactory<>("artID"));
            nomCol.setCellValueFactory(new PropertyValueFactory<>("art_nom"));
            descCol.setCellValueFactory(new PropertyValueFactory<>("art_description"));
            refCol.setCellValueFactory(new PropertyValueFactory<>("reference"));
            idcatCol.setCellValueFactory(new PropertyValueFactory<>("idCategory"));
            } catch (SQLException ex) {
            Logger.getLogger(FXMLAfficheController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
