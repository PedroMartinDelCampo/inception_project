/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.controller;

import inception.ServiceContainer;
import inception.model.Frame;
import inception.model.StoryBuilder;
import inception.plugin.PluginManager;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author Humberto
 */
public class FrameController implements Initializable {
    
    private final StoryBuilder builder = StoryBuilder.getInstance();
    private final PluginManager pluginManager = ServiceContainer.getInstance().getPluginManager();
    
    @FXML
    private ListView listView;
    
    @FXML 
    private Button addFrame;
    
     @FXML
    private Rectangle timeline;
    
   
     
     
    @FXML
    public void addFrame(){
        System.out.println("clicked on +");
        int index = builder.addFrame();
        Button selectFrameButton = new Button("Frame " + index);
        selectFrameButton.setOnAction((ActionEvent event) -> {
            openFrame(index);
        });
        listView.getItems().add("Frame " + index);        
    }
    
    public void deleteFrame(){
        System.out.println("clicked on -");
        
        int index = builder.deleteFrame();
        if( index <= -1){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No has seleccionado ningun frame");
            alert.show();
        }else{
            listView.getItems().remove(index);
        }
    }
   
    public void openFrame(int index){
    }
    
    public void showFrame(){
        System.out.println("clicked on frame"); 
    }
    
    public void playFrame(){
        System.out.println("Play");
        Frame frame = builder.selectedFrame();
        if(frame == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No has seleccionado ningun frame");
            alert.show();
        }
        else{
            frame.play();
        }
    }
    
    public void stopFrame(){
        Frame frame = builder.selectedFrame();
        frame.end();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            builder.selectFrame((int) newValue);
            showFrame();
        });
    }   
}
