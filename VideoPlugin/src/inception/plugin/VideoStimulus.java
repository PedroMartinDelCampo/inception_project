/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.plugin;

import inception.model.Stimulus;
import javafx.util.Duration;

/**
 *
 * @author Fernando Flores García
 */
public class VideoStimulus extends Stimulus{
    
    private String source; //The source direction where it looks for the video
    private int duration, minutes, seconds;

    @Override
    public Duration getLength() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void end() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSource() {
        return source;
    }
    
    
    
    
}
