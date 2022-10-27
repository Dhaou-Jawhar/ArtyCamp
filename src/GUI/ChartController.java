/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.EventService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Ben Nasr
 */
public class ChartController implements Initializable {

    @FXML
    private Pane chart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EventService es = new EventService();
        List <Integer> montant= es.getAllEvMont();
        List <String> titre= es.getAllEvTitle();
        
        
        
        ObservableList<PieChart.Data> List=FXCollections.observableArrayList();
       
        
        for (int i = 0; i < montant.size(); i++) {
           List.add (new PieChart.Data (titre.get(i), montant.get(i)));
        }
        
        PieChart pCharte= new PieChart (List);
        chart.getChildren().add(pCharte) ;
    }    
    
}
