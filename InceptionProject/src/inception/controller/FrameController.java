/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.controller;

import inception.model.Frame;
import inception.model.StoryBuilder;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
/**
 *
 * @author Humberto
 */
public class FrameController implements Initializable {
    
    private final StoryBuilder builder = StoryBuilder.getInstance();
    
    @FXML
    private ListView listView;
    
    public void addFrame(){
        int index = builder.addFrame();
        Button selectFrameButton = new Button("Frame " + index);
        selectFrameButton.setOnAction((ActionEvent event) -> {
            openFrame(index);
        });
        listView.getItems().add("Frame " + index);
    }
    
    public void deleteFrame(){
        
    }
    
    public void openFrame(int index){
        System.out.println("clicked on ");
        
    }
    
    public void showFrame(){
        /*
        if(preview != null){
            MediaView mediaview = new MediaView();
            previewPane.getChildren().add(mediaview);
        }
        else{
            MediaView mediaview = new MediaView();
            previewPane.getChildren().add(mediaview); 
        }
        */
       
    }
    
    public void playFrame(){
        Frame frame = builder.selectedFrame();
        frame.play();
    }
    
    public void stopFrame(){
        Frame frame = builder.selectedFrame();
        frame.end();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    
}