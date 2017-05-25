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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 *
 * @author Humberto
 */
public class TimelineController {

    @FXML
    private GridPane timelineGridPane;
    
    public int i = 2;
    
    private static final double TIMELINE_WIDTH = 100;
    private static final double TIMELINE_HEIGHT = 30;
    
    private TimelineView selectedTimeline;
    private int selectedIndex;
    
    @FXML
    public void addTimeline(){
        System.out.println("clicked on add");
        Label nombre = new Label("Timeline " + (i-1));
        i++;
        TimelineView timeline = new TimelineView(TIMELINE_WIDTH, TIMELINE_HEIGHT);
        timeline.setIndex(i);
        timeline.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        timeline.setOnMouseClicked((MouseEvent t) -> {
            editPropertiesTimeline();   
            timeline.setFill(Color.RED); 
            selectedTimeline = timeline;
            selectedIndex=i;
            System.out.println("clicked on add" + selectedIndex);
        });
        timelineGridPane.add(nombre, 0, i);
        timelineGridPane.add(timeline, 1, i);
        
    }
    
    @FXML
    public void deleteTimeline(){
        System.out.println("clicked on delete");
        if (selectedTimeline == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No has seleccionado ningun timeline");
        } else {
            timelineGridPane.getChildren().remove(selectedTimeline);
            timelineGridPane.getChildren().remove(0,selectedIndex-2);
        }
    }
    
    public void editPropertiesTimeline(){     
    }
    
    public void editIntervalTimeline(){
        
    }
    
    
}
