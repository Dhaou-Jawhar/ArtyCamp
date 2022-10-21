/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import tn.edu.artycamp.Services.ServiceArticleArtiste;
import tn.edu.artycamp.entities.ArticleArtiste;
import tn.edu.artycamp.entities.CategorieArticles;
import tn.edu.artycamp.services.ServiceCategorieArticles;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AjouterArticleController implements Initializable {

    @FXML
    private ComboBox<CategorieArticles> cb_category;
    @FXML
    private TableView<ArticleArtiste> ta_table;
    @FXML
    private TableColumn<ArticleArtiste, String> col_NomArticle;
    @FXML
    private TableColumn<ArticleArtiste, Integer> col_categorie;
    @FXML
    private TableColumn<ArticleArtiste, String> col_Description;
    @FXML
    private TableColumn<ArticleArtiste, Integer> col_views;
    @FXML
    private TableColumn<ArticleArtiste, String> col_image;
    @FXML
    private TableColumn<ArticleArtiste, Integer> col_Action;

    @FXML
    private TextField txtNomArticle;
    @FXML
    private TextArea txtDescription;
    @FXML
    private TextField txtSearch;
    @FXML
    private TextField txt_image;
    @FXML
    private Text t_erreur;
    @FXML
    private Text t_success;

    ObservableList<ArticleArtiste> myTransport = FXCollections.observableArrayList();

    ServiceArticleArtiste sh = new ServiceArticleArtiste();
    ServiceCategorieArticles sc = new ServiceCategorieArticles();

    ArticleArtiste h = new ArticleArtiste();
    //Stage stage;
    //Scene scene;

    /*   @FXML
    private TableView<Forum> tc_table;
    @FXML
    private TableColumn<Forum, Integer> c_id;
    @FXML
    private TableColumn<Forum, String> c_image;

    @FXML
    private TextField t_search;
    @FXML
    private Text t_image;

    ObservableList<Forum> myTransport = FXCollections.observableArrayList();
   
    ServiceForum sh = new ServiceForum();
    ServiceCategorie sc = new ServiceCategorie();

    Forum h = new Forum();
    @FXML
    private Text t_error;
   
    Stage stage;
    Scene scene;
    @FXML
    private TableColumn<Forum, String> c_content;
    @FXML
    private TableColumn<Forum, Integer> c_idCategorie;
    @FXML
    private TableColumn<Forum, Integer> c_views;
    @FXML
    private TableColumn<Forum, Integer> c_jaime;
    @FXML
    private TableColumn<Forum, Integer> c_jaimepas;
    @FXML
    private TextArea t_content;
    @FXML
    private ComboBox<Categorie> cb_category;
    @FXML
    private TableColumn<Forum, Integer> c_action;
     */
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();

    }

    private void loadData() {
        ta_table.getItems().clear();
        ObservableList<ArticleArtiste> myTransport = FXCollections.observableArrayList();
        col_Action.setCellFactory(param -> {
            //Set up the ImageView
            Button btn = new Button("supprimer");
            //Set up the Table
            TableCell<ArticleArtiste, Integer> cell = new TableCell<ArticleArtiste, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                    if (!empty && item != null) {
                        btn.setOnAction((event)
                                -> {
                            try {
                                sh.supprimer(item);
                                // update table
                                myTransport.setAll(sh.AfficherArticles());
                                ta_table.setItems(myTransport);
                                t_success.setText("Article Sucessfully Deleted! !");

                            } catch (Exception ex) {
                                System.err.println(ex);
                            }

                        });
                    }
                }

            };
            // Attach the imageview to the cell
            cell.setGraphic(btn);
            return cell;

        });
        //c_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_Description.setCellValueFactory(new PropertyValueFactory<>("discriptionA"));
        col_categorie.setCellValueFactory(new PropertyValueFactory<>("idCategorie"));
        col_NomArticle.setCellValueFactory(new PropertyValueFactory<>("nomA"));
        col_image.setCellValueFactory(new PropertyValueFactory<>("imageh"));
        col_views.setCellValueFactory(new PropertyValueFactory<>("views"));
        
        
        
         col_Action.setCellValueFactory(new PropertyValueFactory<>("idArticle"));
        
        cb_category.getItems().setAll(sc.AfficherCategorie());
        
        myTransport.setAll(sh.AfficherArticles());
        ta_table.getItems().setAll(myTransport);
    }

    /*  private void loadData()
    {
         tc_table.getItems().clear();  
        
        ObservableList<Forum> myTransport = FXCollections.observableArrayList();
        c_action.setCellFactory(param -> {
            //Set up the ImageView
            Button btn = new Button("supprimer");
            //Set up the Table
             TableCell<Forum, Integer> cell = new TableCell<Forum, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                    if(!empty && item != null) {
                        btn.setOnAction((event)
                                -> {
                            try {
                            sh.supprimer(item);
                            // update table
                             myTransport.setAll(sh.getAll());
                             tc_table.setItems(myTransport);
                             AlertMaker.sendNotificationApi("Forum Deleted!", "Forum Sucessfully Deleted!");
                            } catch(Exception ex)
                            {
                                System.err.println(ex);
                            }
                           
                        });
                    }
                }

            };
            // Attach the imageview to the cell
            cell.setGraphic(btn);
            return cell;

        });
        c_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        c_content.setCellValueFactory(new PropertyValueFactory<>("content"));
        c_idCategorie.setCellValueFactory(new PropertyValueFactory<>("idCategorie"));
        c_jaime.setCellValueFactory(new PropertyValueFactory<>("jaime"));
        c_jaimepas.setCellValueFactory(new PropertyValueFactory<>("jaimepas"));
        c_jaimepas.setCellValueFactory(new PropertyValueFactory<>("views"));
                

        c_image.setCellFactory(param -> {
            //Set up the ImageView
            final ImageView imageview = new ImageView();

            imageview.setFitHeight(100);
            imageview.setFitWidth(100);
            //Set up the Table
            TableCell<Forum, String> cell = new TableCell<Forum, String>() {
                public void updateItem(String item, boolean empty) {
                    if (item != null && !item.isEmpty()) {
                        System.out.println(getClass().getResourceAsStream("resources/" + item));

                if(getClass().getResourceAsStream("resources/" + item) != null)
                 imageview.setImage(new Image(getClass().getResourceAsStream("resources/" + item)));
              //          imageview.setImage(new Image(item));
                        setGraphic(imageview);
                    } else 
                    {
                        setGraphic(null);
                        setText(null);
                    }
                }
            };
            // Attach the imageview to the cell
            
            return cell;
        });
        c_image.setCellValueFactory(new PropertyValueFactory<>("image"));
        c_action.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        cb_category.getItems().setAll(sc.getAll());
        
        myTransport.setAll(sh.getAll());
        tc_table.getItems().setAll(myTransport);
    }*/
    @FXML
    private void onClickAdd(ActionEvent event) {

        if (!txtNomArticle.getText().equals("") || !txt_image.getText().equals("") || !txtDescription.getText().equals("") && cb_category.getSelectionModel().getSelectedItem() != null) {
            h.setNomA(txtNomArticle.getText());
            h.setImageh(txt_image.getText());
            h.setDiscriptionA(txtDescription.getText());
            h.setIdCategorie(cb_category.getSelectionModel().getSelectedItem().getIdC());

            sh.ajouter(h);
            onClickReset(event);
            //loadData();
            t_success.setText("Article Created Successfully !");
        } else {
            t_erreur.setText("Please verify all fields !!!");
        }

    }

    @FXML
    private void onClickReset(ActionEvent event) {

        txtNomArticle.setText("");
        txtDescription.setText("");
        txt_image.setText("");
        txtSearch.setText("");
        t_erreur.setText("");
        cb_category.getSelectionModel().clearSelection();
    }

}
