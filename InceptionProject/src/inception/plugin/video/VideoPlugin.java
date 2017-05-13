/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.plugin.video;

import inception.model.Stimulus;
import inception.plugin.Plugin;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 *
 * @author Fernando Flores García
 */
public class VideoPlugin implements Plugin{

    @Override
    public String getLabel() {
        return "Video Plugin";
    }

    @Override
    public Stimulus createStimulus() {
        return new VideoStimulus();
    }

    @Override
    public Node createPreview(Stimulus s) {
        VideoStimulus video = (VideoStimulus) s;
        Media media = new Media(video.getSource());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        MediaControl mediaView = new MediaControl(mediaPlayer);
        return mediaView;
    }

    @Override
    public Node createPropertiesPane(Stimulus s) {
        VideoStimulus video = (VideoStimulus) s;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(VideoPlugin.class.getResource("PropertiesPane.fxml"));
        Node propertiesPane;
        try {
            propertiesPane = loader.load();
        } catch (IOException ex) {
            return new AnchorPane();
        }
        PropertiesPaneController controller = loader.getController();
        controller.setVideo(video);
        return propertiesPane;
    }

    @Override
    public Class getStimulusClass() {
        return VideoStimulus.class;
    }
    
}
