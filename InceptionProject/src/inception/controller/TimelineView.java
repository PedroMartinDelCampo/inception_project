/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.controller;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author Humberto
 */
public class TimelineView extends Rectangle {
    private int index;

    public TimelineView(double width, double height) {
        super(width, height);
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    
    
}
