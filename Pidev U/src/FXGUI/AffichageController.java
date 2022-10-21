/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXGUI;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;
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
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javax.swing.UIManager.get;
import pidev.entities.User;
import pidev.services.ServiceUser;
import pidev.tools.DataSource;
import pidev.entities.User;
/**
 * FXML Controller class
 *
 * @author Islem
 */
public class AffichageController implements Initializable {
    @FXML
    private TableView<User> affichage;
    @FXML
    private TableColumn<User, String> nom;
    @FXML
    private TableColumn<User, String> prenom;
    @FXML
    private TableColumn<User, String> username;
    @FXML
    private TableColumn<User, String> role;
    @FXML
    private TableColumn<User, String> password;
    @FXML
    private Button delete;
    @FXML
    private TextField Nomedit;
    @FXML
    private TextField usernameedit;
    @FXML
    private TextField prenomedit;
    @FXML
    private TextField roleedit;
    @FXML
    private TextField passwordedit;
    @FXML
    private Button update;
    @FXML
    private Button search;
    
    
            
            
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom.setCellValueFactory(new PropertyValueFactory<User,String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<User,String>("prenom"));
        username.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
        role.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
        password.setCellValueFactory(new PropertyValueFactory<User,String>("pw"));
        
        ServiceUser su = new ServiceUser();
        
        List <User> list = su.getAllu();
        
        System.out.println(affichage);
        
       
        
        affichage.setItems(FXCollections.observableArrayList(list));
        // TODO
    }  
    @FXML
    void getSelected(MouseEvent event){
        int index = affichage.getSelectionModel().getSelectedIndex();
        if (index<=-1){
            return;
        }
         Nomedit.setText(nom.getCellData(index).toString());
         usernameedit.setText(prenom.getCellData(index).toString());
         prenomedit.setText(username.getCellData(index).toString());
        roleedit.setText(role.getCellData(index).toString());
         passwordedit.setText(password.getCellData(index).toString());
    } 

    @FXML
    private void delete(ActionEvent event) throws IOException {
        
         User u = affichage.getSelectionModel().getSelectedItem(); //System.out.println(ex);
         ServiceUser user   = new ServiceUser();
         user.supprimeru(u.getId());
         Parent root =FXMLLoader.load(getClass().getResource("/FXGUI/Affichage.fxml"));
         Scene SC=new Scene(root);
         Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
         window.setScene(SC);
         window.show();
    }

    @FXML
    private void modif(ActionEvent event) throws IOException{ 
            
         ServiceUser su = new ServiceUser ();
         su.modifieru(su,su.getId());
          Parent root =FXMLLoader.load(getClass().getResource("/FXGUI/Affichage.fxml"));
         Scene SC=new Scene(root);
         Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
         window.setScene(SC);
         window.show();
         
         }

   /* @FXML
    private void chercher(ActionEvent event) {
        ServiceUser su = new ServiceUser();
        List <User> list = su.getOneu(su.getOneu(su.getId()));
        
    }
        */
        
            
            
           
            
        
    
        
    }
    
    
    


