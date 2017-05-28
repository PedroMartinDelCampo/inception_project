/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.plugin;

import inception.model.DummyStimulus;
import inception.model.Stimulus;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
/**
 *
 * @author Fernando Flores García
 */
public class TestPlugin implements Plugin {
    private String fieldText; 
    
    private static final String MEDIA_URL =
 "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
    
    @Override
    public String getLabel() {
        return "Name Of the Plugin";
    }

    @Override
    public Stimulus createStimulus() {
        // we import and use a dummystimulus
        return new DummyStimulus();
    }

    @Override
    public Node createPreview(Stimulus s) {
        Text t = new Text(10, 50, "This is a test of the preview");
        return t;
    }

    @Override
    public Node createPropertiesPane(Stimulus s) {
        final TextField textField = new TextField();
        
        
        textField.focusedProperty().addListener(
                (ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue)
            {
                System.out.println("Textfield on focus");
            }
            else
            {
                System.out.println("Textfield out focus");
                fieldText = textField.getText();
            }
        });
        return textField;
    }

    @Override
    public Class getStimulusClass() {
        return DummyStimulus.class;
    }
    
}
