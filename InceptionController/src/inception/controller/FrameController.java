/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.controller;

import java.awt.event.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
/**
 *
 * @author Humberto
 */
public class FrameController {
    
    @FXML
    private ListView listView;
    
    private void initialize(){
         
     }

    public void addFrame(){
        
    }
    
    public void deleteFrame(){
        
    }
    
    public void openFrame(MouseEvent event){
        System.out.println("clicked on ");
        
    }
    
    public void showFrame(){
        if(preview != null){
            MediaView mediaview = new MediaView();
            previewPane.getChildren().add(mediaview);
        }
        else{
            MediaView mediaview = new MediaView();
            previewPane.getChildren().add(mediaview); 
        }
       
    }
    
    public void playFrame(){
        
    }
    
    public void stopFrame(){
        
    }
    
    
}
