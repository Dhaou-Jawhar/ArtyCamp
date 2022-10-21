/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AjouterCategorieController implements Initializable {

    @FXML
    private TextField t_Nom;
    @FXML
    private TextField t_logo;
    @FXML
    private AnchorPane tc_table;
    @FXML
    private TextField txtSearchC;
    @FXML  
    private TableColumn<?, ?> t_IdA;
    @FXML
    private TableColumn<?, ?> t_NomC;
    @FXML
    private TableColumn<?, ?> t_LogoC;
/*   @FXML
    private TableColumn<Categorie, String> c_nom;
    @FXML
    private TextField t_nom;
    @FXML
    private TableView<Categorie> tc_table;
    @FXML
    private TableColumn<Categorie, Integer> c_id;
    @FXML
    private TableColumn<Categorie, Integer> c_action;
    @FXML
    private Text t_error;
    @FXML
    private TextField t_search;

    ServiceCategorie sh = new ServiceCategorie();

    Categorie h = new Categorie();
        ObservableList<Categorie> myTransport = FXCollections.observableArrayList();
   
    Stage stage;
    Scene scene;*/
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnClickAdd(ActionEvent event) {
    }

    @FXML
    private void OnClickReset(ActionEvent event) {
    }
    
}
