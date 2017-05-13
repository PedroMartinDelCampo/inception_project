/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.plugin.video;

import inception.model.Stimulus;
import javafx.scene.media.Media;
import javafx.util.Duration;

/**
 *
 * @author Fernando Flores García
 */
public class VideoStimulus extends Stimulus{
    
    private String source; //The source direction where it looks for the video
    private Duration length;
    private static final String DEFAULT_MEDIA_URL =
 "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
    
    public VideoStimulus() {
        setSource(DEFAULT_MEDIA_URL);
    }
    
    @Override
    public Duration getLength() {
        return length;
    }

    @Override
    protected void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void end() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public final void setSource(String source) {
        this.source = source;
        length = new Media(source).getDuration();
    }
    
    public String getSource() {
        return source;
    }
    
}
