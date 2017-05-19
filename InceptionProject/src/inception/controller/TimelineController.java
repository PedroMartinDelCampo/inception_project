/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.controller;

import inception.model.Frame;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 *
 * @author Humberto
 */
public class TimelineController {

    @FXML
    private GridPane gridPane; 
    
    @FXML
    private Rectangle timeline;
    
    public int fila = 2;
    public int i;
    
    @FXML
    public void addTimeline(){
        System.out.println("clicked on add");
        i = fila;
        Label nombre = new Label("Timeline " + (fila-1));
        timeline = new Rectangle();
        timeline.setHeight(30);
        timeline.setWidth(100);
        timeline.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        timeline.setOnMouseClicked((MouseEvent t) -> {
            editPropertiesTimeline();   
        });
        gridPane.add(timeline,1,fila++);
        gridPane.add(nombre,0,i);
    }
    
    @FXML
    public void deleteTimeline(){
        System.out.println("clicked on delete");
        gridPane.getChildren().remove(1);
    }
    
    public void editPropertiesTimeline(){
        timeline.setFill(Color.RED);        
    }
    
    public void editIntervalTimeline(){
        
    }
    
    
}
