package splashscreenproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainController implements Initializable {
    
      @FXML
    private void handleButtonAction(ActionEvent event) {
          try {
              //System.out.println("You clicked me!");
              Parent root = FXMLLoader.load(getClass().getResource("..\\Arty.Gui\\ArticleView.fxml"));
              Scene scene = new Scene(root);
              Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
              
          } catch (IOException ex) {
              System.err.println(ex.getMessage());
          }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
    }     
}
