/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pidev.entities.User;
import pidev.services.ServiceUser;
/**
 * FXML Controller class
 *
 * @author Islem
 */
public class LoginController implements Initializable {

    @FXML
    private TextField Username;
    @FXML
    private TextField Pwd;
    @FXML
    private Button Log;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onLogin(ActionEvent event) {
          String userNameVal = Username.getText();
          String password = Pwd.getText();
          
          ServiceUser service = new ServiceUser();
          
          User connected = service.login(userNameVal,password);
          
          if(connected == null){
              System.out.println("error");
          }else{
              System.out.println(connected);              
          }
    }
    
}
