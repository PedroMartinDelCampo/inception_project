/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Duration;

/**
 *
 * @author Pedro
 */
public class DummyStimulus extends Stimulus {
    
    @Override
    public Duration getLength() {
        return Duration.seconds(10);
    }

    @Override
    public void execute() {
        System.out.println("Play");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DummyStimulus.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Done");
    }

    @Override
    public void end() {
        System.out.println("Stop");
    }
    
}
