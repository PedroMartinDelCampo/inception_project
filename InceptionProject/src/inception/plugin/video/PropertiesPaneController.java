/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.plugin.video;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class PropertiesPaneController implements Initializable {
    
    private VideoStimulus video;
    private FileChooser chooser;
    
    @FXML
    private TextField path;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chooser = new FileChooser();
        chooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Videos", "*.mp4", "*.flv"));
    }

    public void setVideo(VideoStimulus video) {
        this.video = video;
    }
    
    @FXML
    private void changePath() {
        File file = chooser.showOpenDialog(null);
        if (file != null) {
            path.setText(file + "");
        }
    }
    
}
