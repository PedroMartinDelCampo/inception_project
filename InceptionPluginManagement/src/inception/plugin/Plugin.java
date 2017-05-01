/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.plugin;

import inception.model.Stimulus;
import javafx.scene.Node;

/**
 *
 * @author Pedro
 */
public interface Plugin {
    
    String getLabel();
    Stimulus createStimulus();
    Node createPreview(Stimulus s);
    Node createPropoertiesPane(Stimulus s);
    Class getStimulusClass();
    
}
