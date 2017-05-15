/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.controller;

import inception.ServiceContainer;
import inception.model.Stimulus;
import inception.plugin.Plugin;
import inception.plugin.PluginManager;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author Humberto
 */
public class ToolbarController implements Initializable {
    
    @FXML
    private HBox toolbar;
    
    private final PluginManager pluginManager = ServiceContainer.getInstance().getPluginManager();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Collection<Plugin> plugins = pluginManager.getPlugins();
        plugins.forEach((plugin) -> {
            Button createStimulus = new Button(plugin.getLabel());
            createStimulus.setOnAction((ActionEvent event) -> {
                Stimulus s = plugin.createStimulus();
                System.out.println("Stimulus: " + s.getClass());
            });
            toolbar.getChildren().add(createStimulus);
        });
    }
    
}
