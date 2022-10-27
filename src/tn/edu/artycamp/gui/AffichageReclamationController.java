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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.artycamp.entities.Reclamation;
import tn.edu.artycamp.services.ServiceReclamationadmin;
import tn.edu.artycamp.tools.SendMail;

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
    @FXML
    private Text t_error;
    @FXML
    private Button idAjouter;
    @FXML
    private Button suivantrecla;
    //private DatePicker idagenda;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewreclamation();
    }    
public void viewreclamation(){
    ServiceReclamationadmin ServiceReclamation =new ServiceReclamationadmin();
   ArrayList list = (ArrayList) ServiceReclamation.getAll ();
    ObservableList observablelist = FXCollections.observableArrayList(list);
    TableafficheRec.setItems(observablelist);
    id_Date. setCellValueFactory(new PropertyValueFactory<>("date"));
    id_Msg. setCellValueFactory(new PropertyValueFactory<>("msg"));
    id_Object. setCellValueFactory(new PropertyValueFactory<>("object"));
    id_IdU. setCellValueFactory(new PropertyValueFactory<>("idU"));
}
    @FXML
    private void cliksuprimerrecla(ActionEvent event) {
     Reclamation u = TableafficheRec.getSelectionModel().getSelectedItem();
        ServiceReclamationadmin servi = new ServiceReclamationadmin();
        servi.supprimer(u.getIdU());
        viewreclamation();
    }

    @FXML
    private void clikenregistrerrecla(ActionEvent event) {
     ServiceReclamationadmin sr = new ServiceReclamationadmin();
    int iduserec = Integer.parseInt(iduserreclamation.getText());
    Reclamation rec = new Reclamation(38,textidreclamation.getText(),textcontenureclamation.getText(),iduserec); 
    try{  
      sr.modifier(rec);
    }catch(SQLException ex)
    {System.out.println(ex.getMessage());
    }
   viewreclamation();
    }

    @FXML
    private void clickmodifierrecla(ActionEvent event) {
    Reclamation r = (Reclamation) TableafficheRec.getSelectionModel().getSelectedItem();
    textidreclamation.setText(r.getMsg());
    textcontenureclamation.setText(r.getObject());
    String iduserrec=Integer.toString(r.getIdU());
    iduserreclamation.setText(iduserrec);
    }

    @FXML
    private void clikretourreclamation(ActionEvent event) throws IOException {
    
    /*Parent root = FXMLLoader.load(getClass().getResource("../gui/Messagerie.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                stage.show();*/}

    @FXML
    private void actualiserclik(ActionEvent event)throws SQLException{
        ServiceReclamationadmin ServiceReclamation =new ServiceReclamationadmin();
        ArrayList list = (ArrayList) ServiceReclamation.getAll();
        ObservableList observablelist = FXCollections.observableArrayList(list);
        TableafficheRec.setItems(observablelist);
        id_Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        id_Msg.setCellValueFactory(new PropertyValueFactory<>("msg"));
        id_Object.setCellValueFactory(new PropertyValueFactory<>("object"));
        id_IdU.setCellValueFactory(new PropertyValueFactory<>("idU"));
         textidreclamation.setText("");
        iduserreclamation.setText("");
        textcontenureclamation.setText("");
         t_error.setText("");
}

    @FXML
    private void clickajouter(ActionEvent event) throws SQLException, Exception {
        ServiceReclamationadmin sh = new ServiceReclamationadmin();
        
         LocalDate start = LocalDate.now();
         System.out.println(start);
         if(!textidreclamation.getText().equals("") && !iduserreclamation.getText().equals("") && !textcontenureclamation.getText().equals("") )
        { Reclamation h = new Reclamation(0,textcontenureclamation.getText(),textidreclamation.getText(),Integer.parseInt(iduserreclamation.getText()));
            try{sh.ajouter(h);
            SendMail.sendMail("hanen.hammouda@esprit.tn","reclamation envoyer");
            }catch(SQLException ex){System.out.println(ex.getMessage());}
        }
         else 
        {
            t_error.setText("Please verify all fields !");
        }
    }

    @FXML
    private void clicksuirecla(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/Messagerie.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                stage.show();
    }
 
    
}
