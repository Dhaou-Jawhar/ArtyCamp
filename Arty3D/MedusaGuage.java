/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arty3D;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import eu.hansolo.medusa.TickLabelOrientation;
import eu.hansolo.medusa.skins.ModernSkin;
import eu.hansolo.medusa.skins.SpaceXSkin;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MedusaGuage extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Gauge gauge = new Gauge(); 
        Button btn = new Button();
        btn.setText("Say 'Validation'");
        btn.setTranslateX(10);
        btn.setTranslateY(200);
        
        //button click action handler
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Validation!");
                gauge.setAnimated(true);
                gauge.setValue(90.00);
            }
        });
        
         
         gauge.setSkin(new ModernSkin(gauge));  
         gauge.setTitle("Arty CAMP");  //title
         gauge.setUnit("Km / h");  //unit
         gauge.setUnitColor(Color.WHITE);
         gauge.setDecimals(0);  
         gauge.setValue(50.00); 
         gauge.setAnimated(true);
         //gauge.setAnimationDuration(500);

         gauge.setValueColor(Color.WHITE);  
         gauge.setTitleColor(Color.WHITE);  
         gauge.setSubTitleColor(Color.WHITE);  
         gauge.setBarColor(Color.rgb(0, 214, 215));  
         gauge.setNeedleColor(Color.RED);  
         gauge.setThresholdColor(Color.RED);  //color will become red if it crosses thereshold value
         gauge.setThreshold(85);
         gauge.setThresholdVisible(true);
         gauge.setTickLabelColor(Color.rgb(151, 151, 151));  
         gauge.setTickMarkColor(Color.WHITE);  
         gauge.setTickLabelOrientation(TickLabelOrientation.ORTHOGONAL); 
        
        
        
        StackPane root = new StackPane();
        root.getChildren().addAll(gauge);
        root.getChildren().addAll(btn);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Arty Camp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
