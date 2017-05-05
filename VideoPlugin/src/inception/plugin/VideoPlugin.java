/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.plugin;

import inception.model.Stimulus;
import inception.plugin.Plugin;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


/**
 *
 * @author Fernando Flores García
 */
public class VideoPlugin implements Plugin{
    
    private VideoStimulus videoStimulus;
    private VBox contentPane = new VBox();
    private static final String MEDIA_URL =
 "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

    @Override
    public String getLabel() {
        return "Video Plugin";
    }

    @Override
    public Stimulus createStimulus() {
        return videoStimulus;
    }

    @Override
    public Node createPreview(Stimulus s) {
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        
        MediaControl mediaView = new MediaControl(mediaPlayer);
        
        //contentPane.getChildren().add(mediaView);
        
        return mediaView;
    }

    @Override
    public Node createPropertiesPane(Stimulus s) {
        final TextField textField = new TextField();
        return textField;
    }

    @Override
    public Class getStimulusClass() {
        return VideoStimulus.class;
    }
    
    public String getMediaSource(){
        return videoStimulus.getSource();
    }
    
}
