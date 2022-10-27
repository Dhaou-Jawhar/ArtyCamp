/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Evmodl;
import Model.MyListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ben Nasr
 */
public class AcClientController implements Initializable {

    @FXML
    private VBox chosenEventCard;
    @FXML
    private Label nameEv;
    @FXML
    private ImageView iportrait;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Label description;

    private List<Evmodl> modls = new ArrayList<>();
    private Image image;
    private MyListener mylistener;
    @FXML
    private Button participer;
    @FXML
    private Button exEV;
    
    /********************************************************/
    private List<Evmodl> getData(){
    List<Evmodl> modls = new ArrayList<>();
     Evmodl md;
      
     md= new Evmodl();
      md.setName("Design");
      md.setDescrip("Création d'un Portrait");
      md.setImg("/SCSS/portrait.jpg");
      md.setColor("3c0e4a");
      modls.add(md);
     
      md= new Evmodl();
      md.setName("Space");
      md.setDescrip("");
      md.setImg("/SCSS/neoastro.jpg");
      md.setColor("3c0e4a");
      modls.add(md);
     
      md= new Evmodl();
      md.setName("NFT");
      md.setDescrip(" ");
      md.setImg("/SCSS/nft.jpg");
      md.setColor("3c0e4a");
      modls.add(md);
    
      md= new Evmodl();
      md.setName("Sea Pollution");
      md.setDescrip(" ");
      md.setImg("/SCSS/pollution.jpg");
      md.setColor("3c0e4a");
      modls.add(md);
     
      md= new Evmodl();
      md.setName("Save the Planet");
      md.setDescrip("");
      md.setImg("/SCSS/earth.jpg");
      md.setColor("3c0e4a");
      modls.add(md);
      
      md= new Evmodl();
      md.setName("Painting");
      md.setDescrip("");
      md.setImg("/SCSS/ac.jpg");
      md.setColor("3c0e4a");
      modls.add(md);
      
      md= new Evmodl();
      md.setName("Van Gogh");
      md.setDescrip("Céer une couverture d'un livre ");
      md.setImg("/SCSS/vangogh.jpg");
      md.setColor("3c0e4a");
      modls.add(md);
      
      md= new Evmodl();
      md.setName("FreeStyle");
      md.setDescrip(" ");
      md.setImg("/SCSS/freestyle.jpg");
      md.setColor("3c0e4a");
      modls.add(md);
      
       md= new Evmodl();
      md.setName("Book Cover");
      md.setDescrip("Céer une couverture d'un livre ");
      md.setImg("/SCSS/coverbook.jpg");
      md.setColor("3c0e4a");
      modls.add(md);
      
    return modls;
    }
    
    
    /********************************************************/
    private void setChosenEvent (Evmodl md){
       nameEv.setText(md.getName());
       description.setText(md.getDescrip());
       image = new Image(getClass().getResourceAsStream( md.getImg()));
       iportrait.setImage(image);
       chosenEventCard.setStyle("-fx-background-color: #" + md.getColor()+"; \n" + "-fx-background-radius: 30;");
    }
    
    
    /********************************************************/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modls.addAll(getData());
        if(modls.size()>0){
          setChosenEvent(modls.get(0));
          mylistener = new MyListener() {
             @Override
              public void onClickListener(Evmodl md){
                setChosenEvent(md);
              }
                      
                      
          };
        
        }
        int column =0;
        int row =1;
        try {
           for(int i=0; i<modls.size(); i++){
               FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/item.fxml")); 
           
                     AnchorPane anchorpane = loader.load();
                       ItemController item = loader.getController();
                       item.setData(modls.get(i),mylistener);
                       if (column==3) {
                           column=0;
                           row++;
                       
                       }
                       
                       grid.add(anchorpane,column++,row); //(child,column,row)
                       //set item grid width
                       grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                       grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                       grid.setMaxWidth(Region.USE_PREF_SIZE);
                       //set item grid height
                       grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                       grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                       grid.setMaxHeight(Region.USE_PREF_SIZE);
                        
                       
                       GridPane.setMargin(anchorpane, new Insets(10));             
            }
           
        } catch (IOException ex) {
                Logger.getLogger(AcClientController.class.getName()).log(Level.SEVERE, null, ex);
            }

            
           
        }
    /**************************************************/
    @FXML
     //Bouton t'hez interface where the artist gonna deploy his work fl event
    private void GoToArtclEv(ActionEvent event) {
    }
    /**************************************************/
    @FXML
    //Bouton trajaa lel page eli 9bal
    private void exitEVENT(ActionEvent event) {
    }
    /******************************************************************/
    
}    
    

