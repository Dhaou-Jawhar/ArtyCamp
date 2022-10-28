/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.artycamp.entities.Messagerie;
import tn.edu.artycamp.entities.Reclamation;
import tn.edu.artycamp.entities.User;
import tn.edu.artycamp.services.ServiceMessagerie;
import tn.edu.artycamp.tools.SendMail;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MessagerieController implements Initializable {
    @FXML
    private TableView<Messagerie> tablemessage;
    @FXML
    private TableColumn<Messagerie, String> idmsg;
    @FXML
    private TableColumn<Messagerie, Boolean> idvu;
    @FXML
    private TableColumn<Messagerie,Integer> idU;
    @FXML
    private TableColumn<Messagerie, Integer> idexp;
    @FXML
    private TableColumn<Messagerie,Integer> idrec;
    @FXML
    private Button ajoutermsg;
    @FXML
    private Button supprimermsg;
    @FXML
    private Button actualisermsg;
    @FXML
    private TextField expediteurmsg;
    @FXML
    private TextField recepteurmsg;
    @FXML
    private TextArea contenumsg;
    @FXML
    private Button retourmsg;
    @FXML
    private Text t_error;
     ServiceMessagerie Servicemsg =new ServiceMessagerie();
     Messagerie msghan= new Messagerie();
    @FXML
    private Button suivanthanen;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        viewmessagerie();
    }    
    public void viewmessagerie(){
    ServiceMessagerie Servicemsg =new ServiceMessagerie();
    ArrayList list = (ArrayList) Servicemsg.getAll();
        idmsg.setCellValueFactory(new PropertyValueFactory<>("msg"));
        idvu.setCellValueFactory(new PropertyValueFactory<>("vu"));
        idexp.setCellValueFactory(new PropertyValueFactory<>("Nomex"));
        idrec.setCellValueFactory(new PropertyValueFactory<>("Nomrec"));
}

    @FXML
    private void clickajoutmsg(ActionEvent event) throws Exception {
     if(!expediteurmsg.getText().equals("") && !recepteurmsg.getText().equals("") && !contenumsg.getText().equals(""))
        {  
          //   int idex1 = Integer.parseInt(expediteurmsg.getText());
           // msghan.setIdex(idex1);
            msghan.setNomex(expediteurmsg.getText());
            msghan.setNomrec(recepteurmsg.getText());
            msghan.setMsg(contenumsg.getText());
           try { 
               Servicemsg.ajouter(msghan);
               SendMail.sendMail("hanen.hammouda@esprit.tn",(contenumsg.getText()));
            }catch(SQLException ex){System.out.println(ex.getMessage());}
           }
             else 
        {
            t_error.setText("Please verify all fields !");
        }
    }

    @FXML
    private void clicksupmsg(ActionEvent event) {
         Messagerie u = tablemessage.getSelectionModel().getSelectedItem();
        ServiceMessagerie servi = new ServiceMessagerie();
        servi.supprimer(u.getIdmsg());
        viewmessagerie();
    }

    @FXML
    private void clickactumsg(ActionEvent event) {
        ServiceMessagerie sermsg =new ServiceMessagerie();
        ArrayList list = (ArrayList) sermsg.getAll();
        ObservableList observablelist = FXCollections.observableArrayList(list);
        tablemessage.setItems(observablelist);
        idmsg.setCellValueFactory(new PropertyValueFactory<>("msg"));
        idvu.setCellValueFactory(new PropertyValueFactory<>("vu"));
        idexp.setCellValueFactory(new PropertyValueFactory<>("Nomex"));
        idrec.setCellValueFactory(new PropertyValueFactory<>("Nomrec"));
        t_error.setText("");
         expediteurmsg.setText("");
        recepteurmsg.setText("");
        contenumsg.setText("");
    }

    @FXML
    private void clickretourmsg(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageReclamation.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void clicksuihane(ActionEvent event) {
    }
    
}
