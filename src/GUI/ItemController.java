/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Evmodl;
import Model.MyListener;
//import java.awt.event.MouseEvent;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Ben Nasr
 */
public class ItemController implements Initializable {

    @FXML
    private Label esmlabel;
    @FXML
    private ImageView inft;
    @FXML
    private void click(MouseEvent mouseEvent){
        mylistener.onClickListener(evmodl);
    
    }
    
    private Evmodl evmodl;
    private MyListener mylistener;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    void setData(Evmodl evmodl, MyListener mylistener) {
        this.evmodl=evmodl;
        this.mylistener=mylistener;
        esmlabel.setText(evmodl.getName());
        Image image = new Image(getClass().getResourceAsStream(evmodl.getImg()));
        inft.setImage(image);
        
    }
    
}
