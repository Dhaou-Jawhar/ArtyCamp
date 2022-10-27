/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ben Nasr
 */
public class AcceuilController implements Initializable {

    @FXML
    private Button gte;
    @FXML
    private Button gts;
    @FXML
    private Button bt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /********************************************************/
    @FXML
    private void gotoevent(ActionEvent event) throws IOException {
        gte.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListEvent.fxml")) ;
        Scene rcScene= new Scene(root);
        Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    /********************************************************/
    @FXML
    private void gotosponsor(ActionEvent event) throws IOException  {
        
        gts.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListSponsor.fxml")) ;
        Scene rcScene= new Scene(root);
        Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    @FXML
    private void backto(ActionEvent event) {
    }
    
}
