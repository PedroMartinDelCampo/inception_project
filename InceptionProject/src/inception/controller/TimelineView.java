/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.controller;

import inception.model.Stimulus;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Humberto
 */
public class TimelineView extends Rectangle {
    private int index;
    private String Label;
    private Stimulus stimulus;

    public Stimulus getStimulus() {
        return stimulus;
    }

    public void setStimulus(Stimulus stimulus) {
        this.stimulus = stimulus;
    }

    public TimelineView(double width, double height) {
        super(width, height);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String Label) {
        this.Label = Label;
    }
    
    
    
    
    
    
    
}
