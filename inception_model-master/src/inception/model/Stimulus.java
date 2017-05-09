/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

import javafx.animation.Animation;
import javafx.util.Duration;

/**
 *
 * @author Pedro
 */
public abstract class Stimulus implements Animatable {
    
    private Duration start = Duration.ZERO;

    public Duration getStart() {
        return start;
    }

    public void setStart(Duration start) {
        this.start = start;
    }

    public abstract Duration getLength();
    
}
