/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Arty.Gui;

import Arty.entities.ArtCategory;
import Arty.entities.ArtVIP;
import Arty.services.GestionArtVIP;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dhaou Jawher
 */
public class ArticleViewController implements Initializable {

    @FXML
    private TableView<ArtVIP> TableArt;
    @FXML
    private TableColumn<ArtVIP, String> namecol;
    @FXML
    private TableColumn<ArtVIP, String> refcol;
    @FXML
    private TableColumn<ArtVIP, String> desccol;
    @FXML
    private TableColumn<ArtVIP, String> categcol;
    @FXML
    private TableColumn<ArtVIP, Integer> idcatcol;
    @FXML
    private ComboBox<String> Categorie;
    
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtref;
    @FXML
    private TextField txtdesc;
    @FXML
    private Button butajout;
    @FXML
    private Button annuler;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private ImageView exit;
    @FXML
    private Button actualiser;
    
    ArtVIP r = new ArtVIP();
    GestionArtVIP gest = new GestionArtVIP();
    @FXML
    private Text t_error;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> l1 = FXCollections.observableArrayList("3D","NFT");
        Categorie.setItems(l1);
        observe();
    }

        @FXML
    private void clickannuler(ActionEvent event) {
        txtnom.setText("");
        txtref.setText("");
        txtdesc.setText("");
        Categorie.getSelectionModel().clearSelection();
    }
    
    @FXML
    private void clickajout(ActionEvent event) {
            if(!txtnom.getText().equals("") && txtref.getText().equals("") && txtdesc.getText().equals(""))
                /*&& Categorie.getSelectionModel().getSelectedItem() != null*/
        {
            r.setArt_nom(txtnom.getText());
            r.setReference(txtref.getText());
            r.setArt_description(txtdesc.getText());
            gest.ajouter(r);
           System.out.println("Article , Your Article has been approved!");
           
            } else 
        {
            t_error.setText("Please verify all fields !");
        }
    }

    @FXML
    private void clicksupprimer(ActionEvent event) {
        
        ArtVIP u = TableArt.getSelectionModel().getSelectedItem();
        GestionArtVIP servi = new GestionArtVIP();
        servi.supprimer(u.getArtID());
    }

    @FXML
    private void clickmodifier(ActionEvent event) {
   ArtVIP r = (ArtVIP) TableArt.getSelectionModel().getSelectedItem();
    txtnom.setText(r.getArt_nom());
    txtref.setText(r.getReference());
   txtdesc.setText(r.getArt_description());
    }

    @FXML
    private void clickexit(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ArticleView.fxml"));    
        Scene scene = new Scene(root);

        Stage stage = new Stage();            
        stage.setScene(scene);
        stage.close();
    }

    @FXML
    private void clickactualiser(ActionEvent event) {
        GestionArtVIP GestionArtVIP =new GestionArtVIP();
    
            try {
            ArrayList list = (ArrayList) GestionArtVIP.GetAll();
            ObservableList observablelist = FXCollections.observableArrayList(list);
            TableArt.setItems(observablelist);
            namecol.setCellValueFactory(new PropertyValueFactory<>("art_nom"));
            refcol.setCellValueFactory(new PropertyValueFactory<>("reference"));
            desccol.setCellValueFactory(new PropertyValueFactory<>("art_description"));
            categcol.setCellValueFactory(new PropertyValueFactory<>("Category"));
            idcatcol.setCellValueFactory(new PropertyValueFactory<>("idCategory"));
            } catch (SQLException ex) {
            Logger.getLogger(FXMLAfficheController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        private void observe() {
        GestionArtVIP GestionArtVIP =new GestionArtVIP();
    
            try {
            ArrayList list = (ArrayList) GestionArtVIP.GetAll();
            ObservableList observablelist = FXCollections.observableArrayList(list);
            TableArt.setItems(observablelist);
            namecol.setCellValueFactory(new PropertyValueFactory<>("art_nom"));
            refcol.setCellValueFactory(new PropertyValueFactory<>("reference"));
            desccol.setCellValueFactory(new PropertyValueFactory<>("art_description"));
            categcol.setCellValueFactory(new PropertyValueFactory<>("Category"));
            idcatcol.setCellValueFactory(new PropertyValueFactory<>("idCategory"));
            } catch (SQLException ex) {
            Logger.getLogger(FXMLAfficheController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
